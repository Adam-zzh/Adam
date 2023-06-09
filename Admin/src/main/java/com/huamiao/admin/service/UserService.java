package com.huamiao.admin.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;
import com.huamiao.admin.dto.RolePermission;
import com.huamiao.admin.dto.UserRole;
import com.huamiao.admin.mapper.TUserMapper;
import com.huamiao.admin.model.TPermission;
import com.huamiao.admin.model.TUser;
import com.huamiao.admin.model.TUserExample;
import com.huamiao.admin.util.IdHelper;
import com.huamiao.admin.vo.userVo.RegistVo;
import com.huamiao.admin.vo.userVo.UpdPwdVo;
import com.huamiao.admin.vo.userVo.UpdUserVo;
import com.huamiao.admin.vo.userVo.UserVo;
import com.huamiao.common.constant.HuamiaoConst;
import com.huamiao.common.entity.BaseParam;
import com.huamiao.common.entity.PageVo;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.common.util.ConditionHelper;
import com.huamiao.common.util.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
@Slf4j
public class UserService {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ProductMessage productMessage;

    public ResponseVo login(UserVo userVo) {
        String account = userVo.getAccount();
        if (StrUtil.isEmpty(account)) {
            return ResponseVo.failed("账号不能为空");
        }
        log.info("account={}", userVo.getAccount());
        TUserExample userExample = new TUserExample();
        userExample.createCriteria().andAccountEqualTo(account.trim()).andStatusEqualTo(HuamiaoConst.ZERO);

        List<TUser> tUsers = userMapper.selectByExample(userExample);
        if (CollectionUtil.isNotEmpty(tUsers)) {
            TUser tUser = tUsers.get(0);
            List<SimpleGrantedAuthority> authors = getPermissionValues(tUser.getId()).stream().map(item -> new SimpleGrantedAuthority(item)).collect(Collectors.toList());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(account, null, authors);
            if (passwordEncoder.matches(userVo.getPassword(), tUser.getPassword())) {
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                //生成token
                String token = jwtTokenUtil.generateToken(tUser.getUserName(), tUser.getAccount());

                //更新user最新登陆时间
                tUser.setLoginTime(new Date());
                userMapper.updateByPrimaryKeySelective(tUser);

                String keyOfUser = RedisUtil.getKeyOfUser(tUser.getUserName(), tUser.getAccount());
                RedisUtil.setUserInfo(keyOfUser, tUser);

                UpdUserVo user = new UpdUserVo();
                BeanUtils.copyProperties(tUser, user);
                Map<String, Object> map = new HashMap<>();
                map.put("tokenHead", tokenHead);
                map.put("token", token);
                map.put("data", user);
                return ResponseVo.success(map, "登陆成功");
            }
        } else {
            return ResponseVo.failed("账号密码错误");
        }

        return ResponseVo.failed("账号密码错误");
    }


    /**
     * 用户注册接口
     *
     * @param registVo
     * @return
     */
    public ResponseVo register(RegistVo registVo) {
        TUser tUser = new TUser();
        //copy 请求参数对象到dao层对象中
        HashMap<String, String> mapping = CollUtil.newHashMap();
        //设置别名
        mapping.put("icon", "userProfilePhoto");
        BeanUtil.copyProperties(registVo, tUser, CopyOptions.create().setFieldMapping(mapping));

        //校验用户是否注册
        TUserExample example = new TUserExample();
        example.createCriteria().andAccountEqualTo(tUser.getAccount().trim())
                .andStatusEqualTo(HuamiaoConst.ZERO);
        ;
        List<TUser> tUsers = userMapper.selectByExample(example);

        if (!CollUtil.isEmpty(tUsers)) {
            return ResponseVo.failed("该账号已存在，注册失败");
        }

        tUser.setCreateTime(new Date());
        tUser.setPassword(passwordEncoder.encode(tUser.getPassword()));
        tUser.setId(IdHelper.generateLongId());

        int i = userMapper.insertSelective(tUser);

        if (i > 0) {
            boolean b = productMessage.produceUserMsg(JSONUtil.toJsonStr(tUser));
            log.info("推送一个用户到rabbitMq，"+(b ?"success":"fail"));
            return ResponseVo.success("注册成功");
        }

        return ResponseVo.failed("注册失败");
    }

    public ResponseVo updOrSaveUserInfo(UpdUserVo updUserVo) {
        TUser user;
        if (updUserVo.getId() != null) {
            //编辑用户
            TUserExample userExample = new TUserExample();
            userExample.createCriteria().andIdEqualTo(updUserVo.getId()).andStatusEqualTo(HuamiaoConst.ZERO);
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
//                SessionUtil.removeAttribute(ConstUtil.REDIS_USER);
//                SessionUtil.setAttribute(ConstUtil.REDIS_USER, user);
                RedisUtil.delUserInfo(RedisUtil.getKeyOfUser(jwtTokenUtil.getSubjectByToken()));
                RedisUtil.setUserInfo(RedisUtil.getKeyOfUser(jwtTokenUtil.getSubjectByToken()), user);

                return ResponseVo.success("更新成功");
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
            return ResponseVo.failed("保存成功");
        }

    }

    public UserRole getUserInfoByUserId(Long userId) {
        log.info("开始获得用户数据");
        UserRole user = (UserRole) ServletUtil.getRequest().getSession().getAttribute("user");
        if (user != null) {
            return user;
        }

        UserRole userRole = userMapper.selectUserInfoByUserId(userId);
        log.info("从数据库获得了用户数据");

        if (userRole != null) {
//            SessionUtil.setAttribute("user", userRole);
            RedisUtil.setUserInfo(RedisUtil.getKeyOfUser(jwtTokenUtil.getSubjectByToken()), userRole);
        }

        return userRole;
    }

    public ResponseVo delUser(Long userId) {
        TUserExample userExample = new TUserExample();
        userExample.createCriteria().andIdEqualTo(userId);

        List<TUser> tUsers = userMapper.selectByExample(userExample);
        if (CollUtil.isNotEmpty(tUsers)) {
            TUser tUser = tUsers.get(0);
            tUser.setStatus(HuamiaoConst.ONE);

            int i = userMapper.updateByPrimaryKey(tUser);

            if (i > 0) {
//                SessionUtil.removeAttribute("user");
//                UserRole user = SessionUtil.getAttribute("user", UserRole.class);
                RedisUtil.delUserInfo(RedisUtil.getKeyOfUser(jwtTokenUtil.getSubjectByToken()));
                TUser user = RedisUtil.getUserInfo(RedisUtil.getKeyOfUser(jwtTokenUtil.getSubjectByToken()));

                log.info(user.getUserName() + "删掉了用户{}", tUser.getUserName());
                return ResponseVo.success("删除成功");

            }
        }
        return ResponseVo.failed("删除失败");
    }

    public ResponseVo logout() {
//        SessionUtil.removeAttribute("user");
        RedisUtil.delUserInfo(RedisUtil.getKeyOfUser(jwtTokenUtil.getSubjectByToken()));
        return ResponseVo.success("你已退出");
    }

    public ResponseVo updPwd(UpdPwdVo updPwdVo) {
        TUserExample example = new TUserExample();
        example.createCriteria()
                .andStatusEqualTo(HuamiaoConst.ZERO)
                .andAccountEqualTo(updPwdVo.getAccount());

        List<TUser> tUsers = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tUsers)) {
            return ResponseVo.failed("更新失败哦");
        }
        TUser tUser = tUsers.get(0);

        if (!passwordEncoder.matches(updPwdVo.getOldPassword(), tUser.getPassword())) {
            return ResponseVo.failed("密码不对哟");
        }
        tUser.setPassword(passwordEncoder.encode(updPwdVo.getNewPassword()));
        int i = userMapper.updateByPrimaryKeySelective(tUser);
        if (i < 1) {
            return ResponseVo.failed("更新失败");
        }
        return ResponseVo.success("更新成功");
    }

    public ResponseVo resetPwd(String account) {
        TUserExample example = new TUserExample();
        example.createCriteria()
                .andStatusEqualTo(HuamiaoConst.ZERO)
                .andAccountEqualTo(account);
        List<TUser> tUsers = userMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tUsers)) {
            return ResponseVo.failed("更新失败哦");
        }
        TUser tUser = tUsers.get(0);
        tUser.setPassword(passwordEncoder.encode("123456"));
        userMapper.updateByPrimaryKeySelective(tUser);
        return ResponseVo.success("重置成功");
    }


    public PageVo<TUser> getAllUser(BaseParam baseParam) {
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
    public Set<String> getPermissionValues(Long userId) {
        Set<String> permissionValue = new HashSet<>();
        UserRole userRole = userMapper.queryByUserId(userId);
        List<RolePermission> roles = userRole.getRoles();
        roles.stream().forEach(item -> {
            List<TPermission> permissionList = item.getPermissionList();
            permissionValue.addAll(permissionList.stream().map(item1 -> item1.getValue()).collect(Collectors.toList()));
        });
        return permissionValue;
    }
}