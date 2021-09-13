package com.hz.yk.design.ch68;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2021/8/17
 */

abstract class ResourceFile2 {

    protected String filePath;

    public ResourceFile2(String filePath) {
        this.filePath = filePath;
    }

    abstract public void accept(Vistor vistor);
}

class PdfFile2 extends ResourceFile2 {

    public PdfFile2(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }
}

class PPTFile2 extends ResourceFile2 {

    public PPTFile2(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }
}

class WordFile2 extends ResourceFile2 {

    public WordFile2(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Vistor vistor) {
        vistor.visit(this);
    }
}

interface Vistor {

    void visit(PdfFile2 pdfFile);

    void visit(PPTFile2 pptFile);

    void visit(WordFile2 wordFile);
}

/**
 * 代表读取并输出
 */
class Extractor2 implements Vistor {

    @Override
    public void visit(PdfFile2 pdfFile) {
        System.out.println("extract pdf");
    }

    @Override
    public void visit(PPTFile2 pptFile) {
        System.out.println("extract ppt");

    }

    @Override
    public void visit(WordFile2 wordFile) {
        System.out.println("extract word");

    }
}

/**
 * 代表压缩
 */
class Compressor implements Vistor {

    @Override
    public void visit(PdfFile2 pdfFile) {
        System.out.println("compress pdf");

    }

    @Override
    public void visit(PPTFile2 pptFile) {
        System.out.println("compress ppt");

    }

    @Override
    public void visit(WordFile2 wordFile) {
        System.out.println("compress word");

    }
}

public class ToolApplication2 {

    public static void main(String[] args) {
        Extractor2 extractor = new Extractor2();
        List<ResourceFile2> resourceFileList = Lists.newArrayList();
        //使用访问者模式进行解耦
        for (ResourceFile2 resourceFile : resourceFileList) {
            resourceFile.accept(extractor);
        }

        Compressor compressor = new Compressor();
        for (ResourceFile2 resourceFile : resourceFileList) {
            resourceFile.accept(compressor);
        }
    }
}
