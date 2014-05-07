package com.hz.yk.concurrent.lock;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author wuzheng.yk
 *         Date: 13-11-9
 *         Time: ÏÂÎç4:25
 */
public class ThreadFactory {

    public static Thread createThread(final TestCallBack call) {
        return new Thread("XThread") {
            @Override
            public void run() {
                File file = new File("/dev/urandom"); // ¶ÁÈ¡linuxºÚ¶´
                try {
                    FileInputStream in = new FileInputStream(file);
                    byte[] bytes = new byte[1024];
                    while (in.read(bytes, 0, 1024) > 0) {
                        if (Thread.interrupted()) {
                            System.out.println("if throw thread interrupted.......");
                            throw new InterruptedException("");
                        }
                        System.out.println(bytes[0]);
                        Thread.sleep(100);
                        long start = System.currentTimeMillis();
                        System.out.println("call back...");
                        call.callback();
                        System.out.println("begin sleep...");
                        Thread.sleep(300);
                        System.out.println(call.getName() + " callback finish cost : " + (System.currentTimeMillis() - start));
                    }
                } catch (Exception e) {
                    System.out.println("throw exception....:"+Thread.currentThread().getName());
                    e.printStackTrace();
                }
            }

        };
    }
}
