package com.hz.yk.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @author wuzheng.yk
 * @date 2020/9/11
 */
public class TCPEchoClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        String server = "127.0.0.1";
        int serverPort = 8909;
        byte[] data = "hello socket".getBytes(StandardCharsets.UTF_8);

        Socket socket = new Socket(server, serverPort);
        Thread.sleep(10000L);
        System.out.println("connected to server ...");
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write(data);
        int totalBytesRcvd = 0;
        int bytesRcvd;
        //只是书上的例子，这里的处理有点搓，实际场景应该用一个缓冲区来读取
        while (totalBytesRcvd < data.length) {
            if ((bytesRcvd = in.read(data, totalBytesRcvd, data.length - totalBytesRcvd)) == -1) {
                throw new SocketException("connection closed prematurely");
            }
            totalBytesRcvd += bytesRcvd;
        }
        System.out.println("received:" + new String(data));
        socket.close();

    }

}
