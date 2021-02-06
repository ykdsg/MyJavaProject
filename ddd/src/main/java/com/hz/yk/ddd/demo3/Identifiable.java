package com.hz.yk.ddd.demo3;

/**
 * @author wuzheng.yk
 * @date 2021/1/20
 */
public interface Identifiable<ID extends Identifier> {

    ID getId();

}
