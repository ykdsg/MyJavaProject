package com.hz.yk.drools.demo3;

import java.util.Date;

/**
 * @author wuzheng.yk
 * @date 2021/6/8
 */
public class Segment {

    @org.kie.api.definition.type.Label("产品编码")
    private java.lang.String proCode;
    @org.kie.api.definition.type.Label("产品名称")
    private java.lang.String proName;
    @org.kie.api.definition.type.Label("出发城市")
    private java.lang.String startCity;
    @org.kie.api.definition.type.Label("到达城市")
    private java.lang.String arriveCity;
    @org.kie.api.definition.type.Label("舱位")
    private java.lang.String cabin;
    @org.kie.api.definition.type.Label("航班日期")
    private java.util.Date flightDate;

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

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getArriveCity() {
        return arriveCity;
    }

    public void setArriveCity(String arriveCity) {
        this.arriveCity = arriveCity;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }
}
