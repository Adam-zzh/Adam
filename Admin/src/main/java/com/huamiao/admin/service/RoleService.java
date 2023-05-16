package com.huamiao.admin.service;

import cn.hutool.core.bean.BeanUtil;
import com.huamiao.admin.mapper.TRoleMapper;
import com.huamiao.admin.model.TRole;
import com.huamiao.admin.model.TRoleExample;
import com.huamiao.common.constant.HuamiaoConst;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.common.util.ConditionHelper;
import com.huamiao.common.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈角色功能〉
 *
 * @author ZZH
 * @create 2021/5/20
 * @since 1.0.0
 */
@Service
@Transactional
public class RoleService {

    @Autowired
    private TRoleMapper roleMapper;

    public ResponseVo selRole(Long roleId) {
        TRole tRole = roleMapper.selectByPrimaryKey(roleId);
        return ResponseVo.success(tRole);
    }

    public ResponseVo updOrSaveRole(TRole role) {
        if (role.getId() == null) {
            role.setCreateTime(new Date());
            int i = roleMapper.insertSelective(role);
            if (i < 1) {
                return ResponseVo.failed();
            }
        }else {
            TRoleExample roleExample = new TRoleExample();
            roleExample.createCriteria()
                    .andStatusEqualTo(HuamiaoConst.ZERO)
                    .andIdEqualTo(role.getId());

            List<TRole> tRoles = roleMapper.selectByExample(roleExample);
            TRole tRole = tRoles.get(0);

            BeanUtil.copyProperties(role, tRole);

            roleMapper.updateByPrimaryKey(tRole);

        }
        return ResponseVo.success(null);
    }

    public ResponseVo disableRole(Long roleId, Byte sta) {
        TRoleExample roleExample = new TRoleExample();
        roleExample.createCriteria()
                .andStatusEqualTo(HuamiaoConst.ZERO)
                .andIdEqualTo(roleId);

        List<TRole> tRoles = roleMapper.selectByExample(roleExample);
        TRole tRole = tRoles.get(0);
        tRole.setStatus(sta);
        roleMapper.updateByPrimaryKey(tRole);
        return ResponseVo.success(null);
    }

    public PageVo<TRole> selAllRoles(BaseParam baseParam) {
        TRoleExample example = new TRoleExample();
        TRoleExample.Criteria criteria = example.createCriteria();

        ConditionHelper.createCondition(baseParam, criteria, TRole.class);

        return PageHelper.pagination(baseParam, () -> roleMapper.selectByExample(example));
    }
}