package com.huamiao.common.annotation;

import com.huamiao.common.config.MyProjectConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({MyProjectConfig.class})
public @interface EnableMyProject {
}
