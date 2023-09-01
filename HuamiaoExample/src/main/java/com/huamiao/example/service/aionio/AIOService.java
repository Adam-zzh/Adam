package com.huamiao.example.service.aionio;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/9/1
 * @since 1.0.0
 */
@Slf4j
public class AIOService {

    static class AIOServer {
        private AsynchronousServerSocketChannel serverSocketChannel = null;
        private final Integer port = 8000;

        public AIOServer() throws IOException {
            serverSocketChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress("localhost", port));

        }

        public void startUp(){
            serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

                @Override
                public void completed(AsynchronousSocketChannel result, Object attachment) {
                    Future<Integer> writeResult = null;
                    try {
                        ByteBuffer allocate = ByteBuffer.allocate(100);
                        result.read(allocate).get(1000, TimeUnit.MILLISECONDS);
                        System.out.println(String.format("接受到客户端信息：%s", new String(allocate.array()).trim()));
                        allocate.flip();
                        writeResult = result.write(allocate);
                    } catch (Exception e){
                        log.warn("客户端连接异常：" , e);
                    } finally {
                        try {
                            serverSocketChannel.accept(null, this);
                            System.out.println(writeResult.get());
                            result.close();
                        } catch (Exception e){
                            log.warn("客户端连接异常：" , e);
                        }

                    }
                }

                @Override
                public void failed(Throwable exc, Object attachment) {

                }
            });
        }


        public static void main(String[] args) throws IOException, InterruptedException {
            AIOServer server = new AIOServer();
            server.startUp();
            // 主线程可以继续自己的行为
            while (true) {
                Thread.sleep(100000);
            }
        }

    }
    static class AIOClient {


        public static void main(String[] args) throws IOException, InterruptedException {
            final AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
            client.connect(new InetSocketAddress("localhost", 8000), null, new CompletionHandler(){
                @Override
                public void completed(Object result, Object attachment) {

                    client.write(ByteBuffer.wrap("hello!".getBytes()), null, new CompletionHandler<Integer, Object>() {
                        @Override
                        public void completed(Integer result, Object attachment) {
                            ByteBuffer allocate = ByteBuffer.allocate(8192);
                            client.read(allocate, allocate, new CompletionHandler<Integer, ByteBuffer>() {
                                @Override
                                public void completed(Integer result, ByteBuffer allocate) {
                                    allocate.flip();
                                    System.out.println(new String(allocate.array()));
                                }

                                @Override
                                public void failed(Throwable exc, ByteBuffer attachment) {

                                }
                            });
                        }

                        @Override
                        public void failed(Throwable exc, Object attachment) {

                        }
                    });
                }

                @Override
                public void failed(Throwable exc, Object attachment) {

                }
            });

            // 主线程可以继续自己的行为
            while (true) {
                Thread.sleep(100000);
            }
        }

    }
}