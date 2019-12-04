package com.zyq.cloudplatform.apps.app3.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author zhangyunqi
 * @date 2019/12/03
 */
@Configuration
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //.formLogin().loginPage("/login.html")
                .authorizeRequests()
                //.antMatchers("/login.html").permitAll()
                .anyRequest().authenticated();
    }

}
