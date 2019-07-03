package cn.elvea.lxp.security;

import cn.elvea.lxp.core.dto.UserDto;
import cn.elvea.lxp.core.service.UserService;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * SecurityUserDetailsService
 *
 * @author elvea
 */
@Service("userDetailsService")
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    /**
     *
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userService.findByUsername(username);
        if (userDto == null) {
            // 找不到用户
            throw new UsernameNotFoundException("");
        }
        return new SecurityUserDetails(
                userDto.getUsername(),
                userDto.getPassword(),
                true, true, true, true, Sets.newHashSet()
        );
    }

}
