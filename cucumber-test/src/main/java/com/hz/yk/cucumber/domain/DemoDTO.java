package com.hz.yk.cucumber.domain;

/**
 * @author wuzheng.yk
 * @date 2019-06-19
 */
public class DemoDTO {

    private String itemName;
    private Long   itemId;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
