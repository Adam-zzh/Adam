package com.huamiao.gateway.util.rsa;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.TextCodec;
import lombok.SneakyThrows;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2022/9/2
 * @since 1.0.0
 */
public class CustomJwtBuilder {
    private CustomJwtBuilder(){}

    public static JwtBuilder builder() {
        return new CustomJwt();
    }

    public static class CustomJwt implements JwtBuilder{

        private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

        private String headerStr;
        private String payLoad;
        private SignatureAlgorithm alg;
        private Key key;

        @Override
        public JwtBuilder setHeader(Header header) {
            return null;
        }

        @Override
        public JwtBuilder setHeader(Map<String, Object> header) {
            this.headerStr = JSONUtil.parseObj(new TreeMap<>(header),false, true).toString();
            return this;
        }

        @Override
        public JwtBuilder setHeaderParams(Map<String, Object> params) {
            return null;
        }

        @Override
        public JwtBuilder setHeaderParam(String name, Object value) {
            return null;
        }

        @Override
        public JwtBuilder setPayload(String payload) {
            this.payLoad = payload;
            return this;
        }

        @Override
        public JwtBuilder setClaims(Claims claims) {
            return null;
        }

        @Override
        public JwtBuilder setClaims(Map<String, Object> claims) {
            return null;
        }

        @Override
        public JwtBuilder addClaims(Map<String, Object> claims) {
            return null;
        }

        @Override
        public JwtBuilder setIssuer(String iss) {
            return null;
        }

        @Override
        public JwtBuilder setSubject(String sub) {
            return null;
        }

        @Override
        public JwtBuilder setAudience(String aud) {
            return null;
        }

        @Override
        public JwtBuilder setExpiration(Date exp) {
            return null;
        }

        @Override
        public JwtBuilder setNotBefore(Date nbf) {
            return null;
        }

        @Override
        public JwtBuilder setIssuedAt(Date iat) {
            return null;
        }

        @Override
        public JwtBuilder setId(String jti) {
            return null;
        }

        @Override
        public JwtBuilder claim(String name, Object value) {
            return null;
        }

        @Override
        public JwtBuilder signWith(SignatureAlgorithm alg, byte[] secretKey) {
            return null;
        }

        @Override
        public JwtBuilder signWith(SignatureAlgorithm alg, String base64EncodedSecretKey) {
            return null;
        }

        @Override
        public JwtBuilder signWith(SignatureAlgorithm alg, Key key) {
            this.alg = alg;
            this.key = key;
            return this;
        }

        @Override
        public JwtBuilder compressWith(CompressionCodec codec) {
            return null;
        }

        @SneakyThrows
        @Override
        public String compact() {
            String base64UrlEncodedHeader = TextCodec.BASE64URL.encode(this.headerStr.getBytes());

            String base64UrlEncodedBody = TextCodec.BASE64URL.encode(this.payLoad.getBytes());

            byte[] concat = concat(Base64.getUrlEncoder().withoutPadding().encode(JSONUtil.toJsonStr(this.headerStr).getBytes()), ".".getBytes(), Base64.getUrlEncoder().withoutPadding().encode(this.payLoad.getBytes()));

//                Signature signature = Signature.getInstance(alg.getJcaName());
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign((RSAPrivateKey) key);
            signature.update(concat);
            byte[] sign = signature.sign();
            String base64UrlSignature = Base64.getUrlEncoder().withoutPadding().encodeToString(sign);

            return base64UrlEncodedHeader + JwtParser.SEPARATOR_CHAR + base64UrlEncodedBody + JwtParser.SEPARATOR_CHAR + base64UrlSignature;
        }

        protected String base64UrlEncode(Object o, String errMsg) {
            byte[] bytes;
            try {
                bytes = toJson(o);
            } catch (JsonProcessingException e) {
                throw new IllegalStateException(errMsg, e);
            }

            return TextCodec.BASE64URL.encode(bytes);
        }


        protected byte[] toJson(Object object) throws JsonProcessingException {
            return OBJECT_MAPPER.writeValueAsBytes(object);
        }

        public static byte[] concat(byte[]... arrays) {
            int size = 0;
            for (byte[] a: arrays) {
                size += a.length;
            }
            byte[] result = new byte[size];
            int index = 0;
            for (byte[] a: arrays) {
                System.arraycopy(a, 0, result, index, a.length);
                index += a.length;
            }
            return result;
        }

        private static Charset UTF8 = Charset.forName("UTF-8");

        public static byte[] utf8Encode(CharSequence string) {
            try {
                ByteBuffer bytes = UTF8.newEncoder().encode(CharBuffer.wrap(string));
                byte[] bytesCopy = new byte[bytes.limit()];
                System.arraycopy(bytes.array(), 0, bytesCopy, 0, bytes.limit());
                return bytesCopy;
            }
            catch (CharacterCodingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}