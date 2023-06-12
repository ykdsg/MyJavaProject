package com.hz.yk.stream;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wuzheng.yk on 17/5/11.
 */
public class TestStream {

    @Test
    public void testGroup() {
        class User {
            String name;
            int code;

            public User(String name,int code) {
                this.name = name;
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCode() {
                return code;
            }

            public void setCode(int code) {
                this.code = code;
            }
        }

        List<User> userList = Lists.newArrayList(new User("1", 1), new User("1", 2)
                , new User("2", 2));
        Map<String, List<User>> userGroupMap = userList.stream().collect(Collectors.groupingBy(user -> user.getName()));

        System.out.println(userGroupMap);

    }

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
