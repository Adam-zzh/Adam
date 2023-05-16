package com.huamiao.admin.dto;

import com.huamiao.admin.model.TPermission;
import com.huamiao.admin.model.TRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈角色权限封装对象〉
 *
 * @author ZZH
 * @create 2021/4/29
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolePermission extends TRole implements Serializable {

    private static final long serialVersionUID = -7347456346915950507L;

    List<TPermission> permissionList;

}