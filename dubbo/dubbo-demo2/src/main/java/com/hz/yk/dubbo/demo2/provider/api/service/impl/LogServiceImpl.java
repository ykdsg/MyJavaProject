package com.hz.yk.dubbo.demo2.provider.api.service.impl;

import com.hz.yk.dubbo.demo2.provider.api.model.LogReq;
import com.hz.yk.dubbo.demo2.provider.api.service.LogService;
import org.springframework.stereotype.Service;

/**
 * @author wuzheng.yk
 * @date 2018/11/8
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    private long i = 0L;

    @Override
    public Long create(LogReq logReq) {
        sleep();
        if (logReq == null) {
            throw new IllegalArgumentException("logReq is null");
        }
        System.out.println("invoke provider create...");
        return i + logReq.getStatus();
    }

    /**
     * 模拟耗时操作
     */
    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
