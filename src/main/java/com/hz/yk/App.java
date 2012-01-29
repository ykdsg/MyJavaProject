package com.hz.yk;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String str="";
        String[] strs=str.split(",");

        List list=new ArrayList();
        list.add(null);
        System.out.print(list.size());
        System.out.println("Hello World!");
    }
}
