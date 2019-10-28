package cn.elvea.lxp.core.system.manager;

import cn.elvea.lxp.core.system.entity.UserLoginHistoryEntity;

/**
 * UserLoginHistoryManager
 *
 * @author elvea
 */
public interface UserLoginHistoryManager {

    /**
     * 保存用户登录历史记录实体到数据库
     */
    void saveUserLoginHistory(UserLoginHistoryEntity entity);

}
