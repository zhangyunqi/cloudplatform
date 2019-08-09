package com.zyq.cloudplatform.sso.authserver.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * web安全配置
 * @author zhangyunqi
 * @date 2019/08/09
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 密码模式必须
     * 在UsernamePasswordAuthenticationFilter的attemptAuthentication()方法中，调用AuthenticationManager进行认证
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    /**
     * spring 5以后，密码必须加密
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
