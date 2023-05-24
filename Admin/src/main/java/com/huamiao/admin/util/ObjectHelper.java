package com.huamiao.admin.util;

import org.springframework.util.CollectionUtils;

import java.util.List;
/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2023/5/24
 * @since 1.0.0
 */
public class ObjectHelper {

    public static <T> T findFirst(List<T> data){
        if (CollectionUtils.isEmpty(data)) return null;
        return data.get(0);
    }
}