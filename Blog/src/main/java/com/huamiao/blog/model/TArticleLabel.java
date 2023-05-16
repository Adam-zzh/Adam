package com.huamiao.blog.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class TArticleLabel implements Serializable {
    private Long id;

    @ApiModelProperty(value = "文章id")
    private Long articleId;

    @ApiModelProperty(value = "标签id")
    private Long labelId;

    @ApiModelProperty(value = "是否手填 0否 1是")
    private Byte ifHand;

    @ApiModelProperty(value = "手填对应的值")
    private String value;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }

    public Byte getIfHand() {
        return ifHand;
    }

    public void setIfHand(Byte ifHand) {
        this.ifHand = ifHand;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", articleId=").append(articleId);
        sb.append(", labelId=").append(labelId);
        sb.append(", ifHand=").append(ifHand);
        sb.append(", value=").append(value);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}