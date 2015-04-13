package com.hz.yk.yk.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.junit.Test;

public class GroovyClassLoaderTest {

    @Test
    public void testCallObject() throws InstantiationException, IllegalAccessException {
        // 3.在Java代码中调用Groovy对象
        // Get ClassLoader
        ClassLoader parent = GroovyClassLoaderTest.class.getClassLoader();
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader(parent);

        // Get ScriptClass
        Class<?> groovyClass = groovyClassLoader.parseClass("public class SomeGroovyObject{ public void exe(String req){ println 'Hello,'+req+'!'; } }");

        // Script Object Instance
        GroovyObject groovyObject = null;
        groovyObject = (GroovyObject) groovyClass.newInstance();

        // Set Context
        Object request = "bafeng";

        // InvokeMethod Run
        groovyObject.getMetaClass().invokeMethod(groovyObject, "exe", new Object[] { request });
    }
}
