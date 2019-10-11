package com.hz.yk.reactor.price;

import com.hz.yk.thread.groboutils.ThreadJigglePoint;
import com.yangt.tracker.util.CallableWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.util.List;
import java.util.Set;

/**
 * @author wuzheng.yk
 * @date 2019-06-21
 */
public class PriceSourceMaterialFillerImplPublisherWrapper {

    private static final Logger log = LoggerFactory.getLogger(PriceSourceMaterialFillerImplPublisherWrapper.class);

    //线程池
    private Scheduler                     executor                  = Schedulers.elastic();
    private PriceSourceMaterialFillerImpl priceSourceMaterialFiller = new PriceSourceMaterialFillerImpl();

    public Mono<Boolean> fillSourceMaterialsItem(PriceSourceMaterials priceSourceMaterials, List<Long> itemIdList) {
        //return Mono.defer(() -> {
        //    log.info("--------fill-Item start");
        //    priceSourceMaterialFiller.fillSourceMaterialsItem(priceSourceMaterials, itemIdList);
        //    log.info("--------fill-Item end");
        //    return Mono.just(true);
        //}).subscribeOn(executor);

        return warpper(() -> {
            priceSourceMaterialFiller.fillSourceMaterialsItem(priceSourceMaterials, itemIdList);
        }, "fillSourceMaterialsItem");

    }

    public Mono<Boolean> fillSourceMaterialsItemPriceRule(PriceSourceMaterials priceSourceMaterials,
                                                          List<Long> itemIdList, ProvinceArea provinceArea) {
        return warpper(() -> {
            priceSourceMaterialFiller.fillSourceMaterialsItemPriceRule(priceSourceMaterials, itemIdList, provinceArea);
        }, "fill-PriceRule");
    }

    public Mono<Boolean> fillSourceMaterialsItemBatchByItemIdList(PriceSourceMaterials priceSourceMaterials,
                                                                  List<Long> itemIdList) {
        return warpper(() -> {
            priceSourceMaterialFiller.fillSourceMaterialsItemBatchByItemIdList(priceSourceMaterials, itemIdList);
        }, "fillSourceMaterialsItemBatch");
    }

    public Mono<Boolean> fillSourceMaterialsLogisticCarry(PriceSourceMaterials priceSourceMaterials,
                                                          Set<Long> logisticTemplateIdSet, Integer filterLogisticType,
                                                          Boolean filterLogisticTypeIsByReal) {
        return warpper(() -> {
            priceSourceMaterialFiller
                    .fillSourceMaterialsLogisticCarry(priceSourceMaterials, logisticTemplateIdSet, filterLogisticType,
                                                      filterLogisticTypeIsByReal);
        }, "fillSourceMaterialsLogisticCarry");
    }

    public Mono<Boolean> fillSourceMaterialsPackFee(PriceSourceMaterials priceSourceMaterials,
                                                    Set<Long> packTemplateIdSet, Integer spec) {
        return warpper(() -> {
            priceSourceMaterialFiller.fillSourceMaterialsPackFee(priceSourceMaterials, packTemplateIdSet, spec);
        }, "fillSourceMaterialsPackFee");

    }

    public Mono<Boolean> fillSourceMaterialsBiddingPrice(PriceSourceMaterials priceSourceMaterials,
                                                         ProvinceArea provinceArea) {
        return warpper(
                () -> {priceSourceMaterialFiller.fillSourceMaterialsBiddingPrice(priceSourceMaterials, provinceArea);},
                "fillSourceMaterialsBiddingPrice");
    }

    public Mono<Boolean> fillSourceMaterialsPreferenceFromUmp(PriceSourceMaterials priceSourceMaterials,
                                                              MixItemPriceFactoryContract mixItemPriceFactoryContract) {
        return warpper(() -> {
            priceSourceMaterialFiller
                    .fillSourceMaterialsPreferenceFromUmp(priceSourceMaterials, mixItemPriceFactoryContract);
        }, "fillSourceMaterialsPreferenceFromUmp");
    }

    private Mono<Boolean> warpper(Runnable runnable, String msg) {
        //return Mono.fromCallable(() -> {
        //    //log.info("--------" + msg + " start");
        //    ThreadJigglePoint.jiggle();
        //    runnable.run();
        //    //log.info("--------" + msg + " end");
        //    return true;
        //}).subscribeOn(executor);

        return Mono.fromCallable(CallableWrapper.of(() -> {
            //log.info("--------" + msg + " start");
            ThreadJigglePoint.jiggle();
            runnable.run();
            //log.info("--------" + msg + " end");
            return true;
        })).subscribeOn(executor);
    }
}
