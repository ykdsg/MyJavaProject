/*
 * Copyright 1999-19 Nov 2015 Alibaba.com All right reserved. This software is the confidential and proprietary
 * information of Alibaba.com ("Confidential Information"). You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement you entered into with Alibaba.com.
 */
package com.yk.akka.springdemo.model;

/**
 * @author yangbolin 19 Nov 2015 11:41:58 am
 */
public class Item {

    private String content;

    private Item(Builder builder) {setContent(builder.content);}

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static final class Builder {

        private String content;

        private Builder() {}

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
