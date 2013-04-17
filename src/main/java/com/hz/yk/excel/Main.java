package com.hz.yk.excel;

/**
 * @author wuzheng.yk
 *         Date: 13-4-12
 *         Time: 下午4:56
 */
public class Main {

    public static void main(String[] args) throws Exception {
        IRowReader reader = new RowReader();
        Excel2007Reader excel07 = new Excel2007Reader();
        excel07.setRowReader(reader);
        excel07.process("D://中文test_8m.xlsx");
    }
}
