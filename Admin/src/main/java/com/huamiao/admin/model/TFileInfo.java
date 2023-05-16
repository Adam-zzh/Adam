package com.huamiao.admin.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TFileInfo implements Serializable {
    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "唯一标识")
    private String identifier;

    @ApiModelProperty(value = "总共大小")
    private Long totalSize;

    @ApiModelProperty(value = "文件类型")
    private String type;

    @ApiModelProperty(value = "文件地址")
    private String location;

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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        sb.append(", fileName=").append(fileName);
        sb.append(", identifier=").append(identifier);
        sb.append(", totalSize=").append(totalSize);
        sb.append(", type=").append(type);
        sb.append(", location=").append(location);
        sb.append(", creId=").append(creId);
        sb.append(", creTime=").append(creTime);
        sb.append(", updId=").append(updId);
        sb.append(", updTime=").append(updTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}