package com.huamiao.admin.config;

import com.huamiao.common.entity.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by zzh on 2019/4/8.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends com.huamiao.common.config.SwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.huamiao.admin.controller")
                .title("后端管理系统")
                .description("SpringBoot版本中的一些示例")
                .contactName("huamiao")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }

}
