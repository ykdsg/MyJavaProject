package com.hz.yk.effective.ch5;

import java.util.HashSet;
import java.util.Set;

/**
 * 泛型相关测试
 * Set<Object ＞是个参数化类型，表示可以包含任何对象类型的一个集合； Set ＜？＞则是一 个通配符类型，表示只能包含某种未知对象类型的一个集合； Set 是一个原生态类型，它脱 离了泛型系统。 前两种是安全的，最后一种不安全
 *
 * @author wuzheng.yk
 * @date 2020/10/12
 */
public class GenericTypeTest {

    public void test() {
        //使用了原生态类型，这是很危险的 。 安全的替代做法是使用无限 制的通配符类型（ unbounded wildcard type ）
        Set anySet = new HashSet();
        anySet.add("s");
        anySet.add(1);

        //不仅无法将任何元素（除了 null 之外）放进 Collection ＜？＞ 中，
        //而且根本无法猜测你会得到哪种类型的对象。 要是无法接受这些限制，就可以使用泛型方法 （详见第 3 0 条）或者有限制的通配符类型
        Set<?> typeSet = new HashSet<>();
        //typeSet.add("s");

    }
}
