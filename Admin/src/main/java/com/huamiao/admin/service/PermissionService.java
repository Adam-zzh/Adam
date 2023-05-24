package com.huamiao.admin.service;

import com.huamiao.admin.model.TPermission;
import com.huamiao.admin.vo.permissonVo.PermissionVo;
import com.huamiao.common.entity.ResponseVo;

import java.util.List;

public interface PermissionService {

    ResponseVo<Boolean> updOrSave(TPermission permission);

    ResponseVo<List<TPermission>> queryList();

    ResponseVo<List<PermissionVo>> queryListByRoleId(Long roleId);

    ResponseVo<TPermission> detail(Long id);

}
