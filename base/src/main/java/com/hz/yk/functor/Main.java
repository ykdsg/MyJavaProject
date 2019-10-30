package com.hz.yk.functor;

import com.google.common.collect.Lists;

/**
 * @author wuzheng.yk
 * @date 2019/10/24
 */
public class Main {

    public static void main(String[] args) {
        Identity<String> idString = new Identity<>("abc");
        Identity<Integer> idInt = idString.map(String::length);
        Customer customer1 = new Customer("teste tsetse");

        Identity<byte[]> idBytes = new Identity<>(customer1).map(Customer::getAddress).map(s -> s.substring(0, 3))
                                                            .map(String::toLowerCase).map(String::getBytes);

        byte[] bytes = customer1.getAddress().substring(0, 3).toLowerCase().getBytes();
    /*
    从上面看Identity 为什么要费心进行如此冗长的包装，不仅不能提供任何附加价值，而且还不能将内容提取回来?事实证明，你可以用这个原始的函子抽象来建模其他几个概念。
     */
        Customer customer2 = new Customer("teste tsetse");
        FList<Customer> customerFList = new FList<>(Lists.newArrayList(customer1, customer2));
        FList<String> streets = customerFList.map(Customer::getAddress);
        /*
        它不再像说customer .getAddress().street()那么简单，您不能在客户集合上调用getAddress()，您必须在每个客户上调用getAddress()，然后将其放回集合中。
         */

        FOptional<String> str = FOptional.of("42");
        FOptional<FOptional<Integer>> num = str.map(Main::tryParse);

    }

    static FOptional<Integer> tryParse(String s) {
        try {
            final int i = Integer.parseInt(s);
            return FOptional.of(i);
        } catch (NumberFormatException e) {
            return FOptional.empty();
        }

    }

}
