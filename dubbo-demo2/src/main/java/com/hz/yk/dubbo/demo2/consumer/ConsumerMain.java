package com.hz.yk.dubbo.demo2.consumer;

import com.hz.yk.dubbo.demo2.provider.api.model.LogReq;
import com.hz.yk.dubbo.demo2.provider.api.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wuzheng.yk
 * @date 2018/11/13
 */
public class ConsumerMain {

    private static final Logger log = LoggerFactory.getLogger(ConsumerMain.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        LogService logService = context.getBean(LogService.class);
        LogReq logReq = new LogReq(System.currentTimeMillis(), 1, "domain-dddd", "content-cccc");
        Long aLong = logService.create(logReq);
        System.out.println("constumer result=" + aLong);

        //try {
        //    Long aLong1 = logService.create(null);
        //} catch (Exception e) {
        //    log.error("[ConsumerMain-main]error", e);
        //}

        //BrandQueryFacade brandQueryFacade = context.getBean(BrandQueryFacade.class);
        //ServerResultDO<BrandTO> brandTOServerResultDO = brandQueryFacade.getBrandById(160L, new QueryBrandOptionsDO());
        //System.out.println(brandTOServerResultDO.getModule());

        //for (int i = 0; i < 20; i++) {
        //
        //    new Thread(() -> {
        //        while (true) {
        //            try {
        //                Thread.sleep(300);
        //            } catch (InterruptedException e) {
        //                e.printStackTrace();
        //            }
        //            try {
        //                System.out.println("try to service");
        //                Long result = logService.create(logReq);
        //                System.out.println("service result:" + result);
        //            } catch (Exception e) {
        //                e.printStackTrace();
        //            }
        //        }
        //    }).start();
        //}
    }

}
