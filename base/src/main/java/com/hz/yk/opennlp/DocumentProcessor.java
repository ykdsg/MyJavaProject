package com.hz.yk.opennlp;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author wuzheng.yk
 * @date 2023/5/22
 */
public class DocumentProcessor {
    public static void main(String[] args) throws IOException {
        //String filePath = "opennlp/sample-婴幼儿预防过敏.docx";
        String filePath = "opennlp/春季过敏之鼻炎.docx";
        //String filePath = "opennlp/婴幼儿腹泻.docx";
        

        extracted(filePath);
    }

    private static void extracted(String filePath) throws IOException {
        ClassLoader classLoader = DocumentProcessor.class.getClassLoader();
        // 读取文档
        final InputStream resourceAsStream = classLoader.getResourceAsStream(filePath);
        XWPFDocument document = new XWPFDocument(resourceAsStream);
        final List<XWPFParagraph> paragraphs = document.getParagraphs();
        List<String> result = Lists.newArrayList();
        StringBuilder sb = new StringBuilder();
        for (XWPFParagraph paragraph : paragraphs) {
            final String text = paragraph.getText();
            if (StringUtils.isBlank(text)) {
                continue;
            }
            //首先需要判断片断是否超过500个字符，如果超过500个字符，就需要分割
            if (sb.length()+text.length() > 500) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }else {
                sb.append(text);
            }
        }
        //针对一些字数特别少的片段，需要特殊处理
        result.add(sb.toString());
        result.forEach(x -> System.out.println(x+"\n"));

        //XWPFWordExtractor extractor = new XWPFWordExtractor(document);
        //String text = extractor.getText();
        //// 将文本分成句子
            //String[] sentences = text.split("[.?!。？！]");
    }

}
