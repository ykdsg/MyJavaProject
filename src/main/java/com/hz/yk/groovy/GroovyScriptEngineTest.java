package com.hz.yk.groovy;

import java.io.IOException;
import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;
import org.junit.Test;

public class GroovyScriptEngineTest {

    @Test
    public void testCallScript() throws IOException, ResourceException, ScriptException {
        // 2.在Java代码中调用Groovy脚本
        String[] roots = new String[] { "src/main/resources/groovy/" };
        GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine(roots);
        Binding binding = new Binding();
        binding.setVariable("input", "world");
        groovyScriptEngine.run("hello.groovy", binding);
        System.out.println(binding.getVariable("output"));
    }
}
