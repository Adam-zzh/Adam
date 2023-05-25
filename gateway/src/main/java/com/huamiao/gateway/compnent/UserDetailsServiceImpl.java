package com.huamiao.gateway.compnent;

import com.huamiao.common.entity.ResponseVo;
import com.huamiao.gateway.client.UserClient;
import com.huamiao.gateway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author ceshi
 * @date 2021/3/9 14:03
 * @description 用户登录处理
 * @version 1.0.0
 */
@Service
public class UserDetailsServiceImpl implements ReactiveUserDetailsService {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserClient userClient;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        User user = userClient.findByUserName(username).getData();
        SecurityUserDetails securityUserDetails = new SecurityUserDetails(
                user.getUserName(),
                passwordEncoder.encode(user.getPassword()),
                true,
                true,
                true,
                true, new ArrayList<>(),
                user.getId()
        );
        return Mono.just(securityUserDetails);
    }
}
