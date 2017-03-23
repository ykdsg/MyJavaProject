package com.hz.yk.future.trip;

import java.util.List;

/**
 * Created by wuzheng.yk on 17/3/17.
 */
public interface TripPlan {
    List<ServiceSupplier> getSuppliers();
    int getPrice();
    TripPlan combine();
}
