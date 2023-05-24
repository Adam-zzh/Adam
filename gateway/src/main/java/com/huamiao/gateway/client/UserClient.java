package com.huamiao.gateway.client;

import com.huamiao.common.entity.ResponseVo;
import com.huamiao.gateway.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户client〉
 *
 * @author ZZH
 * @create 2023/5/24
 * @since 1.0.0
 */
@FeignClient("/user/admin")
public interface UserClient {

    @GetMapping("findByUserName")
    ResponseVo<User> findByUserName(String userName);
}