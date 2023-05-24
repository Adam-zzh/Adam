package com.huamiao.admin.service;

import com.huamiao.admin.model.TRole;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;

public interface RoleService {

    ResponseVo<TRole> detail(Long roleId);

    ResponseVo<Boolean> updOrSave(TRole role);

    ResponseVo<Boolean> changeStatus(Long roleId, Byte status);

    PageVo<TRole> queryList(BaseParam baseParam);
}
