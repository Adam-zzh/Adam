package com.huamiao.gateway.util.rsa;

import com.google.common.collect.Maps;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.PrivateKey;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2022/9/2
 * @since 1.0.0
 */
public abstract class AbstractJwtToken {

    public abstract PrivateKey getPrivateKey() throws Exception;
    public abstract PrivateKey getPublicKey() throws Exception;

    public String generateTokenByRsa(String content) throws Exception {
        Map<String, Object> headers = Maps.newHashMap();
        headers.put("alg", "RS256");
        headers.put("typ", "JWT");

        String compact = CustomJwtBuilder.builder()
                .setHeader(headers)
                .setPayload(content)
                .signWith(SignatureAlgorithm.RS256, getPrivateKey())
                .compact();
        return compact;
    }

}