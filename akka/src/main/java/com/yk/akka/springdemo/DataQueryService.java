/*
 * Copyright 1999-19 Nov 2015 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.yk.akka.springdemo;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.pattern.Patterns;
import com.yk.akka.springdemo.model.Item;
import com.yk.akka.springdemo.model.PageQueryMsg;
import com.yk.akka.springdemo.model.PageResultMsg;
import com.yk.akka.springdemo.model.QueryMsg;
import com.yk.akka.springdemo.model.QueryParam;
import com.yk.akka.springdemo.model.ResultMsg;
import com.yk.akka.springdemo.spring.SpringExtension;
import akka.util.Timeout;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
/**
 * @author yangbolin 19 Nov 2015 11:41:15 am
 */
public class DataQueryService implements ApplicationContextAware {
    
    private ApplicationContext applicationContext; 
    private ActorSystem        actorSystem;
    
    public List<Item> query(QueryParam param) {
        List<Item> itemList = new ArrayList<Item>();
        
        UUID uuid = UUID.randomUUID();
        SpringExtension.SpringExtProvider.get(actorSystem).initialize(applicationContext);
        final ActorRef queryActor = actorSystem.actorOf(SpringExtension.SpringExtProvider.get(actorSystem).props("queryActor"),
                                                                            "queryActor" + uuid);
        
        QueryMsg queryMsg = new QueryMsg();
        
        List<PageQueryMsg> pageQueryMsgList = new ArrayList<PageQueryMsg>();
        PageQueryMsg pageQueryMsg1 = new PageQueryMsg();
        PageQueryMsg pageQueryMsg2 = new PageQueryMsg();
        PageQueryMsg pageQueryMsg3 = new PageQueryMsg();
        
        pageQueryMsgList.add(pageQueryMsg1);
        pageQueryMsgList.add(pageQueryMsg2);
        pageQueryMsgList.add(pageQueryMsg3);
        
        queryMsg.setPageQueryMsgList(pageQueryMsgList);
        
        Timeout timeout = new Timeout(Duration.create(20, "seconds"));
        Future<Object> future = Patterns.ask(queryActor, queryMsg, timeout);
        try {
            ResultMsg resultMsg = (ResultMsg)Await.result(future, timeout.duration());
            for (PageResultMsg page : resultMsg.getResultList()) {
                Item item = new Item();
                item.setContent(page.getContent());
                itemList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return itemList;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    
    public void setActorSystem(ActorSystem actorSystem) {
        this.actorSystem = actorSystem;
    }
}
