package com.huamiao.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈通用请求参数封装〉
 *
 * @author ZZH
 * @create 2021/5/19
 * @since 1.0.0
 */
@Data
public class BaseParam {

    private List<Condition> conditions;

    private Integer page;

    private Integer pageSize;

    @ApiModelProperty("排序字段 列如：CREATE_TIME DESC")
    private String orderBy;

}