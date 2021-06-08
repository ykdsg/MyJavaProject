package com.hz.yk.drools.demo3;

/**
 * @author wuzheng.yk
 * @date 2021/6/8
 */
public class Location {

    @org.kie.api.definition.type.Label(value = "国家")
    private java.lang.String country;
    @org.kie.api.definition.type.Label(value = "省份")
    private java.lang.String province;
    @org.kie.api.definition.type.Label(value = "城市")
    private java.lang.String city;

    public Location(String country, String province, String city) {
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
