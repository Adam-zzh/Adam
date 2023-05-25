package com.huamiao.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import com.huamiao.admin.dto.RolePermission;
import com.huamiao.admin.dto.UserRole;
import com.huamiao.admin.enums.UserStatusEnum;
import com.huamiao.admin.mapper.TUserMapper;
import com.huamiao.admin.model.TPermission;
import com.huamiao.admin.model.TUser;
import com.huamiao.admin.model.TUserExample;
import com.huamiao.admin.service.UserService;
import com.huamiao.admin.util.IdHelper;
import com.huamiao.admin.util.ObjectHelper;
import com.huamiao.admin.vo.userVo.RegisterVo;
import com.huamiao.admin.vo.userVo.UpdPwdVo;
import com.huamiao.admin.vo.userVo.UpdUserVo;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.common.util.ConditionHelper;
import com.huamiao.common.util.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2021/4/29
 * @since 1.0.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private TUserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 用户注册接口
     *
     * @param registVo
     * @return
     */
    public ResponseVo<Boolean> register(RegisterVo registVo) {
        TUser tUser = new TUser();
        //copy 请求参数对象到dao层对象中
        HashMap<String, String> mapping = CollUtil.newHashMap();
        //设置别名
        mapping.put("icon", "userProfilePhoto");
        BeanUtil.copyProperties(registVo, tUser, CopyOptions.create().setFieldMapping(mapping));

        //校验用户是否注册
        TUserExample example = new TUserExample();
        example.createCriteria().andAccountEqualTo(tUser.getAccount().trim())
                .andStatusEqualTo(UserStatusEnum.DISABLED.getCode());
        ;
        List<TUser> tUsers = userMapper.selectByExample(example);

        if (!CollUtil.isEmpty(tUsers)) {
            return ResponseVo.failed("该账号已存在，注册失败");
        }

        tUser.setCreateTime(new Date());
        tUser.setPassword(tUser.getPassword());
        tUser.setId(IdHelper.generateLongId());

        int i = userMapper.insertSelective(tUser);

        if (i > 0) {
            return ResponseVo.success(null, "注册成功");
        }

        return ResponseVo.failed("注册失败");
    }

    public ResponseVo<Boolean> updOrSave(UpdUserVo updUserVo) {
        TUser user;
        if (updUserVo.getId() != null) {
            //编辑用户
            TUserExample userExample = new TUserExample();
            userExample.createCriteria().andIdEqualTo(updUserVo.getId()).andStatusEqualTo(UserStatusEnum.DISABLED.getCode());
            List<TUser> tUsers = userMapper.selectByExample(userExample);
            if (CollUtil.isEmpty(tUsers)) {
                return ResponseVo.failed("该用户不存在");
            }
            user = tUsers.get(0);

            HashMap<String, String> mapping = CollUtil.newHashMap();
            //设置别名
            mapping.put("icon", "userProfilePhoto");
            BeanUtil.copyProperties(updUserVo, user, CopyOptions.create().setFieldMapping(mapping));

            int i = userMapper.updateByExample(user, userExample);

            if (i > 0) {
                return ResponseVo.success(null,"更新成功");
            } else {
                return ResponseVo.failed("更新失败");
            }
        } else {
            //保存
            user = new TUser();
            HashMap<String, String> mapping = CollUtil.newHashMap();
            //设置别名
            mapping.put("icon", "userProfilePhoto");
            BeanUtil.copyProperties(updUserVo, user, CopyOptions.create().setFieldMapping(mapping));
            user.setCreateTime(new Date());

            int i = userMapper.insert(user);
            if (i < 1) {
                return ResponseVo.failed("保存失败");
            }
            return ResponseVo.success(null,"保存成功");
        }

    }

    public ResponseVo<Boolean> delete(Long userId) {
        TUserExample userExample = new TUserExample();
        userExample.createCriteria().andIdEqualTo(userId);

        List<TUser> tUsers = userMapper.selectByExample(userExample);
        if (CollUtil.isNotEmpty(tUsers)) {
            TUser tUser = tUsers.get(0);
            tUser.setStatus(UserStatusEnum.NORMAL.getCode());

            int i = userMapper.updateByPrimaryKey(tUser);

            if (i > 0) {
                // todo 清除掉内存中的用户
                log.info(tUser.getUserName() + "删掉了用户{}", tUser.getUserName());
                return ResponseVo.success(null, "删除成功");

            }
        }
        return ResponseVo.failed("删除失败");
    }

    public ResponseVo<Boolean> logout() {
        return ResponseVo.success(null, "你已退出");
    }

    public ResponseVo<Boolean> updPwd(UpdPwdVo updPwdVo) {
        TUserExample example = new TUserExample();
        example.createCriteria()
                .andStatusEqualTo(UserStatusEnum.NORMAL.getCode())
                .andAccountEqualTo(updPwdVo.getAccount());

        List<TUser> tUsers = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tUsers)) {
            return ResponseVo.failed("更新失败哦");
        }
        TUser tUser = tUsers.get(0);

        tUser.setPassword(updPwdVo.getNewPassword());
        int i = userMapper.updateByPrimaryKeySelective(tUser);
        if (i < 1) {
            return ResponseVo.failed("更新失败");
        }
        return ResponseVo.success(null, "更新成功");
    }

    public ResponseVo<Boolean> resetPwd(String account) {
        TUserExample example = new TUserExample();
        example.createCriteria()
                .andStatusEqualTo(UserStatusEnum.NORMAL.getCode())
                .andAccountEqualTo(account);
        List<TUser> tUsers = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tUsers)) {
            return ResponseVo.failed("更新失败哦");
        }
        TUser tUser = tUsers.get(0);
        tUser.setPassword(passwordEncoder.encode("123456"));
        userMapper.updateByPrimaryKeySelective(tUser);
        return ResponseVo.success(null, "重置成功");
    }


    public PageVo<TUser> queryList(BaseParam baseParam) {
        TUserExample userExample = new TUserExample();
        TUserExample.Criteria criteria = userExample.createCriteria();

        ConditionHelper.createCondition(baseParam, criteria, TUser.class);

        return PageHelper.pagination(baseParam, () -> userMapper.selectByExample(userExample));
    }

    /**
     * 根据用户获得所有权限
     * @param userId
     * @return
     */
    public Set<String> getPermissionsByUserId(Long userId) {
        Set<String> permissionValue = new HashSet<>();
        UserRole userRole = userMapper.queryByUserId(userId);
        List<RolePermission> roles = userRole.getRoles();
        roles.stream().forEach(item -> {
            List<TPermission> permissionList = item.getPermissionList();
            permissionValue.addAll(permissionList.stream().map(item1 -> item1.getValue()).collect(Collectors.toList()));
        });
        return permissionValue;
    }

    @Override
    public ResponseVo<TUser> findByUserName(String userName) {
        TUserExample userExample = new TUserExample();
        userExample.createCriteria()
                .andUserNameEqualTo(userName)
                .andStatusEqualTo(UserStatusEnum.NORMAL.getCode());
        TUser user = ObjectHelper.findFirst(userMapper.selectByExample(userExample));
        return ResponseVo.success(user);
    }
}