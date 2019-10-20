package cn.elvea.lxp.core.security;

import cn.elvea.lxp.core.security.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * SecurityAuthenticationProvider
 *
 * @author sunlearning
 */
@Service("authenticationProvider")
public class SecurityAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SecurityUserService securityService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名和密码
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        // 认证逻辑
        UserDetails userDetails = securityService.loadUserByUsername(username);
        if (null != userDetails) {
            if (securityService.isPasswordMatch(password, userDetails.getPassword())) {
                return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
            } else {
                throw new BadCredentialsException("密码错误");
            }
        } else {
            throw new UsernameNotFoundException("用户不存在");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
