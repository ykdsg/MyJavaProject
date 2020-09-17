package com.hz.yk.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wuzheng.yk
 * @date 2020/9/14
 */
public class TCPEchoServerExecutor {

    public static void main(String[] args) throws IOException {
        int serverPort = 8090;
        ServerSocket serverSocket = new ServerSocket(serverPort);

        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clntSock = serverSocket.accept();
            executorService.execute(new EchoProtocol(clntSock));
        }

    }

}
