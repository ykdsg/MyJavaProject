package com.hz.yk.design.ch68;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * 访问者模式
 *
 * @author wuzheng.yk
 * @date 2021/8/17
 */

abstract class ResourceFile1 {

    protected String filePath;

    public ResourceFile1(String filePath) {
        this.filePath = filePath;
    }

    abstract public void accept(Extractor1 extractor);
}

class PdfFile1 extends ResourceFile1 {

    public PdfFile1(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor1 extractor) {
        extractor.extract2txt(this);
    }
}

class PPTFile1 extends ResourceFile1 {

    public PPTFile1(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor1 extractor) {
        extractor.extract2txt(this);
    }
}

class WordFile1 extends ResourceFile1 {

    public WordFile1(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Extractor1 extractor) {
        extractor.extract2txt(this);
    }
}

class Extractor1 {

    public void extract2txt(PdfFile1 pdfFile) {
        System.out.println("extract pdf");
    }

    public void extract2txt(PPTFile1 pptFile) {
        System.out.println("extract ppt");
    }

    public void extract2txt(WordFile1 wordFile) {
        System.out.println("extract word");
    }
}

public class ToolApplication1 {

    public static void main(String[] args) {
        Extractor1 extractor = new Extractor1();
        List<ResourceFile1> resourceFileList = Lists.newArrayList();
        for (ResourceFile1 resourceFile : resourceFileList) {
            //这里编译不过，因为重载是静态绑定
            //extractor.extract2txt(resourceFile);
            // 这里用多态解决了上面的静态绑定的问题，但是使用多态会污染原来的模型
            resourceFile.accept(extractor);
        }
    }
}
