package com.hz.yk.fockjoin;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import static org.junit.Assert.assertEquals;

/**
 * ForkJoinTask是分支合并的执行任何，分支合并的业务逻辑使用者可以再继承了这个抽先类之后，在抽象方法exec()中实现。<br>
 * 其中exec()的返回结果和ForkJoinPool的执行调用方（execute(...),invoke(...),submit(...)），共同决定着线程是否阻塞 <br>
 * execute：异步执行，无视task.exec()的结果 <br>
 * invoke：等待获取结果，task.exec()返回值是false，则阻塞，直到另一个线程调用了task.complete(...) <br>
 * submit：异步执行，返回ForkJoinTask，ForkJoinTask.get() 受task.exec()影响，false，则阻塞，直到另一个线程调用了task.complete(...) <br>
 * Created by wuzheng.yk on 2017/6/30.
 */
public class ForkJoinTest {

    @Test public void testForkJoinInvoke() throws InterruptedException, ExecutionException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyForkJoinTask<String> task = new MyForkJoinTask<String>();
        task.setSuccess(true);
        task.setRawResult("test");
        String invokeResult = forkJoinPool.invoke(task);
        assertEquals(invokeResult, "test");
    }

    @Test public void testForkJoinInvoke2() throws InterruptedException, ExecutionException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<String>();
        new Thread(new Runnable() {

            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                task.complete("test");
            }
        }).start();

        // exec()返回值是false，此处阻塞，直到另一个线程调用了task.complete(...)
        String result = forkJoinPool.invoke(task);
        System.out.println(result);
    }

    @Test public void testForkJoinSubmit() throws InterruptedException, ExecutionException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<String>();

        task.setSuccess(true); // 是否在此任务运行完毕后结束阻塞
        ForkJoinTask<String> result = forkJoinPool.submit(task);
        result.get(); // 如果exec()返回值是false，在此处会阻塞，直到调用complete
        System.out.println("end......");
    }

    @Test public void testForkJoinSubmit2() throws InterruptedException, ExecutionException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<String>();

        forkJoinPool.submit(task);
        Thread.sleep(1000);
    }

    @Test public void testForkJoinSubmit3() throws InterruptedException, ExecutionException {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        final MyForkJoinTask<String> task = new MyForkJoinTask<String>();
        new Thread(new Runnable() {

            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }

                task.complete("test");
            }
        }).start();

        ForkJoinTask<String> result = forkJoinPool.submit(task);
        // exec()返回值是false，此处阻塞，直到另一个线程调用了task.complete(...)
        result.get();
        Thread.sleep(1000);
    }

    @Test public void testForkJoinExecute() throws InterruptedException, ExecutionException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyForkJoinTask<String> task = new MyForkJoinTask<String>();
        forkJoinPool.execute(task); // 异步执行，无视task.exec()返回值。
    }
}
