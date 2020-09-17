package com.hz.yk.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @author wuzheng.yk
 * @date 2020/9/11
 */
public class TcpEchoServer {

    private static final int BUF_SIZE = 32;

    public static void main(String[] args) throws IOException {
        int serverPort = 8909;
        ServerSocket servSock = new ServerSocket(serverPort);

        int recvMsgSize;
        byte[] receiveBuf = new byte[BUF_SIZE];
        while (true) {
            Socket clnSock = servSock.accept();
            //查看连接上来的client相应的地址和端口号
            SocketAddress clientAddress = clnSock.getRemoteSocketAddress();
            System.out.println("handling client at " + clientAddress);

            InputStream in = clnSock.getInputStream();
            OutputStream out = clnSock.getOutputStream();
            while ((recvMsgSize = in.read(receiveBuf)) != -1) {
                out.write(receiveBuf, 0, recvMsgSize);
            }
            clnSock.close();

        }
    }

}
