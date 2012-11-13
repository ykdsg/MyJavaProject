package com.hz.yk.mina;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @author yangke
 *         Date: 12-8-30
 *         Time: 下午4:48
 */
public class MessageSendServer {
    private static final int port = 11111;
    public static void main(String[]args) throws IOException {
        //服务端监听端口用
        IoAcceptor acceptor = new NioSocketAcceptor();
        //日志filter
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        //对象序列化工厂，用来将java对象序列化成二进制流
        acceptor.getFilterChain().addLast(
                "Objectcodec",
                new ProtocolCodecFilter(
                        (ProtocolCodecFactory) new ObjectSerializationCodecFactory()));
        //业务处理handler
        acceptor.setHandler(new ServerHandler());
        //设置监听端口
        acceptor.setDefaultLocalAddress(new InetSocketAddress(port));
        //开启了监听accptor
        acceptor.bind();

        System.out.println("Server starts to listen to PORT :"+port);

    }

}
