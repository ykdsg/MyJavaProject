package com.hz.yk.yk.mina;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yangke
 *         Date: 12-8-30
 *         Time: ����5:18
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String Content;
    private Date date;


    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}