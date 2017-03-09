package com.hz.yk.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wuzheng.yk on 17/2/21.
 */
public class Main {
    public static void main(String[] args) throws DocumentException, IOException, ParseException {
        URL url = new URL("http://maven.hipac.cn/nexus/service/local/repositories/snapshots/content/com/yangt/icp/yticp-api/1.5.7-SNAPSHOT/");
        Document document = new SAXReader().read(url);
        Element root = document.getRootElement();

        List<Element> contentItemList = root.element("data").elements();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date lastUpdateDate = null;
        String resourceURI="";

        for (Element childElement : contentItemList) {
            String text = childElement.elementText("text");
            if (!text.endsWith("jar")) {
                continue;
            }
            String dateStr = childElement.elementText("lastModified");
            Date lastModified = format.parse(dateStr);
            if (lastUpdateDate == null || lastUpdateDate.before(lastModified)) {
                lastUpdateDate = lastModified;
                resourceURI = childElement.elementText("resourceURI");
            }

        }

        System.out.println("lastUpdateDate=" + lastUpdateDate + ",resourceURI=" + resourceURI);



        //HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //InputStream is = con.getInputStream();
        //InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        //String result = "";
        //int read;
        //while ((read = isr.read()) != -1) {
        //    result += (char) read;
        //}
        //isr.close();
        //System.out.println(result);
    }
}
