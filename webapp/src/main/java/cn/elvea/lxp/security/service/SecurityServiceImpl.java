package cn.elvea.lxp.security.service;

import cn.elvea.lxp.core.dto.UserDto;
import cn.elvea.lxp.core.service.UserService;
import cn.elvea.lxp.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * SecurityServiceImpl
 *
 * @author elvea
 */
@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    /**
     * 根据用户名加载用户
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userService.findByUsername(username);
        if (userDto == null) {
            // 找不到用户
            throw new UsernameNotFoundException("");
        }
        List<SimpleGrantedAuthority> authorities = userDto.getRoles().stream()
                .map(roleDto -> new SimpleGrantedAuthority(roleDto.getCode())).collect(Collectors.toList());
        SecurityUser securityUser = new SecurityUser(userDto.getUsername(), userDto.getPassword(), true, authorities);
        securityUser.setId(userDto.getId());
        securityUser.setNickname(userDto.getNickname());
        securityUser.setEmail(userDto.getEmail());
        securityUser.setMobile(userDto.getMobile());
        return securityUser;
    }

    /**
     * @see SecurityService#encryptPassword(String)
     */
    @Override
    public String encryptPassword(String password) {
        return this.passwordEncoder.encode(password);
    }

    /**
     * @see SecurityService#isPasswordMatch(String, String)
     */
    @Override
    public boolean isPasswordMatch(String presentedPassword, String encodedPassword) {
        return this.passwordEncoder.matches(presentedPassword, encodedPassword);
    }

}
