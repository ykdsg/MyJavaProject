package com.hz.yk.dubbo.consumer;

import com.yt.icp.domain.query.QueryBrandOptionsDO;
import com.yt.icp.domain.result.ServerResultDO;
import com.yt.icp.domain.to.BrandTO;
import com.yt.icp.facade.BrandQueryFacade;
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
        //LogService logService = context.getBean(LogService.class);
        //Long aLong = logService.create(new LogReq(System.currentTimeMillis(), 1, "domain-dddd", "content-cccc"));
        //System.out.println("constumer result=" + aLong);
        //
        //try {
        //    Long aLong1 = logService.create(null);
        //} catch (Exception e) {
        //    log.error("[ConsumerMain-main]error", e);
        //}

        BrandQueryFacade brandQueryFacade = context.getBean(BrandQueryFacade.class);
        ServerResultDO<BrandTO> brandTOServerResultDO = brandQueryFacade.getBrandById(160L, new QueryBrandOptionsDO());
        System.out.println(brandTOServerResultDO.getModule());
    }

}
