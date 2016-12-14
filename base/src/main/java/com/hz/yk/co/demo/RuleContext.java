package com.hz.yk.co.demo;

import java.util.Calendar;
import java.util.List;

/**
 * Created by wuzheng.yk on 16/12/13.
 */
public class RuleContext {

    /**
     * 性别
     */
    private String gender;

    /**
     * 会员类型
     */
    private String memberType;

    /**
     * 下单时间
     */
    private Calendar createDate;

    /**
     * 购买的商品
     */
    private List<String> itemList;



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public List<String> getItemList() {
        return itemList;
    }

    public void setItemList(List<String> itemList) {
        this.itemList = itemList;
    }
}
