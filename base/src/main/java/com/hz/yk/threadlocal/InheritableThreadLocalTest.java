package com.hz.yk.threadlocal;

import org.junit.jupiter.api.Test;

/**
 * @author wuzheng.yk
 * @date 2020/6/18
 */
public class InheritableThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
    private static ThreadLocal t1 = new InheritableThreadLocal<>();
    private static ThreadLocal<DemoObj> t2 = new InheritableThreadLocal<>();

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

    /**
     * 子线程写入后会覆盖掉主线程的变量，也是通过这个结果，我们确认了子线程 TLMap 里变量指向的对象和父线程是同一个。
     * 在使用线程池的时候，ITL 会完全失效，因为父线程的 TLMap 是通过 init 一个 Thread 的时候进行赋值给子线程的，而线程池在执行异步任务时可能不再需要创建新的线程了，因此也就不会再传递父线程的 TLMap 给子线程了。
     *
     * @throws InterruptedException
     */
    @Test
    public void test1() throws InterruptedException {
        t1.set(1);

        DemoObj obj = new DemoObj();
        obj.setName("main-name");
        t2.set(obj);

        fc();
        new Thread(() -> {
            final DemoObj tObj = t2.get();
            tObj.setName("kk");
            fc();
        }).start();
        Thread.sleep(500);
        fc();
    }

    private static void fc() {
        System.out.println(
                String.format("当前线程名称: %s, fc方法内获取线程内数据为: t1 = %s，t2.name = %s", Thread.currentThread().getName(),
                              t1.get(), t2.get().getName()));
    }
}
