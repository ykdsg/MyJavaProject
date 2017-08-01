package com.hz.yk.arithmetic;

/**
 * Created by wuzheng.yk on 2017/7/11.
 */
public class PowerOfTwo {


    private static boolean isPowerOfTwo(int val) {
        return (val & -val) == val;
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(-4));


        System.out.println(isPowerOfTwo(4));

    }

}
