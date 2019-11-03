package cn.elvea.lxp.core.system.manager;

import cn.elvea.lxp.core.system.entity.UserSessionHistoryEntity;

/**
 * UserSessionHistoryManager
 *
 * @author elvea
 */
public interface UserSessionHistoryManager {

    /**
     * 保存用户会话历史记录
     */
    void saveUserSessionHistory(UserSessionHistoryEntity entity);

}
