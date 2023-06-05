package com.hz.yk.dubbo.provider.api.service;

import com.hz.yk.dubbo.provider.api.model.LogReq;

/**
 * @author wuzheng.yk
 * @date 2018/11/8
 */
public interface LogService {

    Long create(LogReq logReq);

}
