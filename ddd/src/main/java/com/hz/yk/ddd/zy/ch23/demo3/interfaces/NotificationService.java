package com.hz.yk.ddd.zy.ch23.demo3.interfaces;

import com.hz.yk.ddd.zy.ch23.demo3.domain.Notification;

/**
 * @author wuzheng.yk
 * @date 2022/9/7
 */
public interface NotificationService {

    void send(Notification composeNotification);
}
