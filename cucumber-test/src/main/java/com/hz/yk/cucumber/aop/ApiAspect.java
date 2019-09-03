package com.hz.yk.cucumber.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wuzheng.yk
 * @date 2019/9/2
 */
@Component
@Aspect
public class ApiAspect {

    @Pointcut("execution(* com.hz.yk.cucumber.service..*.*(..))")
    public void aspectException() {}

    @Around("aspectException()")
    public Object doProcess(ProceedingJoinPoint pjp) {
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
