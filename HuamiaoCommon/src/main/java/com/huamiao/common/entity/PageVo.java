package com.huamiao.common.entity;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈分页封装api〉
 *
 * @author ZZH
 * @create 2021/4/22
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo<T> {

    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页大小
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总条数
     */
    private Integer total;

    /**
     * 分页数据
     */
    private List<T> list;

    public static <T> PageVo<T> newInstance(Integer pageNum, Integer pageSize, Integer totalPage, Integer total, List<T> list) {
        PageVo commonPage = new PageVo();
        commonPage.pageNum = pageNum;
        commonPage.pageSize = pageSize;
        commonPage.totalPage = totalPage;
        commonPage.total = total;
        commonPage.list = list;

        return commonPage;
    }

    public static <T> PageVo<T> newInstance(PageInfo<T> page) {
        return PageVo.newInstance(
                page.getPageNum(),
                page.getPageSize(),
                page.getPages(),
                (int) page.getTotal(),
                page.getList()
        );
    }
}