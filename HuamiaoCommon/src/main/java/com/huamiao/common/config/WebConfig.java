package com.huamiao.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 〈一句话功能简述〉<br>
 * 〈Long精度丢失〉
 *
 * @author ZZH
 * @create 2021/5/29
 * @since 1.0.0
 */
@Configuration
public class WebConfig {

    @Resource
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {
        /*
         * 序列换成json时,将long转string避免精度丢失
         */
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
    }

}