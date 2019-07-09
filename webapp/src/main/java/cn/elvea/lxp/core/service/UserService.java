package cn.elvea.lxp.core.service;

import cn.elvea.lxp.core.dto.UserDto;

/**
 * UserService
 *
 * @author elvea
 */
public interface UserService {

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 用户
     */
    UserDto findByUsername(String username);

    /**
     * 根据用户ID查询用户
     *
     * @param id ID
     * @return 用户
     */
    UserDto findById(Long id);

}
