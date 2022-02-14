package com.hz.yk.concurrent.future;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * @author wuzheng.yk
 * @date 2022/2/14
 */
public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ExecutorService executor = Executors.newFixedThreadPool(1);
        ExecutorService executor = Executors.newFixedThreadPool(1, new ThreadFactory() {

            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread thread = new Thread(r);
                //如果设置为守护进程，那么执行完之后main 函数能够自动退出，如果设置为false ，需要手动停止。
                thread.setDaemon(true);
                thread.setName("DemoTestThread-" + thread.getId());
                return thread;
            }
        });
        Result result = new Result();
        result.setA(1);
        //提交Runnable 任务及结果引用的经典用法
        final Future<Result> resultFuture = executor.submit(new Task(result), result);
        final Result futureResult = resultFuture.get();
        System.out.println("result == futureResult: " + (result == futureResult));
        System.out.println("b=" + futureResult.getB());
        //executor.shutdown();
    }

    static class Task implements Runnable {

        Result result;

        public Task(Result result) {
            this.result = result;
        }

        @Override
        public void run() {
            System.out.println("current a=" + result.getA());
            result.setB(6);

        }
    }

    static class Result {

        private int a, b;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
}

