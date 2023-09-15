package com.huamiao.example.service.aionio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/9/15
 * @since 1.0.0
 */
@Slf4j
public class NettyServer implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new NettyServer());
        t.start();
        t.join();
    }

    @Override
    public void run() {
        InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8000);
        this.start(socketAddress);
    }

    private void start(InetSocketAddress socketAddress) {
        // 主线程组
        EventLoopGroup mainGroup = new NioEventLoopGroup(1);
        // 工作线程组
        EventLoopGroup workGroup = new NioEventLoopGroup(8);

        ServerBootstrap serverBootstrap = new ServerBootstrap()
                .group(mainGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ServerChannelInitializer())
                .localAddress(socketAddress)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        try {
            ChannelFuture future = serverBootstrap.bind(socketAddress).sync();
            log.info("服务器启动开始监听端口: {}", socketAddress.getPort());
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            //添加编解码
            socketChannel.pipeline().addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
            socketChannel.pipeline().addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
            //添加处理器
            socketChannel.pipeline().addLast(new NettyServerHandler());
        }
    }

    @Slf4j
    static class NettyServerHandler extends ChannelInboundHandlerAdapter {

        public static Map<String, ChannelHandlerContext> ctxMap = new ConcurrentHashMap<String, ChannelHandlerContext>(16);

        /**
         * 客户端连接会触发
         */
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            String clientIp = getClientIp(ctx);
            ctxMap.put(clientIp,ctx);
            log.info("有客户端进行连接：{}",clientIp);
        }

        /**
         * 客户端发消息会触发
         */
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println(ctx.channel().remoteAddress());
            String ip = getClientIp(ctx);
            System.out.printf("客户端IP:"+ip);
            String body = msg.toString();
            log.info("服务器收到消息: {}", body);
            ctx.flush();
        }


        /**
         * 发生异常触发
         */
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }

        /**
         * 主动发送消息
         *
         * @param key
         * @param cmd
         */
        public static void sendMessage(String key,String cmd){
            ChannelHandlerContext ctx = ctxMap.get(key);
            if(null!=ctx){
                ctx.write(cmd);
                ctx.flush();
            }else{
                log.error("客户端已离线:"+key);
            }

        }

        /**
         * 获取客户端ip
         * @param ctx
         * @return
         */
        private String getClientIp(ChannelHandlerContext ctx){
            InetSocketAddress ipSocket = (InetSocketAddress)ctx.channel().remoteAddress();
            String clientIp = ipSocket.getAddress().getHostAddress();
            return clientIp;
        }
    }

}