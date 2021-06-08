package com.hz.yk.optional;

import java.util.Optional;

/**
 * @author wuzheng.yk
 * @date 2019/11/8
 */
public class OptionalMain {

    public static void main(String[] args) {
        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);
        //map中获取的返回值自动被Optional包装,即返回值 -> Optional<返回值>
        //flatMap中返回值保持不变,但必须是Optional类型,比如getCar 必须返回Optional<Car>
        String carInsurance = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName)
                .orElse("Unkonw");
        System.out.println(carInsurance);
    }

}
