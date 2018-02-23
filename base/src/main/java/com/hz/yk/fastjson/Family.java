package com.hz.yk.fastjson;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wuzheng.yk on 2018/2/23.
 */
public class Family {

    private String fName;
    private Date createTime;

    private Map      fMap;
    private List     fList;
    private String[] fArray;

    public Map getfMap() {
        return fMap;
    }

    public void setfMap(Map fMap) {
        this.fMap = fMap;
    }

    public List getfList() {
        return fList;
    }

    public void setfList(List fList) {
        this.fList = fList;
    }

    public String[] getfArray() {
        return fArray;
    }

    public void setfArray(String[] fArray) {
        this.fArray = fArray;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
