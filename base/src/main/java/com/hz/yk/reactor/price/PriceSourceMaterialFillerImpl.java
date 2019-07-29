package com.hz.yk.reactor.price;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author wuzheng.yk
 * @date 2019-06-21
 */
public class PriceSourceMaterialFillerImpl {

    public void fillSourceMaterialsItem(PriceSourceMaterials priceSourceMaterials, List<Long> itemIdList) {
        EchoMethod.echoAfterTime("fill-Item :" + Thread.currentThread().getName(), 10000, TimeUnit.MILLISECONDS);
        priceSourceMaterials.setItem("fill item");
    }

    public void fillSourceMaterialsItemPriceRule(PriceSourceMaterials priceSourceMaterials, List<Long> itemIdList,
                                                 ProvinceArea provinceArea) {
        EchoMethod.echoAfterTime("fill-PriceRule:" + Thread.currentThread().getName(), 100, TimeUnit.MILLISECONDS);

    }

    public void fillSourceMaterialsItemBatchByItemIdList(PriceSourceMaterials priceSourceMaterials,
                                                         List<Long> itemIdList) {
        System.out.println("--------fill-Batch start");
        EchoMethod.echoAfterTime("fill-Batch:" + Thread.currentThread().getName(), 2000, TimeUnit.MILLISECONDS);
        System.out.println("--------fill-Batch end");

        priceSourceMaterials.setBatch("fill batch");
    }

    public void fillSourceMaterialsLogisticCarry(PriceSourceMaterials priceSourceMaterials,
                                                 Set<Long> logisticTemplateIdSet, Integer filterLogisticType,
                                                 Boolean filterLogisticTypeIsByReal) {
        EchoMethod.echoAfterTime("fill-LogisticCarry:" + Thread.currentThread().getName(), 500, TimeUnit.MILLISECONDS);
    }

    public void fillSourceMaterialsPackFee(PriceSourceMaterials priceSourceMaterials, Set<Long> packTemplateIdSet,
                                           Integer spec) {
        EchoMethod.echoAfterTime("fill-PackFee:" + Thread.currentThread().getName(), 500, TimeUnit.MILLISECONDS);

    }

    public void fillSourceMaterialsBiddingPrice(PriceSourceMaterials priceSourceMaterials, ProvinceArea provinceArea) {
        EchoMethod.echoAfterTime("fill-BiddingPrice:" + Thread.currentThread().getName(), 500, TimeUnit.MILLISECONDS);
    }

    public void fillSourceMaterialsPreferenceFromUmp(PriceSourceMaterials priceSourceMaterials,
                                                     MixItemPriceFactoryContract mixItemPriceFactoryContract) {
        EchoMethod.echoAfterTime(
                "fill-PreferenceFromUmp:" + Thread.currentThread().getName(), 500, TimeUnit.MILLISECONDS);
    }
}
