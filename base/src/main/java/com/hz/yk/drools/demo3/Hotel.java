package com.hz.yk.drools.demo3;

import java.util.Date;

/**
 * @author wuzheng.yk
 * @date 2021/6/8
 */
public class Hotel {

    @org.kie.api.definition.type.Label("产品编码")
    private java.lang.String proCode;
    @org.kie.api.definition.type.Label("产品名称")
    private java.lang.String proName;
    @org.kie.api.definition.type.Label("房型")
    private java.lang.String roomType;
    @org.kie.api.definition.type.Label("入住日期")
    private java.util.Date checkInDate;
    @org.kie.api.definition.type.Label("位置")
    private Location location;
    @org.kie.api.definition.type.Label(value = "\u662F\u5426\u53EF\u6253\u5305\u9500\u552E")
    private java.lang.Boolean ifCanPackageSale;

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Boolean getIfCanPackageSale() {
        return ifCanPackageSale;
    }

    public void setIfCanPackageSale(Boolean ifCanPackageSale) {
        this.ifCanPackageSale = ifCanPackageSale;
    }
}
