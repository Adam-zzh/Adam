package com.huamiao.blog.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ExcelExportOrderProduct implements Serializable {
    @ApiModelProperty(value = "商品id")
    private Integer id;

    @ApiModelProperty(value = "商品编号")
    private String productSn;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "单价(商品原价)")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "商品数量")
    private Integer productQuatity;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "最后更改时间")
    private Date modifiedTime;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuatity() {
        return productQuatity;
    }

    public void setProductQuatity(Integer productQuatity) {
        this.productQuatity = productQuatity;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productSn=").append(productSn);
        sb.append(", productName=").append(productName);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", productQuatity=").append(productQuatity);
        sb.append(", addTime=").append(addTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", orderId=").append(orderId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}