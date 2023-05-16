package com.huamiao.admin.dto;

import com.huamiao.admin.model.TUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈封装用户角色信息〉
 *
 * @author ZZH
 * @create 2021/4/25
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends TUser implements Serializable {

    private static final long serialVersionUID = 3859120925571287175L;

    private List<RolePermission> roles;
}