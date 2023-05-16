package com.huamiao.admin.vo.userVo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 〈一句话功能简述〉<br>
 * 〈更新密码请求参数封装〉
 *
 * @author ZZH
 * @create 2021/5/20
 * @since 1.0.0
 */
@Data
public class UpdPwdVo {

    @NotEmpty(message = "账号不能为空")
    private String account;

    @NotEmpty(message = "请输入原始密码")
    private String oldPassword;

    @NotEmpty(message = "请输入新密码")
    private String newPassword;

}