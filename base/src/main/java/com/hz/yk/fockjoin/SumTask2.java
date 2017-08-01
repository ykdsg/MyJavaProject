package com.hz.yk.fockjoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by wuzheng.yk on 2017/6/30.
 */
public class SumTask2 extends RecursiveTask<Integer> {
    // 每个"小任务"最多只打印20个数
    private static final int MAX = 20;
    private int arr[];
    private int start;
    private int end;

    SumTask2(int arr[], int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        // 当end-start的值小于MAX时候，开始打印
        if ((end - start) < MAX) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            System.err.println(Thread.currentThread() + "=====任务分解======");
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            SumTask f1 = new SumTask(arr, start, middle);
            SumTask f2 = new SumTask(arr, middle, end);
            f1.fork();
           return f2.compute() + f1.join();
        }
    }

}
