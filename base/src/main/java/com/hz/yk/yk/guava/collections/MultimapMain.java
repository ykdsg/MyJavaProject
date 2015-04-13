package com.hz.yk.yk.guava.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.Collection;

/**
 *
 * @author wuzheng.yk
 *         Date: 14-7-18
 *         Time: обнГ3:03
 */
public class MultimapMain {

    public static void main(String[] args) {
        Multimap<String,String> multimap = ArrayListMultimap.<String,String>create();
        Collection<String> values = multimap.get("test");
        values.add("1");
        values.add("2");
        System.out.println(multimap.get("test"));
    }


}
