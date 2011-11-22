package yk.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ykdsg
 *         Date: 11-11-7
 *         Time: обнГ9:33
 */
public class Test {
    int i = 0;
    public final static Test test=new Test();
    Lock lock=new ReentrantLock(true);

    public int addAndReturn() {
        lock.lock();
        try{
        return i++;
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Thread t1 = new Thread(new Task());
            t1.start();
        }


    }


    static class Task implements  Runnable{
        public void run() {
                while(true){
                System.out.println(test.addAndReturn());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            }
    }
}
