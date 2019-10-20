package cn.elvea.lxp.core.system.manager;

import cn.elvea.lxp.core.system.entity.UserEntity;

/**
 * UserManager
 *
 * @author elvea
 */
public interface UserManager {

    /**
     * 根据用户名查询用户
     */
    UserEntity findUserByUsername(String username);

    /**
     * 根据电子邮箱查询用户
     */
    UserEntity findUserByEmail(String email);

    /**
     * 根据手机号码查询用户
     */
    UserEntity findUserByMobile(String mobile);

    /**
     * 根据用户ID查询用户
     */
    UserEntity findUserById(Long id);

    /**
     * 保存用户
     */
    UserEntity saveUser(UserEntity user);

    /**
     * 删除用户
     */
    void deleteUserById(Long id);

    /**
     * 清空所有用户缓存
     */
    void clearAllCache();

}
