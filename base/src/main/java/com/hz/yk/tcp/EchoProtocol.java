package com.hz.yk.tcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wuzheng.yk
 * @date 2020/9/11
 */
public class EchoProtocol implements Runnable {

    private static final int BUFSIZE = 32;
    private Socket clnSock;
    private static final Logger log = LoggerFactory.getLogger(EchoProtocol.class);

    public EchoProtocol(Socket clnSock) {
        this.clnSock = clnSock;
    }

    public static void handleEchoClient(Socket clntSock) {
        try {
            InputStream inputStream = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();

            int recvMsgSize;
            int totalBytesEchoed = 0;
            byte[] echoBuffer = new byte[BUFSIZE];
            while ((recvMsgSize = inputStream.read(echoBuffer)) != -1) {
                out.write(echoBuffer, 0, recvMsgSize);
                totalBytesEchoed += recvMsgSize;
            }
            log.info("Client" + clntSock.getRemoteSocketAddress() + ", echoed " + totalBytesEchoed + " bytes.");
        } catch (IOException e) {
            log.error("[EchoProtocol-handleEchoClient]error", e);
        } finally {
            try {
                clntSock.close();
            } catch (IOException e) {
                log.error("[EchoProtocol-handleEchoClient]error", e);
            }
        }
    }

    @Override
    public void run() {

        handleEchoClient(clnSock);

    }
}
