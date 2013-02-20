package com.hz.yk.spring.beans.factory;

import com.hz.yk.spring.beans.exception.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

/**
 * @author wuzheng.yk
 *         Date: 13-2-7
 *         Time: ÏÂÎç9:54
 */
public interface BeanFactory {


    String FACTORY_BEAN_PREFIX = "&";
    /**
     * Return an instance, which may be shared or independent, of the specified bean.
     * <p>This method allows a Spring BeanFactory to be used as a replacement for the
     * Singleton or Prototype design pattern. Callers may retain references to
     * returned objects in the case of Singleton beans.
     * <p>Translates aliases back to the corresponding canonical bean name.
     * Will ask the parent factory if the bean cannot be found in this factory instance.
     * */
    Object getBean(String name) throws BeansException;
    /**
     * Return an instance, which may be shared or independent, of the specified bean.
     * <p>Behaves the same as {@link #getBean(String)}, but provides a measure of type
     * safety by throwing a BeanNotOfRequiredTypeException if the bean is not of the
     * required type. This means that ClassCastException can't be thrown on casting
     * the result correctly, as can happen with {@link #getBean(String)}.
     * <p>Translates aliases back to the corresponding canonical bean name.
     * Will ask the parent factory if the bean cannot be found in this factory instance.
     *  */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
    /**
     * Return an instance, which may be shared or independent, of the specified bean.
     * <p>Allows for specifying explicit constructor arguments / factory method arguments,
     * overriding the specified default arguments (if any) in the bean definition.
     *  */
    Object getBean(String name, Object... args) throws BeansException;
    /**
     * Does this bean factory contain a bean with the given  name? More specifically,
     * is {@link #getBean} able to obtain a bean instance for the given name?
     * <p>Translates aliases back to the corresponding canonical bean name.
     * Will ask the parent factory if the bean cannot be found in this factory instance.
     */
    boolean containsBean(String name);
/**
 * Is this bean a shared singleton? That is, will {@link #getBean} always
 * return the same instance?
 * <p>Note: This method returning <code>false</code> does not clearly indicate
 * independent instances. It indicates non-singleton instances, which may correspond
 * to a scoped bean as well. Use the {@link #isPrototype} operation to explicitly
 * check for independent instances.
 * <p>Translates aliases back to the corresponding canonical bean name.
 * Will ask the parent factory if the bean cannot be found in this factory instance.
 */
boolean isSingleton(String name) throws NoSuchBeanDefinitionException;
    /**
     * Is this bean a prototype? That is, will {@link #getBean} always return
     * independent instances?
     * <p>Note: This method returning <code>false</code> does not clearly indicate
     * a singleton object. It indicates non-independent i nstances, which may correspond
     * to a scoped bean as well. Use the {@link #isSingleton} operation to explicitly
     * check for a shared singleton instance.
     * <p>Translates aliases back to the corresponding canonical bean name.
     * Will ask the parent factory if the bean cannot be found in this factory instance.
     */
    boolean isPrototype(String name) throws NoSuchBeanDefinitionException;
    /**
     * Check whether the bean with the given name matches the specified type.
     * More specifically, check whether a {@link #getBean} call for the given name
     * would return an object that is assignable to the specified target type.
     * <p>Translates aliases back to the corresponding canonical bean name.
     * Will ask the parent factory if the bean cannot be found in this factory instance.
     */
    boolean isTypeMatch(String name, Class targetType) throws NoSuchBeanDefinitionException;


    Class getType(String name) throws NoSuchBeanDefinitionException;
    /**
     * Return the aliases for the given bean name, if any.
     * All of those aliases point to the same bean when used in a {@link #getBean} call.
     * <p>If the given name is an alias, the corresponding original bean name
     * and other aliases (if any) will be returned, with the original bean name
     * being the first element in the array.
     * <p>Will ask the parent factory if the bean cannot be found in this factory instance.
     */
    String[] getAliases(String name);





}
