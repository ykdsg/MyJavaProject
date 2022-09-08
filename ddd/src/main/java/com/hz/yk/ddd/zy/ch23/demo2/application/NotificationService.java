package com.hz.yk.ddd.zy.ch23.demo2.application;

import com.hz.yk.ddd.zy.ch23.demo2.domain.Notification;

/**
 * 通知服务，类似短信、邮件
 * @author wuzheng.yk
 * @date 2022/9/7
 */
public interface NotificationService {

    void send(Notification composeNotification);
}
