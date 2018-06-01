package com.hz.yk.orthogonal.v3;

import java.util.Optional;

/**
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public class API {

    //按照「向稳定的方向依赖」的原则，find的返回值应该设计为Optional<E>，使用「类型系统」的特长，取得如下方面的优势：
    public static <E> Optional<E> find(Iterable<? extends E> students, Predicate<? super E> p) {
        for (E e : students) {
            if (p.test(e)) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }
}
