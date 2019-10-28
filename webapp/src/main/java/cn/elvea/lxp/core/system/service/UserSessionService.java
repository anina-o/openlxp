package cn.elvea.lxp.core.system.service;

import cn.elvea.lxp.core.system.dto.UserLoginHistoryDto;
import cn.elvea.lxp.core.system.dto.UserSessionDto;

/**
 * UserSessionService
 *
 * @author elvea
 */
public interface UserSessionService {

    /**
     * 获取会话记录
     */
    UserSessionDto getSession(String sessionId);

    /**
     * 创建会话记录
     */
    void createSession(UserSessionDto sessionDto);

    /**
     * 更新会话记录
     */
    void updateSession(String sessionId);

    /**
     * 删除会话记录
     */
    void removeSession(String sessionId);

    /**
     * 保存用户会话记录
     */
    void saveUserSession(UserSessionDto userSessionDto);

    /**
     * 创建用户登录历史记录
     */
    void saveUserLoginHistory(UserLoginHistoryDto userLoginHistoryDto);

}
