package com.hz.yk.reactor.price;

/**
 * @author wuzheng.yk
 * @date 2019-06-21
 */
public class PriceSourceMaterials {

    private String item;

    private String batch;

    /**
     * 耗时
     */
    private long costTime;

    /**
     * 当前序号标识
     */
    private int tag;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
