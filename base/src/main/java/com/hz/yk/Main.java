package com.hz.yk;

import com.google.common.collect.Lists;
import com.hz.yk.schema.People;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2018/7/17
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Object> list = Lists.newArrayList();
        list.add(null);
        System.out.println(list);
        //Integer test1 = new Integer(1);
        //Integer test2 = new Integer(1);
        ////false
        //System.out.println(test1 == test2);
        //List<String> emptyList = Collections.emptyList();
        //emptyList.add("test1");
        //System.out.println(emptyList);
        //
        //int[] ints = new int[] { 1, 2, 3, 4, 55 };
        ////原始类型会把整个array 当做list的一个元素
        //List list = Arrays.asList(ints);
        //System.out.println("origin array=" + list);
        ////原始类型数组需要这么处理
        //list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        //System.out.println("right array=" + list);
        //System.out.println(1 / 0);

        //switch ("case1") {
        //    case "case1":
        //        System.out.println("case1");
        //    case "case2":
        //        System.out.println("case2");
        //        break;
        //    default:
        //        System.out.println("case null");
        //}
        //List<String> strList = Lists.newArrayList("2", "22");
        //List<String> filterList = strList.stream().filter(s -> s.equals("1")).collect(Collectors.toList());
        //System.out.println(filterList);

        List<People> appMappingJSONs = com.alibaba.fastjson.JSONObject.parseArray("", People.class);
        System.out.println(appMappingJSONs);
    }

    //方法没有声明throws
    static void doThrow(Exception e) {
        Main.<RuntimeException>doThrow0(e);
    }

    @SuppressWarnings("unchecked")
    static <E extends Exception> void doThrow0(Exception e) throws E {
        throw (E) e;
    }

    @Test
    public void test1() {
        System.out.println(1 / 0);
    }

    @Test
    public void test2() {
        Integer i = 1;
        System.out.println(i.equals(1));
    }

}
