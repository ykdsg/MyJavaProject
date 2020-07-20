package com.hz.yk.math;

import java.util.Arrays;

import static org.apache.commons.lang3.ObjectUtils.min;

/**
 * 动态规划
 *
 * @author wuzheng.yk
 * @date 2020/7/14
 */
public class Lesson10_1 {

    /**
     * @param a      字符串a
     * @param b      字符串b
     * @param i      a的第i个位置
     * @param j      b的第j个位置
     * @param result 返回值
     */
    public static int stateTransition(String a, String b, int i, int j, Integer[][] result) {
        if (result[i][j] != null) {
            return result[i][j];
        }
        if (i == 0) {
            result[i][j] = j;
            return result[i][j];
        } else if (j == 0) {
            result[i][j] = i;
            return result[i][j];
        }

        //计算左边的值
        int leftValue = stateTransition(a, b, i - 1, j, result);
        int upValue = stateTransition(a, b, i, j - 1, result);
        int replaceValue = (a.charAt(i) == b.charAt(j) ? 0 : 1) + stateTransition(a, b, i - 1, j - 1, result);
        result[i][j] = min(leftValue + 1, upValue + 1, replaceValue);
        return result[i][j];
    }

    public static void main(String[] args) {
        String a = "mouse";
        String b = "mouuse";
        int i = a.length();
        int j = b.length();
        Integer[][] result = new Integer[i][j];
        stateTransition(a, b, i - 1, j - 1, result);
        System.out.println("状态转移列表：" + Arrays.deepToString(result));
    }
}
