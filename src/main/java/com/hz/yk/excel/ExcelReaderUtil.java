package com.hz.yk.excel;

/**
 * @author wuzheng.yk
 *         Date: 13-4-12
 *         Time: 下午5:04
 */
public class ExcelReaderUtil {

    /**
     * 读取Excel文件
     *
     * @param fileName
     * @throws Exception
     */
    public static void readExcel(IRowReader reader, String fileName) throws Exception {
        Excel2007Reader excel07 = new Excel2007Reader();
        excel07.setRowReader(reader);
        excel07.process(fileName);
    }

}
