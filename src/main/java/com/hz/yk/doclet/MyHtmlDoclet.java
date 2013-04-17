package com.hz.yk.doclet;

import com.hz.yk.doclet.formats.MyFrameOutputWriter;
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.SourcePosition;
import com.sun.tools.doclets.formats.html.ClassUseWriter;
import com.sun.tools.doclets.formats.html.ConfigurationImpl;
import com.sun.tools.doclets.formats.html.DeprecatedListWriter;
import com.sun.tools.doclets.formats.html.HelpWriter;
import com.sun.tools.doclets.formats.html.PackageFrameWriter;
import com.sun.tools.doclets.formats.html.PackageIndexFrameWriter;
import com.sun.tools.doclets.formats.html.PackageIndexWriter;
import com.sun.tools.doclets.formats.html.PackageTreeWriter;
import com.sun.tools.doclets.formats.html.SingleIndexWriter;
import com.sun.tools.doclets.formats.html.SplitIndexWriter;
import com.sun.tools.doclets.formats.html.StylesheetWriter;
import com.sun.tools.doclets.formats.html.TreeWriter;
import com.sun.tools.doclets.internal.toolkit.Configuration;
import com.sun.tools.doclets.internal.toolkit.builders.AbstractBuilder;
import com.sun.tools.doclets.internal.toolkit.util.ClassTree;
import com.sun.tools.doclets.internal.toolkit.util.DocletAbortException;
import com.sun.tools.doclets.internal.toolkit.util.DocletConstants;
import com.sun.tools.doclets.internal.toolkit.util.IndexBuilder;
import com.sun.tools.doclets.internal.toolkit.util.SourceToHTMLConverter;
import com.sun.tools.doclets.internal.toolkit.util.Util;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author wuzheng.yk
 *         Date: 13-3-20
 *         Time: 下午2:18
 */
public class MyHtmlDoclet extends AbstractDoclet {
    /**
     * 记录符合javadoc的java package
     */
    private final static Set<PackageDoc> packageSet = new HashSet<PackageDoc>();

    public MyHtmlDoclet() {
        configuration = (ConfigurationImpl) configuration();
    }

    /**
     * The global configuration information for this run.
     */
    public ConfigurationImpl configuration;

    /**
     * The "start" method as required by Javadoc.
     *
     * @param root the root of the documentation tree.
     * @return true if the doclet ran without encountering any errors.
     * @see com.sun.javadoc.RootDoc
     */
    public static boolean start(RootDoc root) {
        MyHtmlDoclet doclet = new MyHtmlDoclet();
        return doclet.start(doclet, root);

    }

    /**
     * Create the configuration instance.
     * Override this method to use a different
     * configuration.
     */
    @Override
    public Configuration configuration() {
        return ConfigurationImpl.getInstance();
    }

    /**
     * Start the generation of files. Call generate methods in the individual
     * writers, which will in turn genrate the documentation files. Call the
     * TreeWriter generation first to ensure the Class Hierarchy is built
     * first and then can be used in the later generation.
     * <p/>
     * For new format.
     *
     * @see com.sun.javadoc.RootDoc
     */
    protected void generateOtherFiles(RootDoc root, ClassTree classtree) throws Exception {
        super.generateOtherFiles(root, classtree);
        if (configuration.linksource) {
            if (configuration.destDirName.length() > 0) {
                SourceToHTMLConverter.convertRoot(configuration, root, configuration.destDirName + File.separator +
                        DocletConstants.SOURCE_OUTPUT_DIR_NAME);
            } else {
                SourceToHTMLConverter.convertRoot(configuration, root, DocletConstants.SOURCE_OUTPUT_DIR_NAME);
            }
        }

        if (configuration.topFile.length() == 0) {
            configuration.standardmessage.
                    error("doclet.No_Non_Deprecated_Classes_To_Document");
            return;
        }
        boolean nodeprecated = configuration.nodeprecated;
        String configdestdir = configuration.destDirName;
        String confighelpfile = configuration.helpfile;
        String configstylefile = configuration.stylesheetfile;
        performCopy(configdestdir, confighelpfile);
        performCopy(configdestdir, configstylefile);
        Util.copyResourceFile(configuration, "inherit.gif", false);
        // do early to reduce memory footprint
        if (configuration.classuse) {
            ClassUseWriter.generate(configuration, classtree);
        }
        IndexBuilder indexbuilder = new IndexBuilder(configuration, nodeprecated);

        if (configuration.createtree) {
            TreeWriter.generate(configuration, classtree);
        }
        if (configuration.createindex) {
            if (configuration.splitindex) {
                SplitIndexWriter.generate(configuration, indexbuilder);
            } else {
                SingleIndexWriter.generate(configuration, indexbuilder);
            }
        }

        if (!(configuration.nodeprecatedlist || nodeprecated)) {
            DeprecatedListWriter.generate(configuration);
        }

//        AllClassesFrameWriter.generate(configuration, new IndexBuilder(configuration, nodeprecated, true));

        MyFrameOutputWriter.generate(configuration);

        if (configuration.createoverview) {
            PackageIndexWriter.generate(configuration);
        }
        if (configuration.helpfile.length() == 0 && !configuration.nohelp) {
            HelpWriter.generate(configuration);
        }
        if (configuration.stylesheetfile.length() == 0) {
            StylesheetWriter.generate(configuration);
        }
    }



    /**
     * {@inheritDoc}
     */
    @Override
    protected void generateClassFiles(ClassDoc[] arr, ClassTree classtree) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (!(MyAPIDocletUtil.isDocAPIClass(arr[i]) && arr[i].isIncluded())) {
                continue;
            }
            packageSet.add(arr[i].containingPackage());
            ClassDoc prev = (i == 0) ? null : arr[i - 1];
            ClassDoc curr = arr[i];
            ClassDoc next = (i + 1 == arr.length) ? null : arr[i + 1];
            try {
                if (curr.isAnnotationType()) {
                    AbstractBuilder annotationTypeBuilder = configuration.getBuilderFactory().
                            getAnnotationTypeBuilder((AnnotationTypeDoc) curr, prev, next);
                    annotationTypeBuilder.build();
                } else {
                    AbstractBuilder classBuilder = configuration.getBuilderFactory().getClassBuilder(curr, prev, next, classtree);
                    classBuilder.build();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new DocletAbortException();
            }
        }
        //这里直接替换下 configuration.packages 过滤掉不需要的package
        configuration.packages=packageSet.toArray(new PackageDoc[packageSet.size()]);
    }

    /**
     * {@inheritDoc}
     */
    protected void generatePackageFiles(ClassTree classtree) throws Exception {
        PackageDoc[] packages = configuration.packages;
        if (packages.length > 1) {
            PackageIndexFrameWriter.generate(configuration);
        }
        PackageDoc prev = null, next;
        for (int i = 0; i < packages.length; i++) {
            PackageFrameWriter.generate(configuration, packages[i]);
            next = (i + 1 < packages.length && packages[i + 1].name().length() > 0) ? packages[i + 1] : null;
            //If the next package is unnamed package, skip 2 ahead if possible
            next = (i + 2 < packages.length && next == null) ? packages[i + 2] : next;
            AbstractBuilder packageSummaryBuilder = configuration.
                    getBuilderFactory().getPackageSummaryBuilder(packages[i], prev, next);
            packageSummaryBuilder.build();
            if (configuration.createtree) {
                PackageTreeWriter.generate(configuration, packages[i], prev, next, configuration.nodeprecated);
            }
            prev = packages[i];
        }
    }

    /**
     * Check for doclet added options here.
     *
     * @return number of arguments to option. Zero return means
     *         option not known.  Negative value means error occurred.
     */
    public static int optionLength(String option) {
        // Construct temporary configuration for check
        return (ConfigurationImpl.getInstance()).optionLength(option);
    }

    /**
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
        // Construct temporary configuration for check
        return (ConfigurationImpl.getInstance()).validOptions(options, reporter);
    }

    private void performCopy(String configdestdir, String filename) {
        try {
            String destdir = (configdestdir.length() > 0) ? configdestdir + File.separatorChar : "";
            if (filename.length() > 0) {
                File helpstylefile = new File(filename);
                String parent = helpstylefile.getParent();
                String helpstylefilename = (parent == null) ? filename : filename.substring(parent.length() + 1);
                File desthelpfile = new File(destdir + helpstylefilename);
                if (!desthelpfile.getCanonicalPath().equals(helpstylefile.getCanonicalPath())) {
                    configuration.message.
                            notice((SourcePosition) null, "doclet.Copying_File_0_To_File_1", helpstylefile.toString(), desthelpfile.toString());
                    Util.copyFile(desthelpfile, helpstylefile);
                }
            }
        } catch (IOException exc) {
            configuration.message.
                    error((SourcePosition) null, "doclet.perform_copy_exception_encountered", exc.toString());
            throw new DocletAbortException();
        }
    }
}
