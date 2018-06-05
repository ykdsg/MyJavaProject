package com.hz.yk.orthogonal.v3;

/**
 * 处理比较运算的变化方向
 *
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public interface Matcher<T> {

    boolean matches(T actual);

    /**
     * 等同于下面的的testEq
     *
     * @param expected
     * @param <T>
     * @return
     */
    static <T> Matcher<T> eq(T expected) {
        return actual -> expected.equals(actual);
    }

    static <T> Matcher<T> testEq(T expected) {
        return new Matcher<T>() {

            @Override
            public boolean matches(T actual) {
                return expected.equals(actual);
            }
        };
    }

    static <T> Matcher<T> ne(T expected) {
        return actual -> !expected.equals(actual);
    }
}
