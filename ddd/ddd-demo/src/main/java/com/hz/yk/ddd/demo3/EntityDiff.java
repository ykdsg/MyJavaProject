package com.hz.yk.ddd.demo3;

/**
 * @author wuzheng.yk
 * @date 2021/1/20
 */
public interface EntityDiff {

    EntityDiff EMPTY = new EntityDiff() {

        @Override
        public boolean isEmpty() {
            return false;
        }
    };

    boolean isEmpty();
}
