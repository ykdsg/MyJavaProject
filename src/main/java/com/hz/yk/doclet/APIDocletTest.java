package com.hz.yk.doclet;

/**
 * @author wuzheng.yk
 *         Date: 13-3-20
 *         Time: ÉÏÎç11:44
 */
public class APIDocletTest {

    public static void main(String[] args) {
//        String[] docArgs = new String[]{"-doclet", APIDoclet.class.getName(),
//                System.getProperty("user.dir") + "/src/main/java/" + "com/hz/yk/concurrent/aqs/BooleanMutex.java"};
      String javaFile1=System.getProperty("user.dir") + "/src/main/java/" + "com/hz/yk/concurrent/aqs/BooleanMutex.java";
      String javaFile2=System.getProperty("user.dir") + "/src/main/java/" + "com/hz/yk/nio/BaiduReader.java";
      String javaFile3=System.getProperty("user.dir") + "/src/main/java/" + "com/hz/yk/nio/UseFloatBuffer.java";
        String[] docArgs = new String[]{"-doclet", "com.hz.yk.doclet.MyHtmlDoclet", "-d",
                System.getProperty("user.dir")+"/src/main/resources/apidocs",
                javaFile1,javaFile2,javaFile3 };

        com.sun.tools.javadoc.Main.execute(docArgs);
    }
}
