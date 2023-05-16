package com.huamiao.common.util;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.function.Selector;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈分页实现〉
 *
 * @author ZZH
 * @create 2021/5/19
 * @since 1.0.0
 */
public class PageHelper {

    public static <T> PageVo<T> pagination(BaseParam baseParam, Selector<T> selector){
        if (StrUtil.isNotEmpty(baseParam.getOrderBy())) {
            com.github.pagehelper.PageHelper.startPage(baseParam.getPage(), baseParam.getPageSize(), baseParam.getOrderBy());
        }else {
            com.github.pagehelper.PageHelper.startPage(baseParam.getPage(), baseParam.getPageSize());
        }

        List<T> select = selector.select();
        PageInfo<T> page = new PageInfo<T>(select);
        return PageVo.newInstance(page);
    }

}