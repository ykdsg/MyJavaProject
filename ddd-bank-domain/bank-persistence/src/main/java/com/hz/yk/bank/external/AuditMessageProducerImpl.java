package com.hz.yk.bank.external;

import com.hz.yk.bank.domain.types.AuditMessage;
import com.hz.yk.bank.external.impl.KafkaTemplate;
import com.hz.yk.bank.messaging.AuditMessageProducer;
import com.hz.yk.bank.messaging.SendResult;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wuzheng.yk
 * @date 2021/2/18
 */
public class AuditMessageProducerImpl implements AuditMessageProducer {

    private static final String TOPIC_AUDIT_LOG = "TOPIC_AUDIT_LOG";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public SendResult send(AuditMessage message) {
        String messageBody = message.serialize();
        kafkaTemplate.send(TOPIC_AUDIT_LOG, messageBody);
        return SendResult.success();
    }

}
