package com.hz.yk.instrument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Created by wuzheng.yk on 15/11/4.
 */
public class ClassPlazzMonitor implements ClassFileTransformer {
    static final String LINUX_OUT = "/Users/ykdsg/";
    static final String TEMP_FILE = "/Users/ykdsg/temp";
    static final String LINUX_OUT_FILE = "apglazz.txt";
    private String targetClassName;
    private boolean useMatch;
    private PrintWriter logOut;

    public ClassPlazzMonitor(String className)
    {
        File outDir = new File("/Users/ykdsg/");
        if (outDir.exists())
            try {
                FileWriter out = new FileWriter(new File(outDir, "apglazz.txt"));
                this.logOut = new PrintWriter(out);
            } catch (IOException e) {
                this.logOut = new PrintWriter(new OutputStreamWriter(System.out));
            }
        else {
            this.logOut = new PrintWriter(new OutputStreamWriter(System.out));
        }

        if (className == null) {
            className = "";
        }
        if (className != null) {
            this.targetClassName = className.replace('.', '/');
        }
        log("input: " + this.targetClassName);
        if (className.endsWith("*")) {
            this.useMatch = true;
            this.targetClassName = this.targetClassName.substring(0, this.targetClassName.length() - 1);
        }
        log("useMatch: " + this.useMatch);
    }

    private static void writeToFile(URL url, String name) throws IOException {
        String[] parts = name.split("/");
        name = parts[(parts.length - 1)];
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(new File("/Users/ykdsg/temp", name));
        byte[] buf = new byte[1024];
        while (true) {
            int len = is.read(buf);
            if (len < 0) {
                break;
            }
            os.write(buf, 0, len);
        }
        os.close();
        is.close();
    }

    public static void premain(String options, Instrumentation ins)
    {
        if (options != null) {
            ins.addTransformer(new ClassPlazzMonitor(options));
        } else {
            System.out.println("Usage: java -javaagent:juglazz.jar=\"className\"");
            System.exit(0);
        }
    }

    void log(String msg)
    {
        this.logOut.println("juglazz: " + msg);
        this.logOut.flush();
    }

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (this.useMatch) {
            if (className.startsWith(this.targetClassName)) {
                String name = className;
                String compareClass = className.replace('.', '/');
                compareClass = compareClass + ".class";
                URL url = loader.getResource(compareClass);
                log(this.targetClassName + " is load from " + url.toString());
                try {
                    log(className + " dump !");

                    log("loader:" + loader);

                    ClassLoader parent = loader.getParent();

                    while (parent != null) {
                        log("parent:" + parent);
                        parent = parent.getParent();
                    }

                    writeToFile(url, name);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return classfileBuffer;
        }
        if (className.equals(this.targetClassName)) {
            String compareClass = className.replace('.', '/');
            compareClass = compareClass + ".class";
            URL url = loader.getResource(compareClass);
            log(this.targetClassName + " is load from " + url.toString());
        }
        return classfileBuffer;
    }
}
