package com.huamiao.common.constant;

/**
 * 〈一句话功能简述〉<br>
 * 〈admin服务常量表〉
 *
 * @author ZZH
 * @create 2021/4/29
 * @since 1.0.0
 */
public class HuamiaoConst {

    /**
     * @Description 禁用
     */
    public static final Byte ONE = 1;

    /**
     * @Description 未禁用
     */
    public static final Byte ZERO = 0;

    /**
     * redis 存储用户信息的键
     */
    public static final String REDIS_USER = "user";

    /**
     * jwt主题消息之一 用户昵称
     */
    public static final String PAYLOAD_KEY_USERNAME = "username";
    /**
     * jwt主题消息之一 用户账号
     */
    public static final String PAYLOAD_KEY_ACCOUNT = "account";
}