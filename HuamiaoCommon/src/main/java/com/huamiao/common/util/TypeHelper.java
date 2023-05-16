package com.huamiao.common.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈反射根据字段类型进行类型转换〉
 *
 * @author ZZH
 * @create 2021/5/19
 * @since 1.0.0
 */
public class TypeHelper {

    public static <T> T tranfrom(Class<T> clazz, Object value){
        if (clazz == Integer.class){
            return (T) Integer.valueOf(String.valueOf(value));
        }else if (clazz == Long.class){
            return (T) Long.valueOf(String.valueOf(value));
        }else if (clazz == Byte.class){
            return (T) Byte.valueOf(String.valueOf(value));
        }else if (clazz == BigDecimal.class){
            return (T) BigDecimal.valueOf(Double.valueOf(String.valueOf(value)));
        }else if (clazz == Date.class){
            return (T) new Date(Long.valueOf(String.valueOf(value)));
        }else {
            return (T) String.valueOf(value);
        }
    }
}