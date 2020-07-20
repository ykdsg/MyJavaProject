package com.hz.yk.math;

import java.util.ArrayList;

/**
 * @author wuzheng.yk
 * @date 2020/6/28
 */
public class Lesson5_1 {

    //四种面额纸币
    public static long[] rewards = { 1, 2, 5, 10 };

    public static void calculate(long totalReward, ArrayList<Long> result) {

        if (totalReward == 0) {
            System.out.println(result);
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
        calculate(10, new ArrayList<>());
    }
}
