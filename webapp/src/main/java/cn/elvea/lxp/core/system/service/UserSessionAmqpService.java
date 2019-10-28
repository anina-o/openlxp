package cn.elvea.lxp.core.system.service;

import cn.elvea.lxp.common.service.BaseAmqpService;
import cn.elvea.lxp.core.system.dto.UserSessionDto;

/**
 * UserSessionAmqpService
 *
 * @author elvea
 */
public interface UserSessionAmqpService extends BaseAmqpService {

    /**
     * 保存用户会话记录
     */
    void saveUserSession(UserSessionDto userSessionDto);

}
