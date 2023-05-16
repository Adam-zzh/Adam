package com.huamiao.admin.vo.userVo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 〈一句话功能简述〉<br>
 * 〈登陆请求参数 用户请求封装数据对象〉
 *
 * @author ZZH
 * @create 2021/4/29
 * @since 1.0.0
 */
@Data
public class UserVo {

    @NotEmpty(message = "账号不能为空")
    private String account;//账号

    @NotEmpty(message = "密码不能为空")
    private String password;//密码
}