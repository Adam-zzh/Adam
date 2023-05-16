package com.huamiao.admin.vo.userVo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2021/5/1
 * @since 1.0.0
 */
@Data
public class UpdUserVo {
    private Long id;

    @NotEmpty(message="账号不能为空")
    @ApiModelProperty("用户账号")
    private String account;

    @ApiModelProperty("用户昵称")
    private String userName;

    @ApiModelProperty(value = "用户类型0：普通用户   1：系统管理员")
    private Byte userType;

    @Email
    @ApiModelProperty(value = "用户邮箱")
    private String userEmail;

    @ApiModelProperty(value = "用户头像")
    private String icon;

    @Pattern(regexp="^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$", message = "请输入正确手机号")
    @ApiModelProperty(value = "用户手机号")
    private String userPhone;

    @ApiModelProperty(value = "描述")
    private String rmk;
}