package com.hz.yk.spring.demo;

import org.springframework.stereotype.Service;

/**
 * @author wuzheng.yk
 * @date 2019/9/24
 */
@Service()
public class DogImpl implements IAnimal {

    @Override
    public String toString() {
        return "dog";
    }
}
