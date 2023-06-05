package com.hz.yk.spock.with

import spock.lang.Specification

/**
 * @author wuzheng.yk
 * @date 2023/5/3
 */
class DefDemoSpec extends Specification{

    public void trivialSum1() {//Java方式声明方法

        when: "number is one"
        int number =1;//分号
        then: "number plus number is two"
        number + number ==2;
    }

    def trivialSum2() {//Groovy方式声明方法

        when: "number is one"
        int number = 1//分号可选
        then: "number plus number is two"
        number + number ==2

    }

    def "Testing a trivial sum"() {//字符串式方法名

        when: "number is one"
        def number =1//对象类型可选
        then: "number plus number is two"
        number + number ==2

    }
}
