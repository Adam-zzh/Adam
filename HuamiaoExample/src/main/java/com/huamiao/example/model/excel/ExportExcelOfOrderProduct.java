package com.huamiao.example.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.huamiao.example.annotation.CustomMerge;
import com.huamiao.example.strategy.OrderStatusStrategy;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈导出订单excel〉
 *
 */
@Data
public class ExportExcelOfOrderProduct {
    @ExcelProperty(value = "id", order = 1)
    @CustomMerge(needMerge = true, isPk = true)
    private Long id;

    @ExcelProperty(value = "订单编号", order = 2)
    @CustomMerge(needMerge = true)
    private String orderSn;

    @ExcelProperty(value = "收货人", order = 3)
    @CustomMerge(needMerge = true)
    private String userName;

    @ExcelProperty(value = "门店人", order = 4)
    @CustomMerge(needMerge = true)
    private String storeName;

    @ExcelProperty(value = "订单总金额", order = 5)
    @CustomMerge(needMerge = true)
    private BigDecimal orderAmount;

    @ExcelProperty(value = "详细收货地址", order = 6)
    @CustomMerge(needMerge = true)
    private String address;

    @ExcelProperty(value = "创建时间", order = 7)
    @CustomMerge(needMerge = true)
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private Date addTime;

    @ExcelProperty(value = "最后更改时间", order = 8)
    @CustomMerge(needMerge = true)
    @DateTimeFormat("yyyy年MM月dd日HH时mm分ss秒")
    private Date modifiedTime;

    @ExcelProperty(value = "订单状态", order = 9, converter = OrderStatusStrategy.class)
    @CustomMerge(needMerge = true)
    private Integer status;

    @ExcelProperty(value = {"商品信息", "商品编码"}, order = 10)
    private String productSn;

    @ExcelProperty(value = {"商品信息", "商品名称"}, order = 11)
    private String productName;

    @ExcelProperty(value = {"商品信息", "商品单价"}, order = 12)
    private BigDecimal productPrice;

    @ExcelProperty(value = {"商品信息", "商品数量"}, order = 13)
    private Integer productQuatity;

}