package com.hz.yk.my.spring.actuator;

import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.HealthIndicatorAutoConfiguration;
import org.springframework.boot.actuate.endpoint.HealthEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.EndpointHandlerMapping;
import org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.MvcEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Collection;

/**
 * Created by wuzheng.yk on 2017/12/12.
 */
/*
EndpointAutoConfiguration类是Spring Boot Actuator的基础配置类
HealthIndicatorAutoConfiguration类是/health端点的基础配置
 */
@Configuration
@Import({ EndpointAutoConfiguration.class, HealthIndicatorAutoConfiguration.class })
public class MyAppSpringConfig {

    @Bean
    public EndpointHandlerMapping endpointHandlerMapping(Collection<? extends MvcEndpoint> endpoints) {
        return new EndpointHandlerMapping(endpoints);
    }

    @Bean
    public HealthMvcEndpoint healthMvcEndpoint(HealthEndpoint delegate) {
        return new HealthMvcEndpoint(delegate, false);
    }
}
