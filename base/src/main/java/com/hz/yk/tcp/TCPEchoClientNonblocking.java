package com.hz.yk.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author wuzheng.yk
 * @date 2020/9/14
 */
public class TCPEchoClientNonblocking {

    public static void main(String[] args) throws IOException {
        String server = "localhost";
        int serverPort = 8798;

        byte[] argument = "hello world".getBytes();
        SocketChannel clntChan = SocketChannel.open();
        clntChan.configureBlocking(false);
        if (!clntChan.connect(new InetSocketAddress(server, serverPort))) {
            while (!clntChan.finishConnect()) {
                System.out.println(".");
            }
        }
        ByteBuffer writeBuf = ByteBuffer.wrap(argument);
        ByteBuffer readBuf = ByteBuffer.allocate(argument.length);

        int totalBytesRcvd = 0;
        int bytesRcvd;
        while (totalBytesRcvd < argument.length) {
            if (writeBuf.hasRemaining()) {
                clntChan.write(writeBuf);
            }
            if ((bytesRcvd = clntChan.read(readBuf)) == -1) {
                throw new SocketException("connection closed prematurely");
            }
            totalBytesRcvd += bytesRcvd;
            System.out.println(".");
        }
        System.out.println("received:" + new String(readBuf.array(), 0, totalBytesRcvd));
        clntChan.close();
        
    }

}
