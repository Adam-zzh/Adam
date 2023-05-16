package com.huamiao.blog.util;

import com.huamiao.common.util.ApplicationUtil;
import com.huamiao.common.util.IdGenerator;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/5/10
 * @since 1.0.0
 */
public class IdHelper {

    public static String generateId(){
        return ApplicationUtil.getBean(IdGenerator.class).nextIdStr();
    }

    public static Long generateLongId(){
        return Long.valueOf(ApplicationUtil.getBean(IdGenerator.class).nextIdStr());
    }
}