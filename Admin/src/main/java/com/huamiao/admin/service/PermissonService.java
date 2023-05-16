package com.huamiao.admin.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.tree.TreeUtil;
import com.huamiao.admin.mapper.TPermissionMapper;
import com.huamiao.admin.mapper.TRolePermissionMapper;
import com.huamiao.admin.model.TPermission;
import com.huamiao.admin.model.TPermissionExample;
import com.huamiao.admin.model.TRolePermission;
import com.huamiao.admin.model.TRolePermissionExample;
import com.huamiao.admin.vo.permissonVo.PermissonVo;
import com.huamiao.common.constant.HuamiaoConst;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.common.util.TreeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class PermissonService {
    @Autowired
    private TPermissionMapper permissonMapper;
    @Autowired
    private TRolePermissionMapper rolePermissionMapper;

    public ResponseVo updOrSavePermisson(TPermission permission) {
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

    public ResponseVo<List<TPermission>> selAllPermission() {
        TPermissionExample example = new TPermissionExample();
        example.setOrderByClause("SORT");
        example.createCriteria().andStatusEqualTo(HuamiaoConst.ZERO);

        List<TPermission> tPermissions = permissonMapper.selectByExample(example);
        List<TPermission> tree = TreeHelper.createTree(tPermissions);
        return ResponseVo.success(tree);
    }

    public ResponseVo<List<PermissonVo>> selAllPermissionByRole(Long roleId) {
        TRolePermissionExample example = new TRolePermissionExample();
        example.createCriteria()
                .andRoleIdEqualTo(roleId);
        List<Long> permissionIds = rolePermissionMapper.selectByExample(example)
                .stream()
                .map(TRolePermission::getPermissionId)
                .collect(Collectors.toList());
        List<PermissonVo> permissonVos = (List<PermissonVo>) this.selAllPermission();
        List<PermissonVo> collect = permissonVos.stream().map(item -> {
            if (permissionIds.contains(item.getId())) {
                item.setIfHasResource((byte) 1);
            } else {
                item.setIfHasResource((byte) 0);
            }
            return item;
        }).collect(Collectors.toList());
        return ResponseVo.success(collect);
    }

    public ResponseVo detailPermission(Long id) {
        TPermission tPermission = permissonMapper.selectByPrimaryKey(id);
        return ResponseVo.success(tPermission);
    }
}