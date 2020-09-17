package com.hz.yk.math;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author wuzheng.yk
 * @date 2020/6/28
 */
public class Lesson5_1 {

    //四种面额纸币
    public static long[] rewards = { 1, 2, 5, 10 };

    public static int count = 0;

    public static void calculate(long totalReward, ArrayList<Long> result) {

        if (totalReward == 0) {
            System.out.println(result);
            count++;
            return;
        }
        if (totalReward < 0) {
            return;
        } else {
            for (long reward : rewards) {
                long remain = totalReward - reward;
                if (remain < 0) {
                    return;
                } else {
                    ArrayList<Long> newResult = (ArrayList<Long>) result.clone();
                    newResult.add(reward);
                    calculate(remain, newResult);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // read the data
        System.out.println("请输入要计算的金额：");
        int n = input.nextInt();
        calculate(n, new ArrayList<>());
        System.out.println("有几种组合方式：" + count);
    }
}
