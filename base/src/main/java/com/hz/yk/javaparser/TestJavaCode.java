package com.hz.yk.javaparser;

/**
 * 这个是class 注释
 *
 * @author wuzheng.yk
 * @date 2018/11/29
 */
public class TestJavaCode {

    /**
     * 测试方法1
     *
     * @param name 姓名
     * @param age  年龄
     */
    public void method1(String name, int age) {

    }

    /**
     * 测试方法2
     *
     * @param userObj
     */
    public void method2(UserObj userObj) {

    }

    static class UserObj {

        /**
         * id名
         */
        long   id;
        /**
         * 姓名
         */
        String name;
        /**
         * 年龄
         */
        int    age;
        /**
         * 店铺id
         */
        long   shopId;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public long getShopId() {
            return shopId;
        }

        public void setShopId(long shopId) {
            this.shopId = shopId;
        }
    }
}
