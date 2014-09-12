package com.hz.yk.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

/**
 * @author wuzheng.yk
 *         Date: 14-8-11
 *         Time: 上午9:36
 */
public class NettyServer {
    final static int port = 8088;

    public static void main(String[] args) {
        Server server = new Server();
        server.config(port);
        server.start();
    }

}

class Server {
    ServerBootstrap bootstrap;
    Channel parentChannel;
    InetSocketAddress localAddress;
    MyChannelHandler channelHandler = new MyChannelHandler();

    Server() {
        /*
         初始化ServerBootstrap，并注入NioServerSocketChannelFactory，用于创建通道（channel）等。从这里可以看出是通过Nio的方式来处理的，factory中放入两个线程池，主要用于接收connect和message。
         */
        bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
        // 为通道以及子通道(带前缀”child.”)设置相关的属性（socket属性），此处暂不详细介绍。
        bootstrap.setOption("reuseAddress", true);
        bootstrap.setOption("child.tcpNoDelay", true);
        bootstrap.setOption("child.soLinger", 2);
        //向ChannelPipline中添加处理器（ChannelHandler），用于处理连接和消息。
        bootstrap.getPipeline().addLast("servercnfactory", channelHandler);
    }

    void config(int port) {
        this.localAddress = new InetSocketAddress(port);
    }

    void start() {
        parentChannel = bootstrap.bind(localAddress);
    }

}

class MyChannelHandler extends SimpleChannelHandler {
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("Channel closed " + e);
    }

    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("Channel connected " + e);
        Channel ch = e.getChannel();
        ChannelBuffer cb = ChannelBuffers.wrappedBuffer("success".getBytes());
        ch.write(cb);
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        try {
            System.out.println("New message " + e.toString() + " from " + ctx.getChannel());
            processMessage(e);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    private void processMessage(MessageEvent e) {
        Channel ch = e.getChannel();
        ch.write(e.getMessage());
    }
}




