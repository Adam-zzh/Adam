package com.huamiao.admin.service;//package com.smallhua.org.service;
//
//import cn.hutool.core.collection.CollUtil;
//import com.smallhua.org.common.util.ConstUtil;
//import com.smallhua.org.dto.UserRole;
//import com.smallhua.org.mapper.TUserMapper;
//import com.smallhua.org.model.TUser;
//import com.smallhua.org.model.TUserExample;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * 〈一句话功能简述〉<br>
// * 〈将和用户相关的信息放到redis中〉
// *
// * @author ZZH
// * @create 2021/5/1
// * @since 1.0.0
// */
//@Service
//@Slf4j
//public class UserCacheService {
//
//    public static final String split = ":";
//
//    @Value("${redis.database}")
//    private String redisDateBase;
//
//    @Value("${redis.expire.common}")
//    private Long expireTime;
//
//    @Value("${redis.key.user}")
//    private String userKey;
//
//    @Autowired
//    private TUserMapper userMapper;
//    @Autowired
//    private RedisService redisService;
//
//    /**
//     * 将用户信息存放到redis中
//     *  key：redis数据库+":"+表名（tUserRolePermission）+":"+用户账号
//     *  value：用户相关信息（用户、角色、资源）
//     * @param userRole 用户信息
//     */
//    public void setUserInfo(UserRole userRole){
//        if (userRole == null) {
//            return;
//        }
//        String account = userRole.getAccount();
//
//        String key = this.redisDateBase + this.split + this.userKey + this.split + account;
//        redisService.set(key, userRole, expireTime);
//
//
//        log.info("redis存入一条key为{}，value为{}的数据", key, userRole);
//    }
//
//    /**
//     * 根据id获得用户数据
//     * @param userId
//     * @return
//     */
//    public UserRole getUserInfo(Long userId){
//        TUserExample userExample = new TUserExample();
//        userExample.createCriteria().andIdEqualTo(userId)
//                .andStatusEqualTo(ConstUtil.ZERO);
//
//        List<TUser> tUsers = userMapper.selectByExample(userExample);
//        if (CollUtil.isEmpty(tUsers)){
//            return null;
//        }
//
//        String key = this.redisDateBase + this.split + this.userKey + tUsers.get(0).getAccount();
//        UserRole userRole = (UserRole) redisService.get(key);
//
//        log.info("{}用户从redis中拿到{}", tUsers.get(0).getAccount(), userRole);
//        return userRole;
//    }
//
//    public void delUserInfo(Long userId){
//        TUserExample userExample = new TUserExample();
//        userExample.createCriteria().andIdEqualTo(userId)
//                .andStatusEqualTo(ConstUtil.ZERO);
//
//        List<TUser> tUsers = userMapper.selectByExample(userExample);
//        if (CollUtil.isEmpty(tUsers)){
//            return;
//        }
//
//        String key = this.redisDateBase + this.split + this.userKey + tUsers.get(0).getAccount();
//        Boolean del = redisService.del(key);
//        if (del){
//            log.info("用户{}从redis中删掉一条key为{}的记录", tUsers.get(0).getAccount(), key);
//        }
//    }
//}