package com.hz.yk.drools.demo3;

/**
 * @author wuzheng.yk
 * @date 2021/6/8
 */
public class ReservedLounge {

    @org.kie.api.definition.type.Label("产品编码")
    private java.lang.String proCode;
    @org.kie.api.definition.type.Label("产品名称")
    private java.lang.String proName;
    @org.kie.api.definition.type.Label("位置")
    private Location location;
    @org.kie.api.definition.type.Label("是否自营")
    private boolean selfSupport;

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean getSelfSupport() {
        return selfSupport;
    }

    public void setSelfSupport(boolean selfSupport) {
        this.selfSupport = selfSupport;
    }
}
