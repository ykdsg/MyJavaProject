package com.hz.yk.listorset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wuzheng.yk
 * @date 2019/11/7
 */
public class ListOrSet2 {

    private static final int totalCount = 100000000;

    static List<String> listStr = new ArrayList<>();
    static Set<String> setStr = new HashSet<>();

    static {
        int count = 5;
        for (int i = 0; i < count; i++) {
            listStr.add(i + "");
            setStr.add(i + "");
        }
    }

    public static void main(String[] args) {

        //        init();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < totalCount; i++) {
            //            testSet();
            testCompositeSet();
        }
        long end2 = System.currentTimeMillis();
        System.out.println("set测试:" + (end2 - start2) + "");

        long start = System.currentTimeMillis();
        for (int k = 0; k < totalCount; k++) {
            //            testList();
            testCompositelist();
        }

        long end = System.currentTimeMillis();
        System.out.println("list测试:" + (end - start + ""));

    }

    public static boolean testCompositelist() {
        boolean contains = listStr.contains("3");
        return contains;
    }

    public static boolean testCompositeSet() {
        boolean contains = setStr.contains("3");
        return contains;
    }

}






