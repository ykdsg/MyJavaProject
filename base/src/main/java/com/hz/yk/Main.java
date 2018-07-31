package com.hz.yk;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wuzheng.yk
 * @date 2018/7/17
 */
public class Main {

    public static void main(String[] args) {
        Integer test1 = new Integer(1122333211);
        Integer test2 = new Integer(1122333211);
        System.out.println(test1 == test2);

        int[] ints = new int[] { 1, 2, 3, 4, 55 };
        //原始类型会把整个array 当做list的一个元素
        List list = Arrays.asList(ints);
        System.out.println("origin array=" + list);
        //原始类型数组需要这么处理
        list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        System.out.println("right array=" + list);
    }

    //方法没有声明throws
    static void doThrow(Exception e) {
        Main.<RuntimeException>doThrow0(e);
    }

    @SuppressWarnings("unchecked")
    static <E extends Exception> void doThrow0(Exception e) throws E {
        throw (E) e;
    }

}
