package com.huamiao.gateway.config;

import com.huamiao.gateway.compnent.*;
import com.huamiao.gateway.util.JwtTokenUtil;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.authentication.DelegatingReactiveAuthenticationManager;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author ShiLei
 * @version 1.0.0
 * @date 2021/3/11 10:56
 * @description webflux security核心配置类
 */
@EnableWebFluxSecurity
@Configuration
@EnableConfigurationProperties(IgnoreUrlsConfig.class)
public class WebfluxSecurityConfig {

    @Resource
    private DefaultAuthorizationManager defaultAuthorizationManager;

    @Resource
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Resource
    private DefaultAuthenticationSuccessHandler defaultAuthenticationSuccessHandler;

    @Resource
    private DefaultAuthenticationFailureHandler defaultAuthenticationFailureHandler;

    @Resource
    private TokenAuthenticationManager tokenAuthenticationManager;

    @Resource
    private DefaultSecurityContextRepository defaultSecurityContextRepository;

    @Resource
    private DefaultAuthenticationEntryPoint defaultAuthenticationEntryPoint;

    @Resource
    private DefaultAccessDeniedHandler defaultAccessDeniedHandler;


    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity, @Autowired IgnoreUrlsConfig ignoreUrlsConfig) {
        httpSecurity
                // 登录认证处理
                .authenticationManager(reactiveAuthenticationManager())
                .securityContextRepository(defaultSecurityContextRepository)
                // 请求拦截处理
                .authorizeExchange(exchange -> exchange
                        .pathMatchers(ignoreUrlsConfig.getUrls().toArray(new String[]{})).permitAll()
                        .pathMatchers(HttpMethod.OPTIONS).permitAll()
                        .anyExchange().access(defaultAuthorizationManager)
                )
                .formLogin()
                // 自定义处理
                .authenticationSuccessHandler(defaultAuthenticationSuccessHandler)
                .authenticationFailureHandler(defaultAuthenticationFailureHandler)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(defaultAuthenticationEntryPoint)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(defaultAccessDeniedHandler)
                .and()
                .csrf().disable()
        ;
        return httpSecurity.build();

    }

    /**
     * BCrypt密码编码
     */
    @Bean("passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    /**
     * 注册用户信息验证管理器，可按需求添加多个按顺序执行
     */
    @Bean
    ReactiveAuthenticationManager reactiveAuthenticationManager() {
        LinkedList<ReactiveAuthenticationManager> managers = new LinkedList<>();
        managers.add(authentication -> {
            // 其他登陆方式 (比如手机号验证码登陆) 可在此设置不得抛出异常或者 Mono.error
            return Mono.empty();
        });
        // 必须放最后不然会优先使用用户名密码校验但是用户名密码不对时此 AuthenticationManager 会调用 Mono.error 造成后面的 AuthenticationManager 不生效
        managers.add(new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsServiceImpl));
        managers.add(tokenAuthenticationManager);
        return new DelegatingReactiveAuthenticationManager(managers);
    }

    // 启动报错 feign.codec.EncodeException
    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }


}
