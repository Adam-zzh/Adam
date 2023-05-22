package com.huamiao.gateway.compnent;

import com.alibaba.fastjson.JSONObject;
import com.huamiao.common.entity.ResponseVo;
import com.huamiao.gateway.enums.UserStatusCodeEnum;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author ShiLei
 * @version 1.0.0
 * @date 2021/3/11 15:14
 * @description 登录失败处理
 */
@Component
public class DefaultAuthenticationFailureHandler implements ServerAuthenticationFailureHandler {

    @Override
    public Mono<Void> onAuthenticationFailure(WebFilterExchange webFilterExchange, AuthenticationException exception) {
        return Mono.defer(() -> Mono.just(webFilterExchange.getExchange().getResponse()).flatMap(response -> {
            DataBufferFactory dataBufferFactory = response.bufferFactory();
            ResponseVo<Map<String, Object>> resultVO = ResponseVo.failed();
            // 账号不存在
            if (exception instanceof UsernameNotFoundException) {
                resultVO = ResponseVo.failed(UserStatusCodeEnum.ACCOUNT_NOT_EXIST);
                // 用户名或密码错误
            } else if (exception instanceof BadCredentialsException) {
                resultVO = ResponseVo.failed(UserStatusCodeEnum.LOGIN_PASSWORD_ERROR);
                // 账号已过期
            } else if (exception instanceof AccountExpiredException) {
                resultVO = ResponseVo.failed(UserStatusCodeEnum.ACCOUNT_EXPIRED);
                // 账号已被锁定
            } else if (exception instanceof LockedException) {
                resultVO = ResponseVo.failed(UserStatusCodeEnum.ACCOUNT_LOCKED);
                // 用户凭证已失效
            } else if (exception instanceof CredentialsExpiredException) {
                resultVO = ResponseVo.failed(UserStatusCodeEnum.ACCOUNT_CREDENTIAL_EXPIRED);
                // 账号已被禁用
            } else if (exception instanceof DisabledException) {
                resultVO = ResponseVo.failed(UserStatusCodeEnum.ACCOUNT_DISABLE);
            }

            DataBuffer dataBuffer = dataBufferFactory.wrap(JSONObject.toJSONString(resultVO).getBytes());
            return response.writeWith(Mono.just(dataBuffer));
        }));
    }
}
