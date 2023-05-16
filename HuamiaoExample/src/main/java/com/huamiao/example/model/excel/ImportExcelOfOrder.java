package com.huamiao.example.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.huamiao.example.strategy.OrderStatusStrategy;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ImportExcelOfOrder implements Serializable {

    @ApiModelProperty(value = "订单编号")
    @ExcelProperty("订单编号")
    @NotEmpty
    private String orderSn;

    @ApiModelProperty(value = "收货人")
    @ExcelProperty("收货人")
    private String userName;

    @ApiModelProperty(value = "门店人")
    @ExcelProperty("门店人")
    private String storeName;

    @ApiModelProperty(value = "订单总金额")
    @ExcelProperty("订单总金额")
    private BigDecimal orderAmount;

    @ApiModelProperty(value = "详细收货地址")
    @ExcelProperty("详细收货地址")
    private String address;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "最后更改时间")
    @ExcelProperty("最后更改时间")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifiedTime;

    @ApiModelProperty(value = "订单状态 0销售 1退货")
    @ExcelProperty(value = "订单状态", converter = OrderStatusStrategy.class)
    private Integer status;

    private static final long serialVersionUID = 1L;

}