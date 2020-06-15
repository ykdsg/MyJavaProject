package com.hz.yk.fockjoin;

import java.util.concurrent.RecursiveAction;

/**
 * Created by wuzheng.yk on 2017/6/28.
 */
public class PrintTaskTO extends RecursiveAction {

    // 每个"小任务"最多只打印50个数
    private static final int MAX = 50;

    private int start;
    private int end;

    PrintTaskTO(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        // 当end-start的值小于MAX时候，开始打印
        if ((end - start) < MAX) {
            try {
                System.out.println(Thread.currentThread() + " sleep");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值:" + i);
            }
        } else {
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            PrintTaskTO left = new PrintTaskTO(start, middle);
            PrintTaskTO right = new PrintTaskTO(middle, end);
            // 并行执行两个小任务
            left.fork();
            right.fork();
        }
    }
}
