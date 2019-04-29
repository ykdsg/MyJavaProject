package com.hz.yk.springboot.config;

import com.hz.yk.springboot.component.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author wuzheng.yk
 * @date 2019-04-18
 */
@Configuration
public class RouterConfig {

    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"), req -> timeHandler.getTime(req)).andRoute(GET("/date"), timeHandler::getDate)
                                                                   .andRoute(GET("/times"), timeHandler::sendTimePerSec);
    }
}
