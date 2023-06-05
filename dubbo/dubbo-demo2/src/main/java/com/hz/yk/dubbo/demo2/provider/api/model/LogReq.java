package com.hz.yk.dubbo.demo2.provider.api.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wuzheng.yk
 * @date 2018/11/8
 */
public class LogReq implements Serializable {

    private static final long serialVersionUID = -4168737518432443101L;

    public LogReq(Long id, Integer status, String domain, String content) {
        this.id = id;
        this.status = status;
        this.domain = domain;
        this.content = content;
    }

    /**
     * id
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 业务域
     */
    private String domain;

    /**
     * 内容
     */
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
