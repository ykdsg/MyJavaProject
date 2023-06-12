package com.hz.yk.url;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceConfigurationError;

/**
 * Created by wuzheng.yk on 2017/8/3.
 */
public class TestDemo {
    private static final String PREFIX = "META-INF/services/";


    @Test
    public void test() throws IOException {
        String fullName = PREFIX + "test.ITestFactory";
        Enumeration<URL> configs = ClassLoader.getSystemResources(fullName);

        Iterator<String> pending =parse(TestDemo.class, configs.nextElement());

        System.out.println(pending);

    }



    private Iterator<String> parse(Class service, URL u) throws ServiceConfigurationError {
        InputStream in = null;
        BufferedReader r = null;
        ArrayList<String> names = new ArrayList<String>();
        try {
            in = u.openStream();
            r = new BufferedReader(new InputStreamReader(in, "utf-8"));
            int lc = 1;
            while ((lc = parseLine(service, u, r, lc, names)) >= 0) {
                ;
            }
        } catch (IOException x) {
            x.printStackTrace();
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException y) {
                y.printStackTrace();
            }
        }
        return names.iterator();
    }

    private int parseLine(Class service, URL u, BufferedReader r, int lc, List<String> names) throws IOException,
                                                                                                     ServiceConfigurationError {
        String ln = r.readLine();
        if (ln == null) {
            return -1;
        }
        int ci = ln.indexOf('#');
        if (ci >= 0) {
            ln = ln.substring(0, ci);
        }
        ln = ln.trim();
        int n = ln.length();
        if (n != 0) {
            if (ln.indexOf(' ') >= 0 || ln.indexOf('\t') >= 0) {
                System.out.println("Illegal configuration-file syntax");
                return lc + 1;
            }
            int cp = ln.codePointAt(0);
            if (!Character.isJavaIdentifierStart(cp)) {
                System.out.println("Illegal provider-class name: " + ln);

                return lc + 1;
            }
            for (int i = Character.charCount(cp); i < n; i += Character.charCount(cp)) {
                cp = ln.codePointAt(i);
                if (!Character.isJavaIdentifierPart(cp) && cp != '.') {
                    System.out.println( "Illegal provider-class name: " + ln);
                    return lc + 1;
                }
            }
            if (!names.contains(ln)) {
                names.add(ln);
            }
        }
        return lc + 1;
    }
}

