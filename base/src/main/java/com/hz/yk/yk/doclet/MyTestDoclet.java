package com.hz.yk.yk.doclet;

import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.RootDoc;
import com.sun.tools.doclets.formats.html.ConfigurationImpl;
import com.sun.tools.doclets.internal.toolkit.Configuration;
import com.sun.tools.doclets.standard.Standard;

/**
 * @author wuzheng.yk
 *         Date: 13-3-21
 *         Time: 上午10:03
 */
public class MyTestDoclet extends MyHtmlDoclet{
    /**
     * The global configuration information for this run.
     */
    public ConfigurationImpl configuration;


    public MyTestDoclet() {
        configuration = (ConfigurationImpl) configuration();
    }
    public static boolean start(RootDoc root) {
        System.out.println("~~~~~~~~~~~~~~~~~");
        return true;
    }

    /**
     * Create the configuration instance.
     * Override this method to use a different
     * configuration.
     */
    public Configuration configuration() {
        return ConfigurationImpl.getInstance();
    }


    /**
     * 这两个方法必须有，否则标准  doclet 参数将不能使用，比如: -d
     * Check that options have the correct arguments here.
     * <p/>
     * This method is not required and will default gracefully
     * (to true) if absent.
     * <p/>
     * Printing option related error messages (using the provided
     * DocErrorReporter) is the responsibility of this method.
     *
     * @return true if the options are valid.
     */
    public static boolean validOptions(String options[][], DocErrorReporter reporter) {
        return Standard.validOptions(options, reporter);
    }

    public static int optionLength(String option) {
        return Standard.optionLength(option);
    }
}
