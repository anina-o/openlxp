package cn.elvea.lxp.core.manager;

import cn.elvea.lxp.common.service.BaseManager;
import cn.elvea.lxp.core.entity.UserEntity;

/**
 * UserManager
 *
 * @author elvea
 */
public interface UserManager extends BaseManager<UserEntity, Long> {

    /**
     * 根据用户名查询用户
     */
    UserEntity findByUsername(String username);

    /**
     * 清空缓存
     */
    void clear();
    
}
