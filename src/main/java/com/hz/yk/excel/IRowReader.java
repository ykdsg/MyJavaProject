package com.hz.yk.excel;

import java.util.List;

/**
 * @author wuzheng.yk
 *         Date: 13-4-12
 *         Time: 下午4:54
 */
public interface IRowReader {

    /**业务逻辑实现方法
     * @param sheetIndex
     * @param curRow
     * @param rowlist
     */
    public  void getRows(int sheetIndex,int curRow, List<String> rowlist);
}
