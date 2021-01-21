package com.hz.yk.ddd;

/**
 * 实体类的Marker接口
 *
 * @author wuzheng.yk
 * @date 2021/1/20
 */
public interface Entity<ID extends Identifier> extends Identifiable<ID> {

}
