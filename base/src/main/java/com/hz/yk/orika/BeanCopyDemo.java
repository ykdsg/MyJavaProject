package com.hz.yk.orika;

import com.brucecloud.fastclone.FastClone;
import com.google.common.collect.Lists;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import net.sf.cglib.beans.BeanCopier;
import org.dozer.DozerBeanMapper;

/**
 * Created by wuzheng.yk on 2017/12/21.
 */
public class BeanCopyDemo {

    private static int count = 100000;

    static DozerBeanMapper dozer         = new DozerBeanMapper();
    static MapperFactory   mapperFactory = new DefaultMapperFactory.Builder().build();
    static MapperFacade    orikaMapper   = mapperFactory.getMapperFacade();
    static FastClone       fastClone     = new FastClone();

    static {
        dozer.setMappingFiles(Lists.newArrayList("dozerJdk8Converters.xml"));
    }

    public static void main(String[] args) throws Exception {
        //先预热一遍
        testTime("dozer");
        testTime("orika");
        testTime("cglib");
        testTime("fast");

        System.out.println("------------real start---------------");
        testTime("dozer");
        testTime("orika");
        testTime("cglib");
        testTime("fast");
    }

    public static void testTime(String name) throws Exception {
        User customer = new User(11211L, "testName");
        User employee = new User();

        long start = System.currentTimeMillis();
        switch (name) {
            case "dozer":
                testDozer(customer, employee);
                break;
            case "orika":
                testOrika(customer, employee);
                break;
            case "cglib":
                testCglibBeanCopier(customer, employee);
                break;
            case "fast":
                testFastClone(customer, employee);
                break;
        }

        System.out.println(name + " count: " + count + " cost: " + (System.currentTimeMillis() - start) + " ms");
    }

    public static void testFastClone(Object src, Object target) throws Exception {
        for (int i = 0; i < count; i++) {
            Object clone = fastClone.clone(src);
        }
    }

    public static void testCglibBeanCopier(Object src, Object target) {
        for (int i = 0; i < count; i++) {
            BeanCopier copier = BeanCopier.create(src.getClass(), target.getClass(), false);
            copier.copy(src, target, null);
        }
    }

    public static void testOrika(Object src, Object target) {
        for (int i = 0; i < count; i++) {
            orikaMapper.map(src, target);
        }
    }

    public static void testDozer(Object src, Object target) {
        for (int i = 0; i < count; i++) {
            dozer.map(src, target);
        }
    }

}
