package com.zyq.cloudplatform.sso.authserver.service.impl;

import com.zyq.cloudplatform.sso.authserver.entity.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("ADMIN")
                .build();
        return user;
    }

}
