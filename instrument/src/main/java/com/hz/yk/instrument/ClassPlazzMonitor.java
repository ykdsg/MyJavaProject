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

public class ClassPlazzMonitor implements ClassFileTransformer {

    static final String LINUX_OUT = "/Users/ykdsg/";
    static final String TEMP_FILE = "/Users/ykdsg/temp";
    static final String LINUX_OUT_FILE = "apglazz.txt";
    private String targetClassName;
    private boolean useMatch;
    private PrintWriter logOut;

    public ClassPlazzMonitor(String className) {
        super();
        File outDir = new File(LINUX_OUT);
        if (outDir.exists()) {
            try {
                FileWriter out = new FileWriter(new File(outDir, LINUX_OUT_FILE));
                logOut = new PrintWriter(out);
            } catch (IOException e) {
                logOut = new PrintWriter(new OutputStreamWriter(System.out));
            }
        } else {
            logOut = new PrintWriter(new OutputStreamWriter(System.out));
        }

        if (className == null) {
            className = "";
        }
        if (className != null) {
            this.targetClassName = className.replace('.', '/');
        }
        log("input: " + this.targetClassName);
        if (className.endsWith("*")) {
            useMatch = true;
            this.targetClassName = this.targetClassName.substring(0, targetClassName.length() - 1);
        }
        log("useMatch: " + useMatch);
    }

    private static void writeToFile(URL url, String name) throws IOException {
        String[] parts = name.split("/");
        name = parts[parts.length - 1];
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(new File(TEMP_FILE, name));
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

    public static void premain(String options, Instrumentation ins) {
        if (options != null) {
            ins.addTransformer(new ClassPlazzMonitor(options));
        } else {
            System.out.println("Usage: java -javaagent:juglazz.jar=\"className\"");
            System.exit(0);
        }

    }

    void log(String msg) {
        logOut.println("juglazz: " + msg);
        logOut.flush();
    }

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (useMatch) {
            if (className.startsWith(targetClassName)) {
                String name = className;
                String compareClass = className.replace('.', '/');
                compareClass = compareClass + ".class";
                URL url = loader.getResource(compareClass);
                log(this.targetClassName + " is load from " + url.toString());
                try {
                    log(className + " dump !");
                    //  List resources = Collections.list(loader.getResources("/"));
                    log("loader:" + loader);

                    ClassLoader parent = loader.getParent();

                    while (parent != null) {
                        log("parent:" + parent);
                        parent = parent.getParent();
                    }

                    writeToFile(url, name);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return classfileBuffer;
        } else {
            if (className.equals(targetClassName)) {
                String compareClass = className.replace('.', '/');
                compareClass = compareClass + ".class";
                URL url = loader.getResource(compareClass);
                log(this.targetClassName + " is load from " + url.toString());
            }
            return classfileBuffer;
        }
    }

}
