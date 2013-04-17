package com.hz.yk.excel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author wuzheng.yk
 *         Date: 13-4-12
 *         Time: 下午4:52
 */
public class Excel2007Reader extends DefaultHandler {
    //共享字符串表
    private SharedStringsTable sst;
    //上一次的内容
    private String lastContents;
    private boolean nextIsString;

    private int sheetIndex = -1;
    private List<String> rowlist = new ArrayList<String>();
    //当前行
    private int curRow = 0;
    //当前列
    private int curCol = 0;

    private boolean isTElement;

    private IRowReader rowReader;

    public void setRowReader(IRowReader rowReader){
        this.rowReader = rowReader;
    }


    /**
     * 遍历工作簿中所有的电子表格
     * @param filename
     * @throws Exception
     */
    public void process(String filename) throws Exception {
        OPCPackage pkg = OPCPackage.open(filename);
        XSSFReader xssfReader = new XSSFReader(pkg);
        SharedStringsTable sst = xssfReader.getSharedStringsTable();
        XMLReader parser = fetchSheetParser(sst);
        Iterator<InputStream> sheets = xssfReader.getSheetsData();
        while (sheets.hasNext()) {
            curRow = 0;
            sheetIndex++;
            InputStream sheet = sheets.next();
            InputSource sheetSource = new InputSource(sheet);
            parser.parse(sheetSource);
            sheet.close();
        }
    }

    public XMLReader fetchSheetParser(SharedStringsTable sst)
            throws SAXException {
        XMLReader parser = XMLReaderFactory
                .createXMLReader("org.apache.xerces.parsers.SAXParser");
        this.sst = sst;
        parser.setContentHandler(this);
        return parser;
    }
    @Override
    public void startElement(String uri, String localName, String name,
                             Attributes attributes) throws SAXException {

        // c => 单元格
        if ("c".equals(name)) {
            // 如果下一个元素是 SST 的索引，则将nextIsString标记为true
            String cellType = attributes.getValue("t");
            nextIsString = "s".equals(cellType);
        }
        //当元素为t时
        isTElement = "t".equals(name);

        // 置空
        lastContents = "";
    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {

        // 根据SST的索引值的到单元格的真正要存储的字符串
        // 这时characters()方法可能会被调用多次
        if (nextIsString && lastContents.matches("\\d*")) {
            int idx = Integer.parseInt(lastContents);
            lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
        }
        //t元素也包含字符串
        if(isTElement){
            String value = lastContents.trim();
            rowlist.add(curCol, value);
            curCol++;
            isTElement = false;
            // v => 单元格的值，如果单元格是字符串则v标签的值为该字符串在SST中的索引
            // 将单元格内容加入rowlist中，在这之前先去掉字符串前后的空白符
        } else if ("v".equals(name)) {
            String value = lastContents.trim();
            rowlist.add(curCol, value);
            curCol++;
        }else {
            //如果标签名称为 row ，这说明已到行尾，调用 optRows() 方法
            if (name.equals("row")) {
                rowReader.getRows(sheetIndex,curRow,rowlist);
                rowlist.clear();
                curRow++;
                curCol = 0;
            }
        }

    }

   @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        //得到单元格内容的值
        lastContents += new String(ch, start, length);
    }
}
