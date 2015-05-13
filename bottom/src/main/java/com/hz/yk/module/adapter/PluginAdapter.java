package com.hz.yk.module.adapter;


import com.hz.yk.module.plugin.Plugin;
import com.hz.yk.module.router.RouterInfo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 10:08
 */
public class PluginAdapter implements ApplicationContextAware {
    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    //TODO 需要加上缓存
    public  <T> T getInstance(Class<T> clazz,RouterInfo routerInfo) {
        if (!Plugin.class.isAssignableFrom(clazz)) {
            throw new RuntimeException("this class is not plugin");
        }
        String interfaceName = clazz.getSimpleName();
        String className = interfaceName + routerInfo.getClassPostfix();
        String prefix = routerInfo.getPackagePrefix();
        String classFullName = prefix + className;
        try {
            Class implClass = this.getClass().getClassLoader().loadClass(classFullName);
            //获取context中需要注入的bean
            T instance = (T) context.getAutowireCapableBeanFactory().autowire(implClass, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, true);

            return instance;
        } catch (ClassNotFoundException e) {
            System.out.println("class not found,className = " + classFullName + "; will load default class");
            String defaultBeanName = "default" + interfaceName;
            T defaultInstance = context.getBean(defaultBeanName, clazz);
            return defaultInstance;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
