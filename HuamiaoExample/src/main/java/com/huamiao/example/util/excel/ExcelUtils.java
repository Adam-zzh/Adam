package com.huamiao.example.util.excel;


import com.alibaba.excel.annotation.ExcelProperty;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @Author: zzh 导入导出Excel工具类
 * @Date: 2022-01-04 20:10
 */
public class ExcelUtils {

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();


    /**
     * easyExcel校验导入excel错误问题
     * @param obj
     * @param <T>
     * @return
     * @throws NoSuchFieldException
     */
    public static <T> String validateEntity(T obj) throws NoSuchFieldException {
        StringBuilder result = new StringBuilder();
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        if (set != null && !set.isEmpty()) {
            for (ConstraintViolation<T> cv : set) {
                Field declaredField = obj.getClass().getDeclaredField(cv.getPropertyPath().toString());
                ExcelProperty annotation = declaredField.getAnnotation(ExcelProperty.class);
                //拼接错误信息，包含当前出错数据的标题名字+错误信息
                result.append(annotation.value()[0]+cv.getMessage()).append(";");
            }
        }
        return result.toString();
    }

}
