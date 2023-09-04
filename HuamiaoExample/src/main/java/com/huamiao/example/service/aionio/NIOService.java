package com.huamiao.example.service.aionio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/9/1
 * @since 1.0.0
 */
@Slf4j
public class NIOService {
    
    private static final int port = 8000;

    static class MultiThreadEchoServer{

        class HandleMessage implements Runnable{

            private SelectionKey selectionKey;
            private ByteBuffer byteBuffer;

            public HandleMessage(SelectionKey selectionKey, ByteBuffer byteBuffer){

                this.selectionKey = selectionKey;
                this.byteBuffer = byteBuffer;
            }

            @Override
            public void run() {
                EchoClient echoClient = (EchoClient)selectionKey.attachment();
                echoClient.enqueue(byteBuffer);

                selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                selector.wakeup();
            }
        }

        class EchoClient {

            LinkedList<ByteBuffer> bbs = new LinkedList<>();

            public LinkedList<ByteBuffer> getDataQueue(){
                return bbs;
            }

            public void enqueue(ByteBuffer byteBuffer){
                bbs.add(byteBuffer);
            }

        }

        private Selector selector;
        private ExecutorService executorService = Executors.newCachedThreadPool();

        public void startUp() throws IOException {

            selector = SelectorProvider.provider().openSelector();
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.bind(new InetSocketAddress("localhost", port));
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            for (;;){
                if (!selector.isOpen()) break;
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isAcceptable()){
                        doAccept(selectionKey);
                    } else if(selectionKey.isValid() && selectionKey.isReadable()){
                        doRead(selectionKey);
                    } else if(selectionKey.isValid() && selectionKey.isWritable()){
                        doWrite(selectionKey);
                    }
                }
            }
        }

        private void doWrite(SelectionKey selectionKey) throws IOException {
            SocketChannel client = (SocketChannel) selectionKey.channel();
            EchoClient echoClient = (EchoClient) selectionKey.attachment();

            LinkedList<ByteBuffer> dataQueue = echoClient.getDataQueue();
            ByteBuffer bb = dataQueue.getLast();

            int len = client.write(bb);
            if(len == -1){
                disconnect(selectionKey);
                return;
            }

            if (bb.remaining() == 0){
                dataQueue.removeLast();
            }

            if (dataQueue.size() == 0){
                selectionKey.interestOps(SelectionKey.OP_READ);
            }

        }

        private void disconnect(SelectionKey selectionKey) {
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            try {
                channel.close();
            } catch (IOException e) {
                log.warn("Failed to close client socket channel.");
                throw new RuntimeException(e);
            }
        }

        private void doRead(SelectionKey selectionKey) {
            try{
                SocketChannel channel = (SocketChannel) selectionKey.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(8192);
                channel.read(byteBuffer);
                System.out.println("客户端请求数据：" + new String(byteBuffer.array()).trim());
                byteBuffer.flip();
                executorService.execute(new HandleMessage(selectionKey, byteBuffer));
            }catch (Exception e){
                log.warn("读取客户端数据异常", e);
            }
        }

        private void doAccept(SelectionKey selectionKey) throws IOException {
            ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
            SocketChannel client = channel.accept();
            client.configureBlocking(false);

            SelectionKey clientKey = client.register(selector, SelectionKey.OP_READ);
            EchoClient echoClient = new EchoClient();

            clientKey.attach(echoClient);
        }


        public static void main(String[] args) throws IOException {
            new MultiThreadEchoServer().startUp();
        }

    }

    static class NIOClient {

        private Selector selector;

        public void init() throws IOException {
            selector = SelectorProvider.provider().openSelector();
            SocketChannel client = SocketChannel.open();
            client.configureBlocking(false);
            client.connect(new InetSocketAddress("localhost", port));
            client.register(selector, SelectionKey.OP_CONNECT);
        }

        public void working() throws IOException {
            while (true){
                if (!selector.isOpen())
                    break;
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iter = selectionKeys.iterator();
                while (iter.hasNext()){
                    SelectionKey selectionKey = iter.next();
                    iter.remove();
                    if (selectionKey.isConnectable()){
                        connect(selectionKey);
                    }
                    if (selectionKey.isReadable()){
                        read(selectionKey);
                    }
                }
            }

        }

        private void read(SelectionKey selectionKey) throws IOException {
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            ByteBuffer bb = ByteBuffer.allocate(16);
            channel.read(bb);
            System.out.println(new String(bb.array()).trim());
        }

        private void connect(SelectionKey selectionKey) throws IOException {
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            if (channel.isConnectionPending()) channel.finishConnect();

            channel.configureBlocking(false);
            for (int i = 0; i < 100; i++) {
                channel.write(ByteBuffer.wrap(("give you a big house"+i).getBytes()));
            }

            channel.register(selector, SelectionKey.OP_READ);
        }

        public static void main(String[] args) throws IOException {
            NIOClient client = new NIOClient();
            client.init();
            client.working();
        }
    }

}