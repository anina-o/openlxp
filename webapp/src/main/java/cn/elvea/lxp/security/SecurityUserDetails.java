package cn.elvea.lxp.security;

import lombok.Data;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

/**
 * SecurityUserDetails
 *
 * @author elvea
 */
@Data
public class SecurityUserDetails implements UserDetails, CredentialsContainer {
    /**
     * 用户名
     */
    private String username;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
    /**
     * 权限
     */
    private Set<GrantedAuthority> authorities;
    /**
     *
     */
    private boolean accountNonExpired;
    /**
     * 账号是否不过期
     */
    private boolean accountNonLocked;
    /**
     * 密码是否不过期
     */
    private boolean credentialsNonExpired;
    /**
     * 账号是否未锁定
     */
    private boolean enabled;

    /**
     * @param username    用户名
     * @param password    密码
     * @param enabled     用户状态是否正常
     * @param authorities 账号权限
     */
    public SecurityUserDetails(String username,
                               String nickname,
                               String password,
                               boolean enabled,
                               Set<GrantedAuthority> authorities) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
        this.accountNonExpired = true;
        this.credentialsNonExpired = true;
        this.accountNonLocked = true;
    }

    @Override
    public void eraseCredentials() {
        this.password = null;
    }

}
