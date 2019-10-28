package com.zyq.cloudplatform.sso.authserver.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 用户信息服务
 * @author zhangyunqi
 * @date 2019/10/28
 */
public class UserDetailServiceImpl implements UserDetailsService {
    /**
     * 用户信息服务
     * @param s 用户名
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return null;
    }
}
