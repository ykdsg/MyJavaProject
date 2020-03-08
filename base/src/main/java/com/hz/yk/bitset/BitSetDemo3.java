package com.hz.yk.bitset;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * @author wuzheng.yk
 * @date 2019/12/26
 */
public class BitSetDemo3 {

    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int randomResult = random.nextInt(100);
            list.add(randomResult);
        }
        System.out.print("0~100之间产生的随机数有:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("0~100之间的随机数产生了" + list.size() + "个");
        BitSet bitSet = new BitSet(100);
        for (int i = 0; i < 100; i++) {
            bitSet.set(list.get(i));
        }
        //public int cardinality()方法返回此BitSet中比特设置为true的数目
        //就是BitSet中存放的有效位的个数，如果有重复运算会进行自动去重
        System.out.println("0~100存在BitSet的随机数有" + bitSet.cardinality() + "个");
        System.out.print("0~100不在上述随机数中有:");
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if (!bitSet.get(i)) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
        //0~100不在产生的随机数中的个数就是100减去存在BitSet的随机数个数
        System.out.print("0~100不在产生的随机数中的个数为:" + count + "个");
    }

}
