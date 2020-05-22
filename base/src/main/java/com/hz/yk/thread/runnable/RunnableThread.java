package com.hz.yk.thread.runnable;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author wuzheng.yk
 * @date 2020/3/31
 */
public class RunnableThread {

    @Test
    //io 阻塞还是显示的running
    public void testInBlockedIOState() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        // 创建一个名为“输入输出”的线程t
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    // 命令行中的阻塞读
                    String input = in.nextLine();
                    System.out.println(input);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    IOUtils.closeQuietly(in);
                }
            }
        }, "输入输出"); // 线程的名字

        // 启动
        t.start();

        // 确保run已经得到执行
        Thread.sleep(100);

        // 状态为RUNNABLE
        assertThat(t.getState()).isEqualTo(Thread.State.RUNNABLE);
    }

    @Test
    //网络阻塞也是一样
    public void testBlockedSocketState() throws Exception {
        Thread serverThread = new Thread(new Runnable() {

            @Override
            public void run() {
                ServerSocket serverSocket = null;
                try {
                    serverSocket = new ServerSocket(10086);
                    while (true) {
                        System.out.println("start socket accept");
                        // 阻塞的accept方法
                        Socket socket = serverSocket.accept();
                        System.out.println("end socket accept");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        serverSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "socket线程"); // 线程的名字
        serverThread.start();

        // 确保run已经得到执行
        Thread.sleep(500);

        // 状态为RUNNABLE
        assertThat(serverThread.getState()).isEqualTo(Thread.State.RUNNABLE);

    }
}
