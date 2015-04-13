package com.hz.yk.yk.oom;

/**
 * 线程太多也会占满栈区域
 * 报出异常：Exception in thread "main" java.lang.OutOfMemoryError:unable to create new native thread
 * @author wuzheng.yk
 *         Date: 13-2-20
 *         Time: 下午2:42
 */
public class StackOOMByThread {

    /**
     * @param args
     */

    private int stackLength = 1;

    private void dontStop(){
        while(true){
            try{Thread.sleep(1000);}catch(Exception err){}
        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread t = new Thread(new Runnable(){

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    dontStop();
                }

            });
            t.start();
            stackLength++;
        }
    }

    public static void main(String[] args) throws Throwable{
        // TODO Auto-generated method stub
        StackOOMByThread oom = new StackOOMByThread();
        try{
            oom.stackLeakByThread();
        }catch(Throwable err){
            System.out.println("Stack length:" + oom.stackLength);
            throw err;
        }

    }
}
