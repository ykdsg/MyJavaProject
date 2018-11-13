package com.hz.yk.dubbo.provider.api.service.impl;

import com.hz.yk.dubbo.provider.api.model.LogReq;
import com.hz.yk.dubbo.provider.api.service.LogService;
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
        if (logReq == null) {
            throw new IllegalArgumentException("logReq is null");
        }
        System.out.println("invoke provider create...");
        return i + logReq.getStatus();
    }
}
