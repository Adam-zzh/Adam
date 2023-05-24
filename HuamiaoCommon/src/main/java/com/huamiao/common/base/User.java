package com.huamiao.common.base;

import lombok.Data;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户信息封装〉
 *
 * @author ZZH
 * @create 2023/5/24
 * @since 1.0.0
 */
@Data
public class User {

    private Long userId;

    private String userName;

    private String token;

    private Long expireSecond;

    public User() {
    }

    public User(Long userId, String userName, String token, Long expireSecond) {
        this.userId = userId;
        this.userName = userName;
        this.token = token;
        this.expireSecond = expireSecond;
    }
}