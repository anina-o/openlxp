package cn.elvea.lxp.core.system.service;

import cn.elvea.lxp.common.service.BaseAmqpService;
import cn.elvea.lxp.core.system.dto.UserLoginHistoryDto;

/**
 * UserSessionAmqpService
 *
 * @author elvea
 */
public interface UserLoginHistoryAmqpService extends BaseAmqpService {

    /**
     * 保存用户登录历史记录
     */
    void saveUserLoginHistory(UserLoginHistoryDto userLoginHistoryDto);

}
