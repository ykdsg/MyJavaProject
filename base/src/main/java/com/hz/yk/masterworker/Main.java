package com.hz.yk.masterworker;

import java.util.Map;
import java.util.Set;

/**
 * Created by wuzheng.yk on 17/3/13.
 */
public class Main {

    public static void main(String[] args) {
        // 使用5个Worker，并指定Worker
        Master m = new Master(new PlusWorker(), 5);
        // 提交100个子任务
        for (int i = 0; i < 100; i++) {
            m.submit(i);
        }
        // 开始计算
        m.execute();
        // 最终计算结果保存于此
        int result = 0;

        Map<String, Object> resultMap = m.getResultMap();

        String key = null;
        Integer i = null;
        Set<String> keys = null;
        while (resultMap.size() > 0 || !m.isComplete()) {
            // 不需要等待所有Worker都执行完，即可开始计算最终结果
            keys = resultMap.keySet();
            for (String k : keys) {
                key = k;
                break;
            }
            if (key != null) {
                i = (Integer) resultMap.get(key);
            }
            if (i != null) {
                // 最终结果
                result += i;
            }
            if (key != null) {
                // 移除已经被计算过得项
                resultMap.remove(key);
            }
        }
        System.out.println("-->result:" + result);
        ;
    }
}
