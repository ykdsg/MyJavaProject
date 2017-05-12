package com.hz.yk.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wuzheng.yk on 17/5/11.
 */
public class TestStream {

    @Test
    public void testMap() {
        List<Obj> objList = Lists.newArrayList(new Obj("1", "2"), new Obj("3", "4"));

        List<Obj> objList1 = objList.stream().peek(obj -> obj.setS1("9")).collect(Collectors.toList());

        System.out.println(objList);
        System.out.println(objList1);

    }

    static class Obj {
        String s1;
        String s2;

        public Obj(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        public String getS1() {
            return s1;
        }

        public void setS1(String s1) {
            this.s1 = s1;
        }

        public String getS2() {
            return s2;
        }

        public void setS2(String s2) {
            this.s2 = s2;
        }
    }

}
