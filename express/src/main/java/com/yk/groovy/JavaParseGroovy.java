package com.yk.groovy;

import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created by wuzheng.yk on 2017/6/27.
 */
public class JavaParseGroovy {
    static String groovyFile = "com/yk/groovy/HelloWord.groovy";

    public static void main(String[] args) throws FileNotFoundException, IOException, javax.script.ScriptException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("groovy");
        //先测试下，行不行
        System.out.println("groovy解析结果:"+engine.eval("println 'HelloWord' \n 'HelloWordReturn'"));
        //读取源Groovy源程序
        String fileFullPath = rootDir()+"/src/main/java/"+groovyFile;
        String scriptContent = IOUtils.toString(new FileInputStream(fileFullPath));
        System.out.println("----------groovy-exec----------");
        engine.eval(scriptContent);
    }

    public static String rootDir(){
        String classDir=JavaParseGroovy.class.getClassLoader().getResource("").getPath();
        List classDirLsit = Lists.newArrayList(classDir.split("/"));
        List newClassDirList = classDirLsit.subList(0, classDirLsit.size() - 2);

        String newPath = String.join("/", newClassDirList);

        return newPath;
    }
}
