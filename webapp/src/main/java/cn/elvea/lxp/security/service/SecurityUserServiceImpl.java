package cn.elvea.lxp.security.service;

import cn.elvea.lxp.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * SecurityUserServiceImpl
 *
 * @author elvea
 */
@Service("userDetailsService")
public class SecurityUserServiceImpl implements SecurityUserService {

    @Autowired
    UserService userService;

    /**
     *
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

}
