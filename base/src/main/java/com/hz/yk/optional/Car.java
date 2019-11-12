package com.hz.yk.optional;

import java.util.Optional;

/**
 * @author wuzheng.yk
 * @date 2019/11/8
 */
public class Car {

    private Insurance insurance;

    public Optional<Insurance> getInsurance() {
        return Optional.ofNullable(insurance);
    }
}
