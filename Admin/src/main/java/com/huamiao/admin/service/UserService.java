package com.huamiao.admin.service;

import com.huamiao.admin.model.TUser;
import com.huamiao.admin.vo.userVo.RegisterVo;
import com.huamiao.admin.vo.userVo.UpdPwdVo;
import com.huamiao.admin.vo.userVo.UpdUserVo;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;

import java.util.Set;

public interface UserService {

    ResponseVo<Boolean> register(RegisterVo registVo);

    ResponseVo<Boolean> updOrSave(UpdUserVo updUserVo);

    ResponseVo<Boolean> delete(Long userId);

    ResponseVo<Boolean> logout();

    ResponseVo<Boolean> updPwd(UpdPwdVo updPwdVo);

    ResponseVo<Boolean> resetPwd(String account);

    PageVo<TUser> queryList(BaseParam baseParam);

    Set<String> getPermissionsByUserId(Long userId);

    ResponseVo<TUser> findByUserName(String userName);
}
