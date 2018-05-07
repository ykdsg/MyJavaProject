package com.hz.yk.exception;

/**
 * @author wuzheng.yk
 * @date 2018/5/7
 */
public class TestPrintStackTrace {

    public static void f() throws Exception {
        throw new Exception("出问题啦！");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace();
            //捕获到异常又立即抛出，在上级方法调用中再次捕获这个异常，打印的栈轨迹信息是一样的。原因在于没有将当前线程当前状态下的轨迹栈的状态保存进Throwabe中
            //throw e;
            //引入fillInStackTrace()方法,这个方法是有返回值的。返回的是保存了当前栈轨迹信息的Throwable对象，这样就不会有f的堆栈信息
            //调用fillInStackTrace就成了异常的新发生地了。
            throw (Exception)e.fillInStackTrace();
        }


    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
