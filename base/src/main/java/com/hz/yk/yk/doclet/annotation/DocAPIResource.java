package com.hz.yk.yk.doclet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wuzheng.yk
 *         Date: 13-3-20
 *         Time: 上午10:12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface DocAPIResource {
    /**
     * 资源的标识名称（允许多个，之间以','隔开）注：名称必须符合Java的变量命名规范
     *
     * @return
     */
    String value() default "";
}
