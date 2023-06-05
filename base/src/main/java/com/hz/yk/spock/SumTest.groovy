package com.hz.yk.spock

import spock.lang.Specification

/**
 * @author wuzheng.yk
 * @date 2018/7/30
 */
class SumTest extends Specification {
    def sum = new Sum();

    def "sum should return param1+param2"() {
        expect:
        sum.sum(1, 1) == 2
    }
}
