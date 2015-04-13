package com.hz.yk.yk.concurrent.block;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuzheng.yk
 *         Date: 13-11-8
 *         Time: 上午11:09
 */
public class BlockingQ_1 {
    private Object notEmpty=new Object();
    private Queue<Object> linkedList=new LinkedList<Object>();

    public Object take() throws InterruptedException{
        synchronized (notEmpty){
            if(linkedList.size() == 0){
                //执行wait操作必须获得锁，wait之后会释放锁，被唤醒前需要获得锁
                notEmpty.wait();
            }
            return linkedList.poll();
        }
    }

    public void offer(Object object){
        synchronized (notEmpty){
            if (linkedList.size()==0){
                //执行notify必须获得锁，在add之后释放锁，take方法才能获得锁
                notEmpty.notifyAll();
            }
            linkedList.add(object);
        }
    }

}
