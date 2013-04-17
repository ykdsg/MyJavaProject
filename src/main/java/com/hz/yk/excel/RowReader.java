package com.hz.yk.excel;

import java.util.List;

/**
 * @author wuzheng.yk
 *         Date: 13-4-12
 *         Time: 下午4:56
 */
public class RowReader implements IRowReader {


    /* 业务逻辑实现方法
     * @see com.eprosun.util.excel.IRowReader#getRows(int, int, java.util.List)
     */
    public void getRows(int sheetIndex, int curRow, List<String> rowlist) {
        System.out.print(curRow + " ");
        for (int i = 0; i < rowlist.size(); i++) {
            System.out.print(rowlist.get(i) + " ");
        }
        System.out.println();
    }

}
