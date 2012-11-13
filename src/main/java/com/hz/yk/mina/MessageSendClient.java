package com.hz.yk.mina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.Calendar;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * @author yangke
 *         Date: 12-8-30
 *         Time: ÏÂÎç5:23
 */
public class MessageSendClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        NioSocketConnector connector = new NioSocketConnector();
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast(
                "Objectcodec",
                new ProtocolCodecFilter((ProtocolCodecFactory) new ObjectSerializationCodecFactory()));
        connector.setConnectTimeoutMillis(3000);
        connector.setHandler(new ClientHandler());
        ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1",
                11111));

        cf.awaitUninterruptibly();

        IoSession session = cf.getSession();
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        long count =0;
        while(true){
            String input =systemIn.readLine();
            Message msg = new Message();
            if(input==""||"quit".equalsIgnoreCase(input.trim())){
                msg.setContent(input);
                WriteFuture future =session.write(msg);
                future.awaitUninterruptibly(3000);
                System.out.println("send quit cmd successfully");
                session.getCloseFuture().awaitUninterruptibly();
                connector.dispose();
                System.exit(0);
            }

            msg.setContent(input);
            msg.setId(count);
            msg.setDate(Calendar.getInstance().getTime());
            count++;
            WriteFuture future = session.write(msg);
            future.awaitUninterruptibly(3000);
            System.out.println("send "+msg.getId()+ "  successfully");
            Thread.sleep(10000);
        }

    }

}
