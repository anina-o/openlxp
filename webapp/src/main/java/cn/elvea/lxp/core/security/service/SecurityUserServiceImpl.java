package cn.elvea.lxp.core.security.service;

import cn.elvea.lxp.common.utils.RegexUtils;
import cn.elvea.lxp.core.system.dto.UserDto;
import cn.elvea.lxp.core.system.service.UserService;
import cn.elvea.lxp.core.security.SecurityUser;
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
public class SecurityUserServiceImpl implements SecurityUserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    /**
     * 根据用户名加载用户
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto;
        if (RegexUtils.isEmail(username)) {
            // 邮箱登录
            userDto = userService.findUserByEmail(username);
        } else if (RegexUtils.isMobile(username)) {
            // 手机号码登录
            userDto = userService.findUserByEmail(username);
        } else {
            // 账号登录
            userDto = userService.findUserByUsername(username);
        }
        //
        if (userDto == null) {
            // 找不到用户
            throw new UsernameNotFoundException("");
        }
        List<SimpleGrantedAuthority> authorities = userDto.getRoleList()
                .stream().map(role -> new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toList());
        SecurityUser securityUser = new SecurityUser(userDto.getUsername(), userDto.getPassword(), true, authorities);
        securityUser.setId(userDto.getId());
        securityUser.setNickname(userDto.getNickname());
        securityUser.setEmail(userDto.getEmail());
        securityUser.setMobile(userDto.getMobile());
        return securityUser;
    }

    /**
     * @see SecurityUserService#encryptPassword(String)
     */
    @Override
    public String encryptPassword(String password) {
        return this.passwordEncoder.encode(password);
    }

    /**
     * @see SecurityUserService#isPasswordMatch(String, String)
     */
    @Override
    public boolean isPasswordMatch(String presentedPassword, String encodedPassword) {
        return this.passwordEncoder.matches(presentedPassword, encodedPassword);
    }

}
