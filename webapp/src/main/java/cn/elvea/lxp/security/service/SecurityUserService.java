package cn.elvea.lxp.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * SecurityService
 *
 * @author elvea
 */
public interface SecurityUserService extends UserDetailsService {

    /**
     * 密码加密
     *
     * @param presentedPassword 密码
     * @return 加密后的密码
     */
    String encryptPassword(String presentedPassword);

    /**
     * 验证密码是否匹配
     *
     * @param presentedPassword 密码
     * @param encodedPassword   已加密密码
     * @return boolean
     */
    boolean isPasswordMatch(String presentedPassword, String encodedPassword);

}
