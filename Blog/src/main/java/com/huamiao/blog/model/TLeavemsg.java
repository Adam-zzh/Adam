package com.huamiao.blog.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TLeavemsg implements Serializable {
    private Long id;

    @ApiModelProperty(value = "留言类型")
    private Long type;

    @ApiModelProperty(value = "发言人")
    private Long sourceId;

    @ApiModelProperty(value = "被评论人")
    private Long targetId;

    @ApiModelProperty(value = "父级id")
    private Long pid;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "联系方式")
    private String concat;

    @ApiModelProperty(value = "是否删除 0否 1是")
    private Byte isDel;

    @ApiModelProperty(value = "全限定路径")
    private String fullPath;

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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getConcat() {
        return concat;
    }

    public void setConcat(String concat) {
        this.concat = concat;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
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
        sb.append(", type=").append(type);
        sb.append(", sourceId=").append(sourceId);
        sb.append(", targetId=").append(targetId);
        sb.append(", pid=").append(pid);
        sb.append(", content=").append(content);
        sb.append(", concat=").append(concat);
        sb.append(", isDel=").append(isDel);
        sb.append(", fullPath=").append(fullPath);
        sb.append(", creId=").append(creId);
        sb.append(", creTime=").append(creTime);
        sb.append(", updId=").append(updId);
        sb.append(", updTime=").append(updTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}