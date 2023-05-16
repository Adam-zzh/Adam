package com.huamiao.example.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CustomMerge {

    boolean needMerge() default false;

    boolean isPk() default false;
}
