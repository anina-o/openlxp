package cn.elvea.lxp.core.system.manager;

import cn.elvea.lxp.core.system.entity.UserSessionEntity;

/**
 * UserSessionStatisticsManager
 *
 * @author elvea
 */
public interface UserSessionStatisticsManager {

    /**
     * 更新在线时长记录
     */
    void saveUserSessionStatistics(UserSessionEntity session, long totalTime);

}
