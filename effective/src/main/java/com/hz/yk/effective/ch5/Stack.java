package com.hz.yk.effective.ch5;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2020/10/14
 */
public class Stack<E> {

    private E[] elements;
    //private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked ")
    public Stack() {
        //不能创建不可具体化的（ non”reifiable ）类型的数组，如 E 。 每当 编写用数组支持的泛型时，都会出现这个问题。
        //第一种，直接绕 过创建泛型数组的禁令 ： 创建一个 Object 的数组，并将它转换成泛型数组类型 。 现在错 误是消除了，但是编译器会产生一条警告。 这种用法是合法的，但（整体上而言）不是类型 安全的：
        //编译器不可能证明你的程序是类型安全的，但是你可以 。 你自己必须确保未受检的转 换不会危及程序的类型安全性。 相关的数组（即 elements 变量）保存在一个私有的域中， 永远不会被返回到客户端，或者传给任何其他方法。 这个数组中保存的唯一元素，是传给 push 方法的那些元素，它们的类型为 E ，因此未受检的转换不会有任何危害 。
        //消除 Stack 中泛型数组创建错误的第二种方法是，将 elements 域的类型从 E[]改 为 Object[] 。但是所有方法都要强制转换成E
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public static void main(String[] args) {
        Stack<Number> numberStack = new Stack<>();
        List<Integer> integerList = Lists.newArrayList(1, 2);
        numberStack.pushAll(integerList);

        Stack<Integer> integerStack = new Stack<>();
        integerList.add(1);
        List<Number> numberList = Lists.newArrayList();
        integerStack.popAll(numberList);

        //为了获得最大限度的灵活性，要在表示生产者或者消费者的输入参数上 使用通配符类型。
        //如果某个输入参数既是生产者，又是消费者，那么通配符类型对你就没有 什么好处了 ： 因为你需要的是严格的类型匹配，这是不用任何通配符而得到的 。
        //PECS 表示 producer-extends, consumer－super
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        final E result = elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    //从堆校中弹出每个元素，并将这些元素添加到指定的集合中
    //pop的入参类型不应该为 E 的集合，而应该为E 的某种超类的集合
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void swap(List<?> list, int i, int j) {
        //问题在于 list 的类型为 List＜？＞，你不能把 null 之外的任何值放到 List＜？＞中 。
        //list.set(i, list.set(j, list.get(i)));
        swapHelp(list, i, j);
    }

    private static <E> void swapHelp(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }
}
