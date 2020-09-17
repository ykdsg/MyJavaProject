package com.hz.yk.leetcode;

import java.util.Scanner;

/**
 * @author wuzheng.yk
 * @date 2020/9/2
 */
public class TestMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // read the data
        System.out.println("请输入要计算的第几个月份：");

        int M = input.nextInt();
        if (M == 1 || M == 2) {
            System.out.println(2);
        }

        int f1 = 1, f2 = 1, f;
        for (int i = 3; i <= M; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
        }
        System.out.println(f2);

    }

}
