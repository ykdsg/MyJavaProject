package com.hz.yk.leetcode;

import java.util.LinkedList;

/**
 * 两数相加
 * https://leetcode-cn.com/problems/add-two-numbers/solution
 *
 * @author wuzheng.yk
 * @date 2019-05-07
 */
public class AddTwo02 {

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        l1.add(0, 6);
        l1.add(1, 9);
        l1.add(2, 4);
        l1.add(3, 4);
        l1.add(4, 4);

        l2.add(0, 6);
        l2.add(1, 9);
        l2.add(2, 4);
        l2.add(3, 5);
        Integer left = l1.poll();
        Integer right = l2.poll();
        int carry = 0;
        LinkedList<Integer> result = new LinkedList<>();

        while (left != null || right != null || carry != 0) {
            int l = left != null ? left : 0;
            int r = right != null ? right : 0;
            int current = l + r + carry;
            carry = current / 10;
            int cur = current % 10;
            result.add(cur);

            left = left != null ? l1.poll() : null;
            right = right != null ? l2.poll() : null;
        }
        System.out.println(result);
    }

}
