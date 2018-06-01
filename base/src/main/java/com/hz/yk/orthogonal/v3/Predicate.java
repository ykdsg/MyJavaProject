package com.hz.yk.orthogonal.v3;

/**
 * 为了使得逻辑「谓词」变得更加人性化，可以引入「流式接口」的「DSL」设计，增强表达力。
 *
 * @author wuzheng.yk
 * @date 2018/6/1
 */
public interface Predicate<E> {

    boolean test(E e);

    default Predicate<E> and(Predicate<? super E> other) {
        return e -> test(e) && other.test(e);
    }

    default Predicate<E> or(Predicate<? super E> other) {
        return e -> test(e) || other.test(e);
    }
}
