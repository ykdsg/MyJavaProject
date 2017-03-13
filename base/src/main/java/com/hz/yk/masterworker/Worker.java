package com.hz.yk.masterworker;

import java.util.Map;
import java.util.Queue;

/**
 * Created by wuzheng.yk on 17/3/13.
 */
public class Worker implements Runnable
{
    /**
     * 任务队列，用于取得子任务
     */
    protected Queue<Object> workerQueue;
    /**
     * 子任务处理结果集
     */
    protected Map<String, Object> resultMap;

    public void setResultMap(Map<String, Object> resultMap)
    {
        this.resultMap = resultMap;
    }

    public void setWorkQueue(Queue<Object> workeQueue)
    {
        this.workerQueue = workeQueue;
    }

    /**
     * 子任务的处理逻辑，在子类中实现具体逻辑
     */
    public Object handle(Object input)
    {
        return input;
    }

    @Override
    public void run()
    {
        while (true)
        {
            // 获取子任务
            Object input = workerQueue.poll();
            if (input == null)
            {
                break;
            }
            // 处理子任务
            Object result = handle(input);
            // 将处理结果写入结果集
            resultMap.put(Integer.toString(input.hashCode()), result);
        }
    }
}
