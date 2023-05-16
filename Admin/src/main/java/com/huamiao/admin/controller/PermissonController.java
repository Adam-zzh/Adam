package com.huamiao.admin.controller;

import com.huamiao.admin.model.TPermission;
import com.huamiao.admin.service.PermissonService;
import com.huamiao.admin.vo.permissonVo.PermissonVo;
import com.huamiao.common.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈权限管理〉
 *
 * @author ZZH
 * @create 2021/5/21
 * @since 1.0.0
 */
@RestController
@RequestMapping("permissonController")
@Api("权限管理")
public class PermissonController {

    @Autowired
    private PermissonService permissonService;

    @ApiOperation("更新或保存权限")
    @PostMapping("updOrSavePermisson")
    public ResponseVo updOrSavePermisson(@RequestBody TPermission permission){
        return permissonService.updOrSavePermisson(permission);
    }

    @ApiOperation("查询所有资源返回树状结构")
    @PostMapping("permissons")
    public ResponseVo<List<TPermission>> selAllPermission(){
        return permissonService.selAllPermission();
    }

    @ApiOperation("角色授权展示页面")
    @PostMapping("permissons/roleId")
    public ResponseVo<List<PermissonVo>> selAllPermissionByRole(@PathVariable("roleId") Long roleId){
        return permissonService.selAllPermissionByRole(roleId);
    }

    @ApiOperation("角色授权展示页面")
    @GetMapping("permisson/{id}")
    public ResponseVo detailPermission(@PathVariable("id") Long id){
        return permissonService.detailPermission(id);
    }
}