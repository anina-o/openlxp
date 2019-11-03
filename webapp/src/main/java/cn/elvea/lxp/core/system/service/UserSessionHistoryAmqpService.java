package cn.elvea.lxp.core.system.service;

import cn.elvea.lxp.common.service.BaseAmqpService;
import cn.elvea.lxp.core.system.dto.UserSessionHistoryDto;

/**
 * UserSessionHistoryAmqpService
 *
 * @author elvea
 */
public interface UserSessionHistoryAmqpService extends BaseAmqpService {

    /**
     * 用户会话历史记录表
     */
    void saveUserSessionHistory(UserSessionHistoryDto userSessionHistoryDto);

}
