package com.hz.yk.spring.beans.factory.xml;

import com.hz.yk.spring.beans.factory.config.BeanDefinition;
import com.hz.yk.spring.beans.factory.BeanFactory;
import com.hz.yk.spring.beans.factory.support.BeanDefinitionRegistry;
import com.hz.yk.spring.core.io.Resource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

/**
 * @author wuzheng.yk
 *         Date: 13-2-9
 *         Time: ����3:57
 */
public class XmlBeanFactory implements BeanDefinitionRegistry {
    private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);


    /**
     * Create a new XmlBeanFactory with the given resource,
     * which must be parsable using DOM.
     * @param resource XML resource to load bean definitions from
     * @throws BeansException in case of loading or parsing errors
     */
    public XmlBeanFactory(Resource resource) throws BeansException {
        this(resource, null);
    }

    /**
     * Create a new XmlBeanFactory with the given input stream,
     * which must be parsable using DOM.
     * @param resource XML resource to load bean definitions from
     * @param parentBeanFactory parent bean factory
     * @throws org.springframework.beans.BeansException in case of loading or parsing errors
     */
    public XmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) throws BeansException {
        this.reader.loadBeanDefinitions(resource);
    }


    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionStoreException {
        //TODO
    }

    @Override
    public void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
        //TODO
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException {
        return null;  //TODO
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return false;  //TODO
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return new String[0];  //TODO
    }

    @Override
    public int getBeanDefinitionCount() {
        return 0;  //TODO
    }

    @Override
    public boolean isBeanNameInUse(String beanName) {
        return false;  //TODO
    }

    @Override
    public void registerAlias(String name, String alias) {
        //TODO
    }

    @Override
    public void removeAlias(String alias) {
        //TODO
    }

    @Override
    public boolean isAlias(String beanName) {
        return false;  //TODO
    }

    @Override
    public String[] getAliases(String name) {
        return new String[0];  //TODO
    }
}
