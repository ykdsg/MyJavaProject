package com.hz.yk.bank.messaging;

import com.hz.yk.bank.domain.types.AuditMessage;

/**
 * @author wuzheng.yk
 * @date 2021/2/5
 */
public interface AuditMessageProducer {

    void send(AuditMessage message);

}
