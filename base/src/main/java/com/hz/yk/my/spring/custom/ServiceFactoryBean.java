package com.hz.yk.my.spring.custom;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by wuzheng.yk on 16/9/9.
 */
public class ServiceFactoryBean implements FactoryBean {

    private Retrofit retrofit;

    private Class serviceClass;

    public void setServiceClass(Class serviceClass) {
        this.serviceClass = serviceClass;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public Object getObject() throws Exception {

        return retrofit.create(this.serviceClass);
    }

    @Override
    public Class getObjectType() {
        return serviceClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
