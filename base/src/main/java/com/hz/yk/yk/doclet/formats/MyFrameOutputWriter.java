package com.hz.yk.yk.doclet.formats;

import com.sun.tools.doclets.formats.html.ConfigurationImpl;
import com.sun.tools.doclets.formats.html.HtmlDocletWriter;
import com.sun.tools.doclets.internal.toolkit.util.DocletAbortException;
import java.io.IOException;

/**
 * @author wuzheng.yk
 *         Date: 13-3-22
 *         Time: ÉÏÎç10:18
 */
public class MyFrameOutputWriter extends HtmlDocletWriter {

    /**
     * Number of packages specified on the command line.
     */
    int noOfPackages;

    /**
     * Constructor to construct FrameOutputWriter object.
     *
     * @param filename File to be generated.
     */
    public MyFrameOutputWriter(ConfigurationImpl configuration, String filename) throws IOException {
        super(configuration, filename);
        noOfPackages = configuration.packages.length;
    }

    /**
     * Construct FrameOutputWriter object and then use it to generate the Html
     * file which will have the description of all the frames in the
     * documentation. The name of the generated file is "index.html" which is
     * the default first file for Html documents.
     *
     * @throws com.sun.tools.doclets.internal.toolkit.util.DocletAbortException
     *
     */
    public static void generate(ConfigurationImpl configuration) {
        MyFrameOutputWriter framegen;
        String filename = "";
        try {
            filename = "index.html";
            framegen = new MyFrameOutputWriter(configuration, filename);
            framegen.generateFrameFile();
            framegen.close();
        } catch (IOException exc) {
            configuration.standardmessage.error("doclet.exception_encountered", exc.toString(), filename);
            throw new DocletAbortException();
        }
    }

    /**
     * Generate the contants in the "index.html" file. Print the frame details
     * as well as warning if browser is not supporting the Html frames.
     */
    protected void generateFrameFile() {
        if (configuration.windowtitle.length() > 0) {
            printFramesetHeader(configuration.windowtitle, configuration.notimestamp);
        } else {
            printFramesetHeader(configuration.getText("doclet.Generated_Docs_Untitled"), configuration.notimestamp);
        }
        printFrameDetails();
        printFrameFooter();
    }

    /**
     * Generate the code for issueing the warning for a non-frame capable web
     * client. Also provide links to the non-frame version documentation.
     */
    protected void printFrameWarning() {
        noFrames();
        h2();
        printText("doclet.Frame_Alert");
        h2End();
        p();
        printText("doclet.Frame_Warning_Message");
        br();
        printText("doclet.Link_To");
        printHyperLink(configuration.topFile, configuration.getText("doclet.Non_Frame_Version"));
        println("");
        noFramesEnd();
    }

    /**
     * Print the frame sizes and their contents.
     */
    protected void printFrameDetails() {
        // title attribute intentionally made empty so
        // 508 tests will not flag it as missing
        frameSet("cols=\"20%,80%\" title=\"\" onLoad=\"top.loadFrames()\"");
        printAllPackagesFrameTag();
        printClassFrameTag();
        printFrameWarning();
        frameSetEnd();
    }

    /**
     * Print the FRAME tag for the frame that lists all packages
     */
    private void printAllPackagesFrameTag() {
        frame("src=\"overview-frame.html\" name=\"packageListFrame\"" + " title=\"" + configuration.getText("doclet.All_Packages") + "\"");
    }

    /**
     * Print the FRAME tag for the frame that lists all classes
     */
    private void printAllClassesFrameTag() {
        frame("src=\"" + "allclasses-frame.html" + "\"" + " name=\"packageFrame\"" + " title=\"" + configuration.getText("doclet.All_classes_and_interfaces") + "\"");
    }

    /**
     * Print the FRAME tag for the frame that describes the class in detail
     */
    private void printClassFrameTag() {
        frame("src=\"" + configuration.topFile + "\"" + " name=\"classFrame\"" + " title=\"" + configuration.getText("doclet.Package_class_and_interface_descriptions") + "\" scrolling=\"yes\"");
    }
}
