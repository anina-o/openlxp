package cn.elvea.lxp.security;

import cn.elvea.lxp.security.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * SecurityAuthenticationProvider
 *
 * @author sunlearning
 */
@Service("authenticationProvider")
public class SecurityAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private SecurityUserService securityUserService;

    public SecurityAuthenticationProvider() {
        // 登录成功后，把登录凭证强制转为String，也就是用户名
        this.setForcePrincipalAsString(true);
    }

    @Override
    protected void doAfterPropertiesSet() {
        Assert.notNull(this.securityUserService, "A UserDetailsService must be set");
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
                                                  UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected final UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException {
        UserDetails loadedUser;
        try {
            loadedUser = securityUserService.loadUserByUsername(username);
        } catch (UsernameNotFoundException notFound) {
            throw notFound;
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        if (loadedUser == null) {
            throw new InternalAuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
        }
        return loadedUser;
    }
}
