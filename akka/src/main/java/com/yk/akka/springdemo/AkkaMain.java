/*
 * Copyright 1999-19 Nov 2015 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.yk.akka.springdemo;

import com.yk.akka.springdemo.model.Item;
import com.yk.akka.springdemo.model.QueryParam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;


/**
 * @author yangbolin 19 Nov 2015 11:34:30 am
 */
public class AkkaMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("biz-actor.xml");
        
        DataQueryService dataQueryService = (DataQueryService)ctx.getBean("dataQueryService");
        QueryParam queryParam = new QueryParam();
        List<Item> items = dataQueryService.query(queryParam);
        for(Item item : items) {
            System.out.println(item.getContent());
        }
    }
}
