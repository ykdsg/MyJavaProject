package com.hz.yk.ddd.demo3;

/**
 * @author wuzheng.yk
 * @date 2021/1/20
 */
public interface AggregateManager<T extends Aggregate<ID>, ID extends Identifier> {

    static <T extends Aggregate<ID>, ID extends Identifier> AggregateManager<T, ID> newInstance(Class<T> targetClass) {
        return null;
    }

    void attach(T aggregate);

    void attach(T aggregate, ID id);

    void detach(T aggregate);

    T find(ID id);

    EntityDiff detectChanges(T aggregate);

    public void merge(T aggregate);
}
