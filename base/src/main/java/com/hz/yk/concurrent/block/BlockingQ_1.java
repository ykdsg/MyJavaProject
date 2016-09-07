package com.hz.yk.concurrent.block;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuzheng.yk
 *         Date: 13-11-8
 *         Time: ����11:09
 */
public class BlockingQ_1 {
    private Object notEmpty=new Object();
    private Queue<Object> linkedList=new LinkedList<Object>();

    public Object take() throws InterruptedException{
        synchronized (notEmpty){
            if(linkedList.size() == 0){
                //ִ��wait��������������wait֮����ͷ�����������ǰ��Ҫ�����
                notEmpty.wait();
            }
            return linkedList.poll();
        }
    }

    public void offer(Object object){
        synchronized (notEmpty){
            if (linkedList.size()==0){
                //ִ��notify������������add֮���ͷ�����take�������ܻ����
                notEmpty.notifyAll();
            }
            linkedList.add(object);
        }
    }

}
