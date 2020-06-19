package com.hz.yk.threadlocal;

/**
 * @author wuzheng.yk
 * @date 2020/6/18
 */
public class InheritableThreadLocalTest {

    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static String get() {
        return threadLocal.get();
    }

    public static void set(String value) {
        threadLocal.set(value);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            //可以在父子线程间传递
            InheritableThreadLocalTest.set("ye");
            Thread t = new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":" + InheritableThreadLocalTest.get());
                }
            });

            t.start();
        }
    }

}
