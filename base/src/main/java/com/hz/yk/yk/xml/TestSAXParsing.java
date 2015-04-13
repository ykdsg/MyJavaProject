package com.hz.yk.yk.xml;

import java.io.File;
import java.net.URL;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.springframework.util.Assert;

/**
 * @author wuzheng.yk
 *         Date: 13-3-18
 *         Time: 上午9:22
 */
public class TestSAXParsing {

    public static void main(String[] args) {
        String filename = "beans.xml";
        URL url = JAXPDemo.class.getClassLoader().getResource(filename);
        Assert.notNull(url);
        try {
            // Get SAX Parser Factory
            SAXParserFactory factory = SAXParserFactory.newInstance();
            // 设置名称空间意识
            factory.setValidating(true);
            //是否打开打开 DTD 验证
            factory.setNamespaceAware(false);
            SAXParser parser = factory.newSAXParser();

            parser.parse(new File(url.getPath()), new MyHandler());
        } catch (ParserConfigurationException e) {
            System.out.println("The underlying parser does not support " +
                    " the requested features.");
        } catch (FactoryConfigurationError e) {
            System.out.println("Error occurred obtaining SAX Parser Factory.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
