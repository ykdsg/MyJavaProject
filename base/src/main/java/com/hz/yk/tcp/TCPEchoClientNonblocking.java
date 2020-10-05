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
        //由于该套接字是非阻塞式的,因此对 connect()方法的调用可能会在连接建立之前返回, 如果在返回前已经成功建立了连接,则返回 true,否则返回 false。对于后一种情况,任何试图发送或接收数据的操作都将抛出 NotYetConnectedException 异常,因此,我们通过持续调用 finishConnect()方法来"轮询"连接状态,该方法在连接成功建立之前一直返回 false。不过, 这种忙等的方法非常浪费系统资源,这里这样做只是为了演示该方法的使用。
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
