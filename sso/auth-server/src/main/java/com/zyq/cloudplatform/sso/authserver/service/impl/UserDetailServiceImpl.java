package com.zyq.cloudplatform.sso.authserver.service.impl;

import com.zyq.cloudplatform.sso.authserver.entity.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户信息服务
 * @author zhangyunqi
 * @date 2019/10/28
 */
@Service("userDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {
    /**
     * 用户信息服务
     * @param s 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user = UserDetail.withUsername("root")
                //密码 123
                .password("{bcrypt}$2a$10$Pm5hJanxUE9BLGOjPtC0GOUwy7aYPJqtLZ1kt0cJE1oSjTmJgSUN.")
                .roles("ADMIN")
                .build();

        return user;
    }

    public static void main(String[] args) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        System.out.println(encoder.encode("123"));
    }
}
