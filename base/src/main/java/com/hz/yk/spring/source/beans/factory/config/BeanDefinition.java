package com.hz.yk.spring.source.beans.factory.config;

import com.hz.yk.spring.source.beans.BeanMetadataElement;
import com.hz.yk.spring.source.beans.factory.AttributeAccessor;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

/**
 * @author wuzheng.yk
 * Date: 13-2-12
 * Time: ����11:35
 */
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {

    /**
     * Scope identifier for the standard singleton scope: "singleton".
     * <p>Note that extended bean factories might support further scopes.
     *
     * @see #setScope
     */
    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    /**
     * Scope identifier for the standard prototype scope: "prototype".
     * <p>Note that extended bean factories might support further scopes.
     *
     * @see #setScope
     */
    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    /**
     * Role hint indicating that a <code>BeanDefinition</code> is a major part
     * of the application. Typically corresponds to a user-defined bean.
     */
    int ROLE_APPLICATION = 0;

    /**
     * Role hint indicating that a <code>BeanDefinition</code> is a supporting
     * part of some larger configuration, typically an outer
     * {@link org.springframework.beans.factory.parsing.ComponentDefinition}.
     * <code>SUPPORT</code> beans are considered important enough to be aware
     * of when looking more closely at a particular
     * {@link org.springframework.beans.factory.parsing.ComponentDefinition},
     * but not when looking at the overall configuration of an application.
     */
    int ROLE_SUPPORT = 1;

    /**
     * Role hint indicating that a <code>BeanDefinition</code> is providing an
     * entirely background role and has no relevance to the end-user. This hint is
     * used when registering beans that are completely part of the internal workings
     * of a {@link org.springframework.beans.factory.parsing.ComponentDefinition}.
     */
    int ROLE_INFRASTRUCTURE = 2;

    /**
     * Return the name of the parent definition of this bean definition, if any.
     */
    String getParentName();

    /**
     * Set the name of the parent definition of this bean definition, if any.
     */
    void setParentName(String parentName);

    /**
     * Return the current bean class name of this bean definition.
     * <p>Note that this does not have to be the actual class name used at runtime, in
     * case of a child definition overriding/inheriting the class name from its parent.
     * Hence, do <i>not</i> consider this to be the definitive bean type at runtime but
     * rather only use it for parsing purposes at the individual bean definition level.
     */
    String getBeanClassName();

    /**
     * Override the bean class name of this bean definition.
     * <p>The class name can be modified during bean factory post-processing,
     * typically replacing the original class name with a parsed variant of it.
     */
    void setBeanClassName(String beanClassName);

    /**
     * Return the factory bean name, if any.
     */
    String getFactoryBeanName();

    /**
     * Specify the factory bean to use, if any.
     */
    void setFactoryBeanName(String factoryBeanName);

    /**
     * Return a factory method, if any.
     */
    String getFactoryMethodName();

    /**
     * Specify a factory method, if any. This method will be invoked with
     * constructor arguments, or with no arguments if none are specified.
     * The method will be invoked on the specifed factory bean, if any,
     * or as static method on the local bean class else.
     *
     * @param factoryMethodName static factory method name,
     *                          or <code>null</code> if normal constructor creation should be used
     * @see #getBeanClassName()
     */
    void setFactoryMethodName(String factoryMethodName);

    /**
     * Return the name of the current target scope for this bean.
     */
    String getScope();

    /**
     * Override the target scope of this bean, specifying a new scope name.
     *
     * @see #SCOPE_SINGLETON
     * @see #SCOPE_PROTOTYPE
     */
    void setScope(String scope);

    /**
     * Return whether this bean is a candidate for getting autowired into some other bean.
     */
    boolean isAutowireCandidate();

    /**
     * Set whether this bean is a candidate for getting autowired into some other bean.
     */
    void setAutowireCandidate(boolean autowireCandidate);

    /**
     * Return the constructor argument values for this bean.
     * <p>The returned instance can be modified during bean factory post-processing.
     *
     * @return the ConstructorArgumentValues object (never <code>null</code>)
     */
    ConstructorArgumentValues getConstructorArgumentValues();

    /**
     * Return the property values to be applied to a new instance of the bean.
     * <p>The returned instance can be modified during bean factory post-processing.
     *
     * @return the MutablePropertyValues object (never <code>null</code>)
     */
    MutablePropertyValues getPropertyValues();

    /**
     * Return whether this a <b>Singleton</b>, with a single, shared instance
     * returned on all calls.
     */
    boolean isSingleton();

    /**
     * Return whether this bean is "abstract", that is, not meant to be instantiated.
     */
    boolean isAbstract();

    /**
     * Return whether this bean should be lazily initialized, that is, not
     * eagerly instantiated on startup.
     */
    boolean isLazyInit();

    /**
     * Get the role hint for this <code>BeanDefinition</code>. The role hint
     * provides tools with an indication of the importance of a particular
     * <code>BeanDefinition</code>.
     *
     * @see #ROLE_APPLICATION
     * @see #ROLE_INFRASTRUCTURE
     * @see #ROLE_SUPPORT
     */
    int getRole();

    /**
     * Return a human-readable description of this bean definition.
     */
    String getDescription();

    /**
     * Return a description of the resource that this bean definition
     * came from (for the purpose of showing context in case of errors).
     */
    String getResourceDescription();

    /**
     * Return the originating BeanDefinition, or <code>null</code> if none.
     * Allows for retrieving the decorated bean definition, if any.
     * <p>Note that this method returns the immediate originator. Iterate through the
     * originator chain to find the original BeanDefinition as defined by the user.
     */
    BeanDefinition getOriginatingBeanDefinition();
}
