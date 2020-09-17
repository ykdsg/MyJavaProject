package com.hz.yk.tcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wuzheng.yk
 * @date 2020/9/14
 */
public class TCPEchoServerThread {

    private static final Logger log = LoggerFactory.getLogger(TCPEchoServerThread.class);

    public static void main(String[] args) throws IOException {
        int serverPort = 8909;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        while (true) {
            Socket clntSock = serverSocket.accept();

            //可以考虑使用线程池的方案
            Thread thread = new Thread(new EchoProtocol(clntSock));
            thread.start();
            log.info("created and started thread " + thread.getName());
        }

    }

}
