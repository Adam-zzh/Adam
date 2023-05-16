package com.huamiao.blog.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈博客首页右侧实体类封装〉
 *
 * @author ZZH
 * @create 2021/5/29
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
public class RightPanelVo {

    private List<String> labels;

    private List<String> types;

}