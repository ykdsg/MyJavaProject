package com.hz.yk.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

/**
 * @author wuzheng.yk
 * @date 2020/10/3
 */
public class TcpEchoClientDemo1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8980;

        Socket socket = new Socket("127.0.0.1", port);
        Thread.sleep(3000L);

        final InputStream inputStream = socket.getInputStream();
        final OutputStream outputStream = socket.getOutputStream();

        String msg = "hello ,你好：" + Thread.currentThread();
        outputStream.write(msg.getBytes());
        int recvMsgSize;
        byte[] byteBuffer = new byte[1024];
        while ((recvMsgSize = inputStream.read(byteBuffer)) != -1) {
            final byte[] bytes = Arrays.copyOfRange(byteBuffer, 0, recvMsgSize);
            System.out.println(new String(bytes));
        }
    }

}
