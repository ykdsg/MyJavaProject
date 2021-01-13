package com.hz.yk.spring.custom;

import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * Created by wuzheng.yk on 16/9/9.
 */
public class CustomBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private static final Logger log = LoggerFactory.getLogger(CustomBeanDefinitionRegistryPostProcessor.class);
    private String packageName;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        Reflections reflections = new Reflections(packageName);
        Retrofit retrofit = retrofit();
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(RetrofitService.class);
        for (Class<?> serviceClass : annotated) {
            for (Annotation annotation : serviceClass.getAnnotations()) {
                if (annotation instanceof RetrofitService) {//自定义注解RetrofitService，都需要通过retrofit创建bean
                    RootBeanDefinition beanDefinition = new RootBeanDefinition();
                    beanDefinition.setBeanClass(ServiceFactoryBean.class);
                    beanDefinition.setLazyInit(true);
                    beanDefinition.getPropertyValues().addPropertyValue("retrofit", retrofit);
                    beanDefinition.getPropertyValues().addPropertyValue("serviceClass", serviceClass);
                    String beanName = serviceClass.getSimpleName();
                    registry.registerBeanDefinition(beanName, beanDefinition);
                }
            }
        }
    }

    public Retrofit retrofit() {
        return new Retrofit();

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
