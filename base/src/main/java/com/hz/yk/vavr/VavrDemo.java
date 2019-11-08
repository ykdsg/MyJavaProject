package com.hz.yk.vavr;

import io.vavr.Function1;
import io.vavr.Function2;
import io.vavr.Function3;
import io.vavr.Function5;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Option;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author wuzheng.yk
 * @date 2019/11/6
 */
public class VavrDemo {

    @Test
    public void test1() {

        Tuple2<String, Integer> java8 = Tuple.of("Java", 8);
        //(vavr, 1)
        Tuple2<String, Integer> that = java8.map(s -> s.substring(2) + "vr", i -> i / 8);

        that = java8.map((s, i) -> Tuple.of(s.substring(2) + "vr", i / 8));

        String str = java8.apply((s, i) -> s.substring(2) + "vr" + i / 8);

        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;

        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);

        assertEquals(6, (int) add1AndMultiplyBy2.apply(2));

    }

    @Test
    public void testLift() {
        //lift 对异常进行包装，返回None
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);
        // 不正常的输入（引起异常）会返回None，正常会返回Some
        Option<Integer> i1 = safeDivide.apply(1, 0);
        System.out.println(i1);
        Option<Integer> i2 = safeDivide.apply(4, 2);
        System.out.println(i2);

        Function2<Integer, Integer, Option<Integer>> sum = Function2.lift(this::sum);
        Option<Integer> opResult = sum.apply(-1, 2);
        assertEquals(Option.none(), opResult);
    }

    @Test
    public void testPartial() {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        //第1个参数a被设置为2
        Function1<Integer, Integer> add2 = sum.apply(2);
        assertEquals((int) add2.apply(4), 6);

        Function5<Integer, Integer, Integer, Integer, Integer, Integer> sum5 = (a, b, c, d, e) -> a + b + c + d + e;
        Function2<Integer, Integer, Integer> add6 = sum5.apply(2, 3, 1);
        assertEquals((int) add6.apply(4, 3), 13);

    }

    /**
     * 柯里化，注意跟上面Partial 的区别，特别是存在多个参数的情况下
     */
    @Test
    public void testCurrying() {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> add2 = sum.curried().apply(2);
        assertEquals((int) add2.apply(4), 6);

        Function3<Integer, Integer, Integer, Integer> sum3 = (a, b, c) -> a + b + c;
        final Function1<Integer, Function1<Integer, Integer>> add3 = sum3.curried().apply(2);

        assertEquals((int) add3.apply(4).apply(3), 9);

    }

    @Test
    public void testOption() {
        Option<String> maybeFoo = Option.of("foo");

        try {
            Option<String> nullOpt = maybeFoo.map(s -> (String) null).map(s -> s.toUpperCase() + "bar");
        } catch (Exception e) {
            System.out.println("Nullpointer");
        }
        //下面2种处理的方式就不会发生空指针
        Option<String> maybeFooBar = maybeFoo.map(s -> (String) null)
                                             .flatMap(s -> Option.of(s).map(t -> t.toUpperCase() + "bar"));
        System.out.println(maybeFooBar);
        maybeFooBar = maybeFoo.flatMap(s -> Option.of((String) null)).map(s -> s.toUpperCase() + "bar");
        System.out.println(maybeFooBar);
    }

    int sum(int first, int second) {
        if (first < 0 || second < 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        return first + second;
    }
}
