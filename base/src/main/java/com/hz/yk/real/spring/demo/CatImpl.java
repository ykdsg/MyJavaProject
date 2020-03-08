package com.hz.yk.real.spring.demo;

import org.springframework.stereotype.Service;

/**
 * @author wuzheng.yk
 * @date 2019/9/24
 */
@Service
public class CatImpl implements IAnimal {

    @Override
    public String toString() {
        return "cat";
    }
}
