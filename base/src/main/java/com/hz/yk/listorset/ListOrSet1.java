package com.hz.yk.listorset;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/**
 * 枚举类比较特殊，普通对象set 会比list 快，这个通过 {@link ListOrSet2} 可以验证，
 * EnumSet 确实非常牛逼，能快好几个数量级。
 *
 * @author wuzheng.yk
 * @date 2019/11/7
 */
public class ListOrSet1 {

    private static final int totalCount = 100000000;

    static List<UserCompositeTypeEnum> listStr = Lists
            .newArrayList(UserCompositeTypeEnum.SHOP, UserCompositeTypeEnum.SELLER, UserCompositeTypeEnum.HSP,
                          UserCompositeTypeEnum.ADMIN);

    static Set<UserCompositeTypeEnum> setStr = Sets
            .newHashSet(UserCompositeTypeEnum.SHOP, UserCompositeTypeEnum.SELLER, UserCompositeTypeEnum.HSP,
                        UserCompositeTypeEnum.ADMIN);

    static EnumSet<UserCompositeTypeEnum> enumSet = EnumSet.allOf(UserCompositeTypeEnum.class);

    static List<Integer> list = Lists
            .newArrayList(UserCompositeTypeEnum.SHOP.getCode(), UserCompositeTypeEnum.SELLER.getCode(),
                          UserCompositeTypeEnum.HSP.getCode(), UserCompositeTypeEnum.ADMIN.getCode());

    static Set set = Sets.newHashSet(UserCompositeTypeEnum.SHOP.getCode(), UserCompositeTypeEnum.SELLER.getCode(),
                                     UserCompositeTypeEnum.HSP.getCode(), UserCompositeTypeEnum.ADMIN.getCode());

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int k = 0; k < totalCount; k++) {
            //            testList();
            testCompositelist();
        }

        long end = System.currentTimeMillis();
        System.out.println("list测试:" + (end - start + ""));
        //        init();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < totalCount; i++) {
            //            testSet();
            testCompositeSet();
        }
        long end2 = System.currentTimeMillis();
        System.out.println("set测试:" + (end2 - start2) + "");

        long start3 = System.currentTimeMillis();
        for (int i = 0; i < totalCount; i++) {
            //            testSet();
            testCompositeEnumSet();
        }
        long end3 = System.currentTimeMillis();
        System.out.println("setEnum测试:" + (end3 - start3) + "");
    }

    public static int testCompositelist() {
        if (listStr.contains(UserCompositeTypeEnum.ADMIN)) {
            return UserCompositeTypeEnum.ADMIN.getCode();
        }
        return 1;
    }

    public static int testCompositeEnumSet() {
        if (enumSet.contains(UserCompositeTypeEnum.ADMIN)) {
            return UserCompositeTypeEnum.ADMIN.getCode();
        }
        return 1;
    }

    public static int testCompositeSet() {
        if (setStr.contains(UserCompositeTypeEnum.ADMIN)) {
            return UserCompositeTypeEnum.ADMIN.getCode();
        }
        return 1;
    }

    public static int testList() {
        if (list.contains(UserCompositeTypeEnum.ADMIN)) {
            return UserCompositeTypeEnum.ADMIN.getCode();
        }
        return 1;
    }

    public static int testSet() {
        if (set.contains(UserCompositeTypeEnum.ADMIN)) {
            return UserCompositeTypeEnum.ADMIN.getCode();
        }
        return 1;
    }

    public static void init() {
        long start0 = System.currentTimeMillis();
        for (int m = 0; m < totalCount; m++) {
            list.add(m);
        }
        long end0 = System.currentTimeMillis();
        System.out.println("set init cost:" + (end0 - start0) + "ms");

        long start1 = System.currentTimeMillis();
        for (int n = 0; n < totalCount; n++) {
            set.add(n);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("list init cost:" + (end1 - start1) + "ms");

    }
}
