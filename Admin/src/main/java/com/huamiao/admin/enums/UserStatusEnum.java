package com.huamiao.admin.enums;

import lombok.Getter;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/5/24
 * @since 1.0.0
 */
@Getter
public enum  UserStatusEnum {

    NORMAL(0, "正常"),
    DISABLED(1, "禁用"),

    ;

    private int code;

    private String desc;

    UserStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}