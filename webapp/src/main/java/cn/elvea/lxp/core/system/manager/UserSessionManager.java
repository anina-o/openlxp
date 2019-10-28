package cn.elvea.lxp.core.system.manager;

import cn.elvea.lxp.core.system.entity.UserSessionEntity;

/**
 * UserSessionManager
 *
 * @author elvea
 */
public interface UserSessionManager {

    /**
     * 获取用户会话
     */
    UserSessionEntity getUserSession(String sessionId);

    /**
     * 保存用户会话
     */
    UserSessionEntity saveUserSession(UserSessionEntity entity);

    /**
     * 结束用户会话
     */
    void removeUserSession(UserSessionEntity entity);

}
