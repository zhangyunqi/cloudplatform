package com.zyq.cloudplatform.sso.authserver.configuration;

import com.zyq.cloudplatform.sso.authserver.configuration.properties.UaaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * JWTTokenStore的配置类
 *
 * @author zhangyunqi
 * @date 2019/11/29
 */
@Configuration
public class JWTTokenStoreConfig {

    @Autowired
    private UaaProperties uaaProperties;

    /**
     * 定义tokenStore
     * 用于生成、加密、解密token
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    /**
     * 定义tokenServices，有关token的处理都来自于此
     * 用于处理tokenStore的配置
     *
     * @return
     */
    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

    /**
     * JWT的加密、解密、签名的转换
     * 加入非对称加密算法RSA
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //使用RSA生成.jks文件的公钥和私钥以及证书内容
        //keytool -genkeypair -alias cars -keyalg RSA -keypass Cars123 -keystore "d:\mykeystore.jks"  -dname "CN=cars, OU=cars, O=cars, L=BJ, ST=BJ, C=CN" -storepass Cars123 -validity 3650
        KeyPair keyPair = new KeyStoreKeyFactory(
                new ClassPathResource(uaaProperties.getKeyStore().getName()), uaaProperties.getKeyStore().getPassword().toCharArray())
                .getKeyPair(uaaProperties.getKeyStore().getAlias());
        //密钥对放入转换器
        converter.setKeyPair(keyPair);
        return converter;
    }

    /**
     * JwtToken的增强器
     * 此类是为了往token里放入自定义的字段
     *
     * @return
     */
    @Bean
    public TokenEnhancer jwtTokenEnhancer() {
        return new JWTTokenEnhancer();
    }
}
