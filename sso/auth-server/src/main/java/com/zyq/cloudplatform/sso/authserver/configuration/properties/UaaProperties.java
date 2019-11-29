package com.zyq.cloudplatform.sso.authserver.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 认证服务OAuth2 security的配置.
 *
 * @author zhangyunqi
 * @date 2019/11/29
 */
@Component
@ConfigurationProperties(prefix = "uaa", ignoreUnknownFields = false)
public class UaaProperties {
    private KeyStore keyStore = new KeyStore();

    public KeyStore getKeyStore() {
        return keyStore;
    }

    /**
     * Keystore 签名和验证 JWT tokens 的配置.
     */
    public static class KeyStore {
        //keystore文件所在的相对地址
        private String name = "config/mykeystore.jks";
        //处理keystore的密码，
        private String password = "Cars123";
        //keystore的别名
        private String alias = "cars";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }
    }
}
