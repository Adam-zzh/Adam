package com.huamiao.admin.controller;

import com.huamiao.admin.model.TUser;
import com.huamiao.admin.service.UserService;
import com.huamiao.admin.vo.userVo.RegisterVo;
import com.huamiao.admin.vo.userVo.UpdPwdVo;
import com.huamiao.admin.vo.userVo.UpdUserVo;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户接口〉
 *
 * @author ZZH
 * @create 2021/4/25
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
@Api("用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("注册")
    @PostMapping("/register")
    public ResponseVo register(@Validated @RequestBody RegisterVo registVo){
        return userService.register(registVo);
    }

    @ApiOperation("根据账号更新用户信息")
    @PostMapping("/user")
    public ResponseVo updOrSaveUserInfo(@Validated @RequestBody UpdUserVo updUserVo){
        return userService.updOrSave(updUserVo);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("user/{userId}")
    public ResponseVo delUser(@PathVariable("userId") Long userId){
        return userService.delete(userId);
    }

    @ApiOperation("用户退出系统")
    @PostMapping("logout")
    public ResponseVo logout(){
        return userService.logout();
    }

    @ApiOperation("根据账号更新用户密码")
    @PutMapping("updPwd")
    public ResponseVo updPwd(@RequestBody UpdPwdVo updPwdVo){
        return userService.updPwd(updPwdVo);
    }

    @ApiOperation("重置密码")
    @PutMapping("resetPwd/{account}")
    public ResponseVo resetPwd(@PathVariable("account") String account){
        return userService.resetPwd(account);
    }

    @ApiOperation("查询用户列表")
    @PostMapping("users")
    public PageVo<TUser> getAllUser(@RequestBody BaseParam baseParam){
        return userService.queryList(baseParam);
    }

    @ApiOperation("按照用户名获取用户")
    @GetMapping("findByUserName")
    public ResponseVo<TUser> findByUserName(String userName){
        return userService.findByUserName(userName);
    }

}