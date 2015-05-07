package com.hz.yk.yk.netty;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
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
 *         Time: ����9:36
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
    ServerBufferHandler serverBufferHandler = new ServerBufferHandler();

    Server() {
        /*
         ��ʼ��ServerBootstrap����ע��NioServerSocketChannelFactory�����ڴ���ͨ����channel���ȡ���������Կ�����ͨ��Nio�ķ�ʽ�������ģ�factory�з��������̳߳أ���Ҫ���ڽ���connect��message��
         */
        bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
        // Ϊͨ���Լ���ͨ��(��ǰ׺��child.��)������ص����ԣ�socket���ԣ����˴��ݲ���ϸ���ܡ�
        bootstrap.setOption("reuseAddress", true);
        bootstrap.setOption("child.tcpNoDelay", true);
        bootstrap.setOption("child.soLinger", 2);
        //��ChannelPipline�����Ӵ�������ChannelHandler�������ڴ������Ӻ���Ϣ��
        bootstrap.getPipeline().addLast("servercnfactory", channelHandler);
        bootstrap.getPipeline().addLast("messageHandler",serverBufferHandler);
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
        super.channelConnected(ctx,e);

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
        super.messageReceived(ctx,e);
    }

    private void processMessage(MessageEvent e) {
        Channel ch = e.getChannel();
        ch.write(e.getMessage());
    }
}

class ServerBufferHandler extends SimpleChannelHandler {

    /**
     * �û����ܿͻ��˷�������Ϣ�����пͻ�����Ϣ����ʱ����
     *
     * @author lihzh
     * @alia OneCoder
     */
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        ChannelBuffer buffer = (ChannelBuffer) e.getMessage();
        // ��λ��ȡ
        while (buffer.readableBytes() >= 5) {
            ChannelBuffer tempBuffer = buffer.readBytes(5);
            System.out.println(tempBuffer.toString(Charset.defaultCharset()));
        }
        // ��ȡʣ�µ���Ϣ
        System.out.println(buffer.toString(Charset.defaultCharset()));
        super.messageReceived(ctx,e);
    }

}



