package com.huamiao.admin.controller;

import com.huamiao.admin.model.TRole;
import com.huamiao.admin.service.RoleService;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈角色管理〉
 *
 * @author ZZH
 * @create 2021/5/20
 * @since 1.0.0
 */
@RestController
@RequestMapping("roleController")
@Api(value = "角色管理")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "角色信息回显")
    @GetMapping("role/{roleId}")
    public ResponseVo selRole(@PathVariable("roleId") Long roleId){
        return roleService.detail(roleId);
    }

    @ApiOperation(value = "更新保存角色")
    @PutMapping("role")
    public ResponseVo updOrSaveRole(@RequestBody TRole role){
        return roleService.updOrSave(role);
    }

    @ApiOperation(value = "变更角色状态")
    @PutMapping("disable/{roleId}/{sta}")
    public ResponseVo changeStatus(@PathVariable("roleId") Long roleId, @PathVariable Byte sta){
        return roleService.changeStatus(roleId, sta);
    }

    @ApiOperation(value = "角色列表")
    @PostMapping("roles")
    public PageVo<TRole> selAllRoles(@RequestBody BaseParam baseParam){
        return roleService.queryList(baseParam);
    }

}