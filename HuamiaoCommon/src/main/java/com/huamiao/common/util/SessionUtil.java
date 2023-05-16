package com.huamiao.common.util;

import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br>
 * 〈分布式Session操作〉
 *
 * @author ZZH
 * @create 2021/5/3
 * @since 1.0.0
 */
public class SessionUtil {

    /**
     * 获得session对象
     * @return session对象
     */
    public static HttpSession getHttpSession(){
        return ApplicationUtil.getRequest().getSession();
    }

    /**
     * 设置session属性
     * @param aliasName session对应的属性名key
     * @param o 对象信息
     */
    public static void setAttribute(String aliasName, Object o){
        getHttpSession().setAttribute(aliasName, o);
    }

    /**
     *
     * @param aliasName session对应的属性名key
     * @param T 要强转成的对象
     * @param <T>
     * @return
     */
    public static<T> T getAttribute(String aliasName, Class T){
        return (T)getHttpSession().getAttribute(aliasName);
    }

    /**
     * 移除session中的属性
     * @param aliasName
     */
    public static void removeAttribute(String aliasName){
        getHttpSession().removeAttribute(aliasName);
    }

}