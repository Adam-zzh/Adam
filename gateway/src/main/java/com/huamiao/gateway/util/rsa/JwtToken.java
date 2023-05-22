package com.huamiao.gateway.util.rsa;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author ZZH
 * @create 2022/9/2
 * @since 1.0.0
 */
public class JwtToken extends AbstractJwtToken {

    private static String publicExponent = "65537";
    private static String privateExponent = "17229266893241928019407448538210767394314299831091924595141407231192097700085259794646635668667196594382333548862926951453552408374412828286121538469820555639179408599684718288543042181104921632781024582518681487594175261480330600707088202917746658509127479673682915944749732373968033990096280738372728055673";
    private static String modulus = "106423606445089183469171155028154482820092013951957724994512950585356880958575652324387988861210373534970310442208260472894577209013562066671776368208918942020783431571722667979490630586343538306223319468173581167993941500586382020805072004931124403103870349566932555032205872045530004847976880850153190269597";

    @Override
    public PrivateKey getPrivateKey() throws Exception {
        RSAPrivateKeySpec privateSpec = new RSAPrivateKeySpec(new BigInteger(modulus),
                new BigInteger(privateExponent));
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(privateSpec);
    }

    @Override
    public PrivateKey getPublicKey() throws Exception {
        RSAPublicKeySpec publicSpec = new RSAPublicKeySpec(new BigInteger(modulus),
                new BigInteger(publicExponent));
        KeyFactory factory = KeyFactory.getInstance("RSA");
        return factory.generatePrivate(publicSpec);
    }

    public static void main(String[] args) throws Exception {
        String content = "{\"app\":\"2\",\"wxUserId\":null,\"user_name\":\"1015030\",\"userNo\":\"1015030\",\"user:nickname\":\"李娜\",\"user:name\":\"1015030\",\"version\":\"3\",\"authorities\":[\"ROLE_USER\",\"ROLE_ADMIN\"],\"platform\":\"1\",\"primarysid\":1000063,\"client_id\":\"web\",\"aud\":[\"Benlai.O2OERP.WebApi\"],\"scope\":[\"all\"],\"name\":\"李娜\",\"userType\":2,\"exp\":1662188065,\"jti\":\"80f49900-df22-4ffd-8eca-cb569cc26e48\"}";
        JwtToken token = new JwtToken();
        System.out.println(token.generateTokenByRsa(content));
    }

}