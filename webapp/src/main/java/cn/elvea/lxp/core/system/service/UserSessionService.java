package cn.elvea.lxp.core.system.service;

import cn.elvea.lxp.core.system.dto.UserSessionDto;

/**
 * UserSessionService
 *
 * @author elvea
 */
public interface UserSessionService {

    /**
     * 创建会话记录
     */
    UserSessionDto createSession(UserSessionDto sessionDto);

    /**
     * 更新会话记录
     */
    UserSessionDto updateSession(UserSessionDto userSession);

    /**
     * 删除会话记录
     */
    void removeSession(UserSessionDto userSession);

}
