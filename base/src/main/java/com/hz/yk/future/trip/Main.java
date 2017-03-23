package com.hz.yk.future.trip;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.stream.Collectors.toList;

/**
 * Created by wuzheng.yk on 17/3/17.
 */
public class Main {

    /**
     * 为了选择最佳的旅行计划，需要查询每个服务供应商为我们的旅行所给定的规划，
     * 然后使用Comparator来对比每个规划结果，这个Comparator反映了我们的选择标准（在本例中，只是简单的选择价格最低者）：
     * @param serviceList
     * @return
     */
    TripPlan selectBestTripPlan(List<ServiceSupplier> serviceList) {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                System.out.println("exec");
            }
        };
        List<CompletableFuture<TripPlan>> tripPlanFutures = serviceList.stream()
                .map(svc -> CompletableFuture.supplyAsync(svc::createPlan, executor))
                .collect(toList());

        return tripPlanFutures.stream()
                .min(Comparator.comparing(cf -> cf.join().getPrice()))
                .get().join();
    }
}
