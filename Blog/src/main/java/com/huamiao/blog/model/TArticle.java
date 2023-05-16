package com.huamiao.blog.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class TArticle implements Serializable {
    private Long id;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章浏览数")
    private Integer viewNum;

    @ApiModelProperty(value = "文章点赞数")
    private Integer likeNum;

    @ApiModelProperty(value = "是否置顶 0不是 >0是")
    private Integer ifTop;

    private Long creId;

    private Date creTime;

    private Long updId;

    private Date updTime;

    @ApiModelProperty(value = "文章内容")
    private String content;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getViewNum() {
        return viewNum;
    }

    public void setViewNum(Integer viewNum) {
        this.viewNum = viewNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getIfTop() {
        return ifTop;
    }

    public void setIfTop(Integer ifTop) {
        this.ifTop = ifTop;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", viewNum=").append(viewNum);
        sb.append(", likeNum=").append(likeNum);
        sb.append(", ifTop=").append(ifTop);
        sb.append(", creId=").append(creId);
        sb.append(", creTime=").append(creTime);
        sb.append(", updId=").append(updId);
        sb.append(", updTime=").append(updTime);
        sb.append(", content=").append(content);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}