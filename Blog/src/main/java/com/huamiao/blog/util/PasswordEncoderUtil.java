package com.huamiao.blog.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 〈一句话功能简述〉<br>
 * 〈加密工具类〉
 *
 * @author ZZH
 * @create 2021/4/26
 * @since 1.0.0
 */
public class PasswordEncoderUtil {

    private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //使用构造方法生成对象

    /**
     * 对密码使用BCryptPasswordEncoder加密方式进行加密
     */
    public static String passwordEncoder(String password) {
        return passwordEncoder.encode(password);
    }

//    public static void main(String[] args) {
//        String s = PasswordEncoderUtil.passwordEncoder("123456");
//        String s1 = PasswordEncoderUtil.passwordEncoder("123456");
//        System.out.println(s);
//        boolean a = passwordEncoder.matches( "123456", "$2a$10$avwtdb5Y0EAEEF3hGgkE3.fdXBH2q5D3maz5hMllJbuqN/.jLsnNG");
//        System.out.println(a);
//    }

}