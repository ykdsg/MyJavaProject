package com.yt.icp.biz.domain.entity;

import java.util.Date;

/**
 * .
 *
 * @author wuzheng.yk
 * @since 16/6/21
 */
public class Brand extends BrandBase {

    private static final long serialVersionUID = -4105743012475787541L;

    private Date createTime;

    private Date editTime;

    private String creator;

    private String editor;

    private Integer isDeleted;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}
