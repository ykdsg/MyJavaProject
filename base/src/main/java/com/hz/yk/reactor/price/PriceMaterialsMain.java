package com.hz.yk.reactor.price;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2019-06-21
 */
public class PriceMaterialsMain {

    static PriceSourceMaterialFillerImplPublisherWrapper wrapper = new PriceSourceMaterialFillerImplPublisherWrapper();

    @Test
    public void testGetMaterial() {
        long startTime = System.currentTimeMillis();

        /*
         * 参数
         */
        List<Long> itemIdList = Lists.newArrayList(1L, 2L, 3L);
        ProvinceArea provinceArea = new ProvinceArea();
        MixItemPriceFactoryContract mixItemPriceFactoryContract = new MixItemPriceFactoryContract();
        PriceSourceMaterials priceSourceMaterials = new PriceSourceMaterials();

        //商品
        Mono<Boolean> itemMono = wrapper.fillSourceMaterialsItem(priceSourceMaterials, itemIdList);
        //售价规则
        Mono<Boolean> itemPriceRule = wrapper
                .fillSourceMaterialsItemPriceRule(priceSourceMaterials, itemIdList, provinceArea);
        //批次以及关联信息
        Mono<Boolean> batchMono = wrapper.fillSourceMaterialsItemBatchByItemIdList(priceSourceMaterials, itemIdList);
        batchMono = batchMono.flatMap(
                //依赖批次信息
                (result) -> this.fillDependOnBatch1(priceSourceMaterials, provinceArea, mixItemPriceFactoryContract));
        Mono.zip(itemMono, itemPriceRule, batchMono).block();
        System.out.println("item:" + priceSourceMaterials.getItem());
        System.out.println("result:" + priceSourceMaterials.getBatch());
        System.out.println("-------------cost:" + (System.currentTimeMillis() - startTime));

    }

    //依赖批次信息
    public Mono<Boolean> fillDependOnBatch1(PriceSourceMaterials priceSourceMaterials, ProvinceArea provinceArea,
                                            MixItemPriceFactoryContract mixItemPriceFactoryContract) {
        System.out.println("get depend on batch:" + priceSourceMaterials.getBatch());

        Mono<Boolean> logisticCarryMono = wrapper
                .fillSourceMaterialsLogisticCarry(priceSourceMaterials, null, null, null);
        Mono<Boolean> packFeeMono = wrapper.fillSourceMaterialsPackFee(priceSourceMaterials, null, null);
        Mono<Boolean> biddingPriceMono = wrapper.fillSourceMaterialsBiddingPrice(priceSourceMaterials, provinceArea);
        Mono<Boolean> activityMono = wrapper
                .fillSourceMaterialsPreferenceFromUmp(priceSourceMaterials, mixItemPriceFactoryContract);
        Mono.zip(logisticCarryMono, packFeeMono, biddingPriceMono, activityMono).block();

        return Mono.empty();
    }

    @Test
    public void testGetMatreial2() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        PriceSourceMaterials priceSourceMaterials = calcPriceSourceMaterials();
        System.out.println("result :" + priceSourceMaterials.getBatch());
        System.out.println("item:" + priceSourceMaterials.getItem());

        System.out.println("-------------cost:" + (System.currentTimeMillis() - startTime));
    }

    public PriceSourceMaterials calcPriceSourceMaterials() {
        List<Long> itemIdList = Lists.newArrayList(1L, 2L, 3L);
        ProvinceArea provinceArea = new ProvinceArea();
        MixItemPriceFactoryContract mixItemPriceFactoryContract = new MixItemPriceFactoryContract();
        PriceSourceMaterials priceSourceMaterials = new PriceSourceMaterials();

        //商品
        Mono<Boolean> itemMono = wrapper.fillSourceMaterialsItem(priceSourceMaterials, itemIdList);
        //售价规则
        Mono<Boolean> itemPriceRule = wrapper
                .fillSourceMaterialsItemPriceRule(priceSourceMaterials, itemIdList, provinceArea);
        //批次以及关联信息
        Mono<Boolean> batchMono = wrapper.fillSourceMaterialsItemBatchByItemIdList(priceSourceMaterials, itemIdList)
                                         .flatMap(v -> fillDependOnBatch(priceSourceMaterials, provinceArea, mixItemPriceFactoryContract));

        Mono.zip(itemMono, itemPriceRule, batchMono).block();
        System.out.println("calc done:" + Thread.currentThread().getName());
        return priceSourceMaterials;
    }

    //依赖批次信息
    public Mono<Boolean> fillDependOnBatch(PriceSourceMaterials priceSourceMaterials, ProvinceArea provinceArea,
                                           MixItemPriceFactoryContract mixItemPriceFactoryContract) {
        if (StringUtils.isBlank(priceSourceMaterials.getBatch())) {
            throw new RuntimeException("------------------------------get bach error");
        }

        Mono<Boolean> logisticCarryMono = wrapper
                .fillSourceMaterialsLogisticCarry(priceSourceMaterials, null, null, null);
        Mono<Boolean> packFeeMono = wrapper.fillSourceMaterialsPackFee(priceSourceMaterials, null, null);
        Mono<Boolean> biddingPriceMono = wrapper.fillSourceMaterialsBiddingPrice(priceSourceMaterials, provinceArea);
        Mono<Boolean> activityMono = wrapper
                .fillSourceMaterialsPreferenceFromUmp(priceSourceMaterials, mixItemPriceFactoryContract);
        //Mono.zip(logisticCarryMono, packFeeMono, biddingPriceMono, activityMono).block();

        return Mono.zip(logisticCarryMono, packFeeMono, biddingPriceMono, activityMono).then(Mono.just(true));

    }
}
