package chap2;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2018/6/5
 */
public class FilteringApples {

    public static void prettyPrintApple(List<Apple> inventory, StrFormat format) {
        for (Apple apple : inventory) {
            String outStr = format.invoke(apple);
            System.out.println(outStr);
        }
    }

}
