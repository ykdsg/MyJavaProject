package com.hz.yk.optional;

import java.util.Optional;

/**
 * @author wuzheng.yk
 * @date 2019/11/8
 */
public class Person {

    private Car car;

    public Optional<Car> getCar() {
        return Optional.ofNullable(car);
    }
}
