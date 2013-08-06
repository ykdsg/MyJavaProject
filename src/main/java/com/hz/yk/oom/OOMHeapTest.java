package com.hz.yk.oom;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangke
 *         Date: 13-6-30
 *         Time: 下午1:34
 */
public class OOMHeapTest {
    public static void main(String[] args){
        oom();
    }

    private static void oom(){
        Map<String, Pilot> map = new HashMap<String, Pilot>();
        Object[] array = new Object[1000000];
        for(int i=0; i<1000000; i++){
            String d = new Date().toString();
            Pilot p = new Pilot(d, i);
            map.put(i+"rosen jiang", p);
            array[i]=p;
        }
    }
}


class Pilot{

    String name;
    int age;

    public Pilot(String a, int b){
        name = a;
        age = b;
    }
}