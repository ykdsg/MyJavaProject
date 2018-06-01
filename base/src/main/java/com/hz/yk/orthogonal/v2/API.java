package com.hz.yk.orthogonal.v2;

/**
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public class API {

    //按照「向稳定的方向依赖」的原则，为了适应诸如List, Set等多种数据结构，甚至包括原生的数组类型，可以将入参重构为重构为更加抽象的Iterable类型。
    public static <E> E find(Iterable<? extends E> students, Predicate<? super E> p) {
        for (E e : students) {
            if (p.test(e)) {
                return e;
            }
        }
        return null;
    }
}
