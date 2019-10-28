package com.zyq.cloudplatform.sso.authserver.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 用户信息实体
 *
 * @author zhangyunqi
 * @date 2019/10/28
 */
public class UserDetail extends User {
    private String userId;

    /**
     * 构建用户实体
     *
     * @param username 用户名
     * @param password 密码
     * @param authorities 角色信息
     * @param userId
     */
    public UserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities, String userId) {
        super(username, password, authorities);
        this.userId = userId;
    }

    /**
     * 构建用户实体
     *
     * @param username 用户名
     * @param password 密码
     * @param enabled 用户是否启用，启用为true;禁用为false
     * @param accountNonExpired 用户名是否已经过期，如果有效（未过期）返回ture;失效（过期）为false
     * @param credentialsNonExpired 密码是否已经过期，如果有效（未过期）返回ture;失效（过期）为false
     * @param accountNonLocked 用户是否被锁，没有被锁为ture,被锁为false
     * @param authorities 用户授权的角色集合
     * @param userId 用户ID
     */
    public UserDetail(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String userId) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
    }
}
