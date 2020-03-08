package com.hz.yk.my.spring.source.beans.factory.support;

import com.hz.yk.my.spring.source.beans.factory.config.BeanDefinition;
import com.hz.yk.my.spring.source.core.AliasRegistry;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

/**
 * @author wuzheng.yk
 * Date: 13-2-11
 * Time: ����11:31
 */
public interface BeanDefinitionRegistry extends AliasRegistry {

    /**
     * Register a new bean definition with this registry.
     * Must support RootBeanDefinition and ChildBeanDefinition.
     *
     * @param beanName       the name of the bean instance to register
     * @param beanDefinition definition of the bean instance to register
     * @throws BeanDefinitionStoreException if the BeanDefinition is invalid
     *                                      or if there is already a BeanDefinition for the specified bean name
     *                                      (and we are not allowed to override it)
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) throws BeanDefinitionStoreException;

    /**
     * Remove the BeanDefinition for the given name.
     *
     * @param beanName the name of the bean instance to register
     * @throws NoSuchBeanDefinitionException if there is no such bean definition
     */
    void removeBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;

    /**
     * Return the BeanDefinition for the given bean name.
     *
     * @param beanName name of the bean to find a definition for
     * @return the BeanDefinition for the given name (never <code>null</code>)
     * @throws NoSuchBeanDefinitionException if there is no such bean definition
     */
    BeanDefinition getBeanDefinition(String beanName) throws NoSuchBeanDefinitionException;

    /**
     * Check if this registry contains a bean definition with the given name.
     *
     * @param beanName the name of the bean to look for
     * @return if this registry contains a bean definition with the given name
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * Return the names of all beans defined in this registry.
     *
     * @return the names of all beans defined in this registry,
     * or an empty array if none defined
     */
    String[] getBeanDefinitionNames();

    /**
     * Return the number of beans defined in the registry.
     *
     * @return the number of beans defined in the registry
     */
    int getBeanDefinitionCount();

    /**
     * Determine whether the given bean name is already in use within this registry,
     * i.e. whether there is a local bean or alias registered under this name.
     *
     * @param beanName the name to check
     * @return whether the given bean name is already in use
     */
    boolean isBeanNameInUse(String beanName);

}
