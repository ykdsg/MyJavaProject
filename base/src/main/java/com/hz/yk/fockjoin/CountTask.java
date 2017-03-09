package com.hz.yk.fockjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by wuzheng.yk on 17/2/23.
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 3061534677916303733L;

    /**
     * 阀值
     */
    private static final int  THRESHOLD        = 2;

    private int               start;
    private int               end;

    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask task = new CountTask(1, 4);
        Future<Integer> result = forkJoinPool.submit(task);
        System.out.println(result.get());

    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            // 执行子任务
            leftTask.fork();
            rightTask.fork();
            // 等待子任务执行完，并得到结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            // 合并子任务
            sum = leftResult + rightResult;
        }
        return sum;
    }
}
