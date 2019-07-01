package cn.elvea.lxp.core.manager;

import cn.elvea.lxp.common.manager.BaseManager;
import cn.elvea.lxp.core.entity.UserEntity;

/**
 * UserManager
 *
 * @author elvea
 */
public interface UserManager extends BaseManager<UserEntity, Long> {

    /**
     * 根据用户名查询用户实体
     *
     * @param username 用户名
     * @return 用户
     */
    UserEntity findByUsername(String username);

}
