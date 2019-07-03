package cn.elvea.lxp.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * SecurityUserDetails
 *
 * @author elvea
 */
public class SecurityUserDetails extends org.springframework.security.core.userdetails.User {

    /**
     * @param username              用户名
     * @param password              密码
     * @param enabled               用户状态是否正常
     * @param accountNonExpired     账号是否不过期
     * @param credentialsNonExpired 密码是否不过期
     * @param accountNonLocked      账号是否未锁定
     * @param authorities           账号权限
     */
    public SecurityUserDetails(String username, String password,
                               boolean enabled, boolean accountNonExpired,
                               boolean credentialsNonExpired, boolean accountNonLocked,
                               Collection<GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

}
