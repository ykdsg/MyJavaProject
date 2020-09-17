package com.hz.yk.leetcode;

import java.util.Scanner;

/**
 * @author wuzheng.yk
 * @date 2020/9/2
 */
public class Factorial {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // read the data
        System.out.println("输入数字：");
        int n = input.nextInt();
        System.out.println(fact(n));

    }

    //递归求阶乘
    private static long fact(int n) {
        if (n == 1) {
            return 1;
        } else {
            return fact(n - 1) * n;
        }
    }

}
