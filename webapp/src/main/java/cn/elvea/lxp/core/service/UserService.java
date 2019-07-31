package cn.elvea.lxp.core.service;

import cn.elvea.lxp.core.dto.UserDto;
import cn.elvea.lxp.core.form.Register;

/**
 * UserService
 *
 * @author elvea
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     */
    UserDto findByUsername(String username);

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
