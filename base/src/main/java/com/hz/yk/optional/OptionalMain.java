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
        String carInsurance = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName)
                                       .orElse("Unkonw");
        System.out.println(carInsurance);
    }

}
