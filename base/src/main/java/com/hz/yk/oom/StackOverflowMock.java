package com.hz.yk.oom;

/**
 * @author wuzheng.yk
 * @date 2020/11/4
 */
public class StackOverflowMock {

    private static int index = 1;

    public void call() {
        index++;
        call();
    }

    public static void main(String[] args) {
        StackOverflowMock stackOverflowMock = new StackOverflowMock();
        try {
            stackOverflowMock.call();

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("stack deep:" + index);
        }

    }

}
