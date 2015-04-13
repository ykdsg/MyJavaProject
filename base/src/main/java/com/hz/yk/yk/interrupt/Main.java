package com.hz.yk.yk.interrupt;

/**
 * @author ykdsg
 *         Date: 11-11-4
 *         Time: 下午10:35
 */
public class Main {
    public static void main(String args[]) throws Exception {
        final InterruptRead test = new InterruptRead();
        Thread t = new Thread() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                try {
                    System.out.println("InterruptRead start!");
                    test.execute();
                } catch (InterruptedException e) {
                    System.out.println("InterruptRead end! cost time : " + (System.currentTimeMillis() - start));
                    e.printStackTrace();
                }
            }
        };
        t.start();
        // 先让Read执行300豪秒
        Thread.sleep(300);
        // 发出interrupt中断
        t.interrupt();
        System.out.println("is over");

//        System.out.println(System.getProperty("user.dir"));
//
//        System.out.println(Main.class.getClassLoader().getResource("").getPath());
    }
}
