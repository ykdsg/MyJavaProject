package com.hz.yk.bitset;

import java.util.BitSet;

/**
 * @author wuzheng.yk
 * @date 2019/12/26
 */
public class BitSetDemo {

    public static void main(String[] args) {
        BitSet bitSet = new BitSet(10000000);
        bitSet.set(9999);
        System.out.println("9999:" + bitSet.get(9999));
        System.out.println("9998:" + bitSet.get(9998));
    }

}
