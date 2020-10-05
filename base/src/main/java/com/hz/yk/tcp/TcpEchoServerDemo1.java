package com.hz.yk.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wuzheng.yk
 * @date 2020/10/3
 */
public class TcpEchoServerDemo1 {

    static int port = 8980;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        byte[] byteBuffer = new byte[1024];
        int recvMsgSize;
        while (true) {
            System.out.println("start server socket");
            final Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            final OutputStream outputStream = socket.getOutputStream();
            while ((recvMsgSize = inputStream.read(byteBuffer)) != -1) {

                outputStream.write(byteBuffer, 0, recvMsgSize);
            }
            socket.close();
        }

    }

}
