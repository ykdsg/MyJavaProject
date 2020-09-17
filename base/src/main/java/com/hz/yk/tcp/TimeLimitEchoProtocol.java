package com.hz.yk.tcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author wuzheng.yk
 * @date 2020/9/14
 */
public class TimeLimitEchoProtocol implements Runnable {

    private static final int BUFSIZE = 32;
    private static final int TIMELIMIT = 10000;

    private static final Logger log = LoggerFactory.getLogger(TimeLimitEchoProtocol.class);

    private Socket clntSock;

    public TimeLimitEchoProtocol(Socket clntSock) {
        this.clntSock = clntSock;
    }

    public static void handleEchoClient(Socket clntSock) {
        try {
            InputStream input = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();
            int recvMsgSize;
            int totalBytesEchoed = 0;
            byte[] echoBuffer = new byte[BUFSIZE];
            long endTime = System.currentTimeMillis() + TIMELIMIT;
            int timeBoundMillis = TIMELIMIT;

            clntSock.setSoTimeout(timeBoundMillis);
            //试图将服务时间限制在特定时间内
            while ((timeBoundMillis > 0) && ((recvMsgSize = input.read(echoBuffer)) != -1)) {
                out.write(echoBuffer, 0, recvMsgSize);
                totalBytesEchoed += recvMsgSize;
                timeBoundMillis = (int) (endTime - System.currentTimeMillis());
                clntSock.setSoTimeout(timeBoundMillis);

            }
            log.info("Client" + clntSock.getRemoteSocketAddress() + ", echoed " + totalBytesEchoed + " bytes.");

        } catch (IOException e) {
            log.error("[TimeLimitEchoProtocol-handleEchoClient]error", e);
        }
    }

    @Override

    public void run() {
        handleEchoClient(clntSock);
    }
}
