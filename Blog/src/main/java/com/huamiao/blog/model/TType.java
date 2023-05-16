package com.huamiao.blog.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TType implements Serializable {
    private Long id;

    @ApiModelProperty(value = "文章类别展示名称")
    private String label;

    @ApiModelProperty(value = "排序字段")
    private Integer sequence;

    @ApiModelProperty(value = "类别图标路径")
    private String icon;

    private Long creId;

    private Date creTime;

    private Long updId;

    private Date updTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getCreId() {
        return creId;
    }

    public void setCreId(Long creId) {
        this.creId = creId;
    }

    public Date getCreTime() {
        return creTime;
    }

    public void setCreTime(Date creTime) {
        this.creTime = creTime;
    }

    public Long getUpdId() {
        return updId;
    }

    public void setUpdId(Long updId) {
        this.updId = updId;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", label=").append(label);
        sb.append(", sequence=").append(sequence);
        sb.append(", icon=").append(icon);
        sb.append(", creId=").append(creId);
        sb.append(", creTime=").append(creTime);
        sb.append(", updId=").append(updId);
        sb.append(", updTime=").append(updTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}