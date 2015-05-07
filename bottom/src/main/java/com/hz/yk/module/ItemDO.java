package com.hz.yk.module;

/**
 * @author wuzheng.yk
 *         Date: 15/5/7
 *         Time: 15:35
 */
public class ItemDO {
    private int salesSite;
    private long juId;
    private String title;

    public int getSalesSite() {
        return salesSite;
    }

    public void setSalesSite(int salesSite) {
        this.salesSite = salesSite;
    }

    public long getJuId() {
        return juId;
    }

    public void setJuId(long juId) {
        this.juId = juId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
