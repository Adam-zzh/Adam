package com.huamiao.common.base;

import com.huamiao.common.exception.Asserts;
import com.huamiao.common.util.RedisHelper;
import com.huamiao.common.util.ServletHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/5/24
 * @since 1.0.0
 */
public class UserSession
{
    public static void setUser(User user){
        RedisHelper.set(user.getToken(), user, user.getExpireSecond());
    }

    public static User getUser(String token){
        Object o = RedisHelper.get(token);
        if (o == null) Asserts.fail("用户身份失效, 请重新登陆");
        return (User) o;
    }

    public static User getUser(){
        HttpServletRequest request = ServletHelper.getRequest();

        return getUser(request.getHeader("Authorization"));
    }

    public static void clear(String token){
        RedisHelper.del(token);
    }

    public static String getUserName(){
        return getUser().getUserName();
    }
}