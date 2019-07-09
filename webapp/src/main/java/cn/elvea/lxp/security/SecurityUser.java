package cn.elvea.lxp.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * SecurityUser
 *
 * @author elvea
 */
@Getter
@Setter
public class SecurityUser extends User {
    /**
     * ID
     */
    private Long id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String mobile;

    public SecurityUser(String username, String password, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, true, true, true, authorities);
    }

}
