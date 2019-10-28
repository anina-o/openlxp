package cn.elvea.lxp.core.system.service.impl;

import cn.elvea.lxp.common.service.BaseAmqpServiceImpl;
import cn.elvea.lxp.core.system.CoreConstants;
import cn.elvea.lxp.core.system.dto.UserLoginHistoryDto;
import cn.elvea.lxp.core.system.service.UserLoginHistoryAmqpService;
import cn.elvea.lxp.core.system.service.UserSessionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserLoginHistoryAmqpServiceImpl
 *
 * @author elvea
 */
@Service
@RabbitListener(queues = CoreConstants.QUEUE_USER_LOGIN_HISTORY)
public class UserLoginHistoryAmqpServiceImpl extends BaseAmqpServiceImpl<UserLoginHistoryDto> implements UserLoginHistoryAmqpService {

    private UserSessionService userSessionService;

    @Override
    public void saveUserLoginHistory(UserLoginHistoryDto userLoginHistoryDto) {
        if (isAmqpEnable()) {
            this.rabbitTemplate.convertAndSend(CoreConstants.QUEUE_USER_LOGIN_HISTORY, userLoginHistoryDto);
        } else {
            execute(userLoginHistoryDto);
        }
    }

    @Override
    public void execute(UserLoginHistoryDto userLoginHistoryDto) {
        this.userSessionService.saveUserLoginHistory(userLoginHistoryDto);
    }

    @Autowired
    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

}
