package com.hz.yk.ddd;

/**
 * 聚合根的Marker接口
 *
 * @author wuzheng.yk
 * @date 2021/1/20
 */
public interface Aggregate<ID extends Identifier> extends Entity<ID> {

}
