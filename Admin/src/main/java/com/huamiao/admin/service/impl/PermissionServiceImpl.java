package com.huamiao.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.huamiao.admin.mapper.TPermissionMapper;
import com.huamiao.admin.mapper.TRolePermissionMapper;
import com.huamiao.admin.model.TPermission;
import com.huamiao.admin.model.TPermissionExample;
import com.huamiao.admin.model.TRolePermission;
import com.huamiao.admin.model.TRolePermissionExample;
import com.huamiao.admin.service.PermissionService;
import com.huamiao.admin.vo.permissonVo.PermissionVo;
import com.huamiao.common.constant.HuamiaoConst;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.common.util.TreeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈权限管理〉
 *
 * @author ZZH
 * @create 2021/5/21
 * @since 1.0.0
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private TPermissionMapper permissonMapper;
    @Autowired
    private TRolePermissionMapper rolePermissionMapper;

    @Override
    public ResponseVo<Boolean> updOrSave(TPermission permission) {
        StringBuffer sb = new StringBuffer();
        TPermissionExample permissionExample = new TPermissionExample();

        if (!"0".equals(permission.getPid())){
            permissionExample.createCriteria()
                    .andStatusEqualTo(HuamiaoConst.ZERO)
                    .andIdEqualTo(permission.getPid());
            List<TPermission> tPermissions = permissonMapper.selectByExample(permissionExample);
            sb.append(tPermissions.get(0).getFullpath());
        }

        sb.append("/").append(permission.getId());
        if (permission.getId() == null) {
            permission.setCreateTime(new Date());
            permission.setFullpath(sb.toString());
            permissonMapper.insertSelective(permission);
            return ResponseVo.success(null);
        }else {
            TPermissionExample example = new TPermissionExample();
            example.createCriteria()
                    .andStatusEqualTo(HuamiaoConst.ZERO)
                    .andIdEqualTo(permission.getId());

            TPermission tPermission = permissonMapper.selectByExample(permissionExample).get(0);
            BeanUtil.copyProperties(permission, tPermission);
            tPermission.setFullpath(sb.toString());
            tPermission.setCreateTime(new Date());
            permissonMapper.updateByPrimaryKeySelective(tPermission);
            return ResponseVo.success(null);
        }

    }

    @Override
    public ResponseVo<List<TPermission>> queryList() {
        TPermissionExample example = new TPermissionExample();
        example.setOrderByClause("SORT");
        example.createCriteria().andStatusEqualTo(HuamiaoConst.ZERO);

        List<TPermission> tPermissions = permissonMapper.selectByExample(example);
        List<TPermission> tree = TreeHelper.createTree(tPermissions);
        return ResponseVo.success(tree);
    }

    @Override
    public ResponseVo<List<PermissionVo>> queryListByRoleId(Long roleId) {
        TRolePermissionExample example = new TRolePermissionExample();
        example.createCriteria()
                .andRoleIdEqualTo(roleId);
        List<Long> permissionIds = rolePermissionMapper.selectByExample(example)
                .stream()
                .map(TRolePermission::getPermissionId)
                .collect(Collectors.toList());
        List<PermissionVo> permissonVos = (List<PermissionVo>) this.queryList();
        List<PermissionVo> collect = permissonVos.stream().map(item -> {
            if (permissionIds.contains(item.getId())) {
                item.setIfHasResource((byte) 1);
            } else {
                item.setIfHasResource((byte) 0);
            }
            return item;
        }).collect(Collectors.toList());
        return ResponseVo.success(collect);
    }

    @Override
    public ResponseVo<TPermission> detail(Long id) {
        TPermission tPermission = permissonMapper.selectByPrimaryKey(id);
        return ResponseVo.success(tPermission);
    }
}