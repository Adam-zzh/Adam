package com.huamiao.blog.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈发表文章查标签实体〉
 *
 * @author ZZH
 * @create 2021/5/27
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
public class CascadeVo {

    private String value;//类别code 也就是typeId

    private String label;//类别中文名称

    private List<CascadeVo> children;//对象属性复用
}