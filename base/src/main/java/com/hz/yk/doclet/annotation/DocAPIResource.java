package com.hz.yk.doclet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wuzheng.yk
 *         Date: 13-3-20
 *         Time: ����10:12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface DocAPIResource {
    /**
     * ��Դ�ı�ʶ���ƣ���������֮����','������ע�����Ʊ������Java�ı��������淶
     *
     * @return
     */
    String value() default "";
}
