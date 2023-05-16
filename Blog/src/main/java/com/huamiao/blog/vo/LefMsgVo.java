package com.huamiao.blog.vo;

import com.huamiao.blog.model.TLeavemsg;
import lombok.Data;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈留言实体vo〉
 *
 * @author ZZH
 * @create 2021/6/13
 * @since 1.0.0
 */
@Data
public class LefMsgVo extends TLeavemsg {

    private String targetName;

    private String sourceName;

    private String typeName;

    private List<LefMsgVo> children;
}