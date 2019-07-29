package com.hz.yk.generic;

/**
 * @author wuzheng.yk
 * @date 2019-07-25
 */
public class Main {

    public static void main(String[] args) {
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());

        /*
        编译器只知道容器内是Fruit或者它的派生类，但具体是什么类型不知道。可能是Fruit？可能是Apple？也可能是Banana，RedApple，GreenApple？编译器在看到后面用Plate<Apple>赋值以后，盘子里没有被标上有“苹果”。而是标上一个占位符：CAP#1，来表示捕获一个Fruit或Fruit的子类，具体是什么类不知道，代号CAP#1。然后无论是想往里插入Apple或者Meat或者Fruit编译器都不知道能不能和这个CAP#1匹配，所以就都不允许。
         */
        //p.set(new Fruit());    //Error
        //p.set(new Apple());    //Error

        //读取出来的东西只能存放在Fruit或它的基类里。
        Fruit newFruit1 = p.get();
        Object newFruit2 = p.get();
        //Apple newFruit3=p.get();    //Error

        Plate<? super Fruit> p2 = new Plate<Fruit>(new Fruit());
        //存入元素正常
        p2.set(new Fruit());
        p2.set(new Apple());

        /*
        因为下界规定了元素的最小粒度的下限，实际上是放松了容器元素的类型控制。既然元素是Fruit的基类，那往里存粒度比Fruit小的都可以。但往外读取元素就费劲了，只有所有类的基类Object对象才能装下。但这样的话，元素的类型信息就全部丢失。
         */
        //读取出来的东西只能存放在Object类里。
        //Apple p2Fruit3=p2.get();    //Error
        //Fruit p2Fruit1=p2.get();    //Error
        Object p2Fruit2 = p2.get();
    }

}
