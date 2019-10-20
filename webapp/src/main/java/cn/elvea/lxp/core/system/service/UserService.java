package cn.elvea.lxp.core.system.service;

import cn.elvea.lxp.core.system.dto.UserDto;
import cn.elvea.lxp.core.system.form.Register;

/**
 * UserService
 *
 * @author elvea
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     */
    UserDto findUserByUsername(String username);

    /**
     * 根据电子邮箱查询用户
     */
    UserDto findUserByEmail(String email);

    /**
     * 根据手机号码查询用户
     */
    UserDto findUserByMobile(String mobile);

    /**
     * 根据用户ID查询用户
     */
    UserDto findById(Long id);

    /**
     * 用户注册
     */
    void register(Register register);

    /**
     * 保存用户
     */
    UserDto save(UserDto userDto);

}
