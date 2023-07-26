package com.huamiao.gateway.compnent;

import com.alibaba.fastjson.JSONObject;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.gateway.config.IgnoreUrlsConfig;
import com.huamiao.gateway.enums.UserStatusCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * @author ShiLei
 * @version 1.0.0
 * @date 2021/3/11 13:10
 * @description 用户权限鉴权处理
 */
@Component
@Slf4j
@EnableConfigurationProperties(IgnoreUrlsConfig.class)
public class DefaultAuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {


    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> authentication, AuthorizationContext authorizationContext) {
        return authentication.map(auth -> {
            ServerWebExchange exchange = authorizationContext.getExchange();
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();

            for (String url : ignoreUrlsConfig.getUrls()) {
                if (this.antPathMatcher.match(url,path)) {
                    log.info(String.format("拦截白名单 Path:{%s} ", path));
                    return new AuthorizationDecision(true);
                }
            }


            Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                String authorityAuthority = authority.getAuthority();

                // TODO
                // 查询用户访问所需角色进行对比

                if (antPathMatcher.match(authorityAuthority, path)) {
                    log.info(String.format("用户请求API校验通过，GrantedAuthority:{%s}  Path:{%s} ", authorityAuthority, path));
                    return new AuthorizationDecision(true);
                }
            }
            return new AuthorizationDecision(false);
        }).defaultIfEmpty(new AuthorizationDecision(false));
    }

    @Override
    public Mono<Void> verify(Mono<Authentication> authentication, AuthorizationContext object) {
        return check(authentication, object)
                .filter(AuthorizationDecision::isGranted)
                .switchIfEmpty(Mono.defer(() -> {
                    String body = JSONObject.toJSONString(ResponseVo.failed(UserStatusCodeEnum.PERMISSION_DENIED));
                    return Mono.error(new AccessDeniedException(body));
                }))
                .flatMap(d -> Mono.empty());
    }
}
