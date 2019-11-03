package cn.elvea.lxp.core.system.service.impl;

import cn.elvea.lxp.common.service.BaseAmqpServiceImpl;
import cn.elvea.lxp.core.system.CoreConstants;
import cn.elvea.lxp.core.system.dto.UserSessionHistoryDto;
import cn.elvea.lxp.core.system.service.UserSessionHistoryAmqpService;
import cn.elvea.lxp.core.system.service.UserSessionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserSessionAmqpServiceImpl
 *
 * @author elvea
 */
@Service
@RabbitListener(queues = CoreConstants.QUEUE_USER_SESSION_HISTORY)
public class UserSessionHistoryAmqpServiceImpl extends BaseAmqpServiceImpl<UserSessionHistoryDto> implements UserSessionHistoryAmqpService {

    private UserSessionService userSessionService;

    @Override
    public void saveUserSessionHistory(UserSessionHistoryDto userSessionHistoryDto) {
        if (isAmqpEnable()) {
            this.rabbitTemplate.convertAndSend(CoreConstants.QUEUE_USER_SESSION_HISTORY, userSessionHistoryDto);
        } else {
            execute(userSessionHistoryDto);
        }
    }

    @Override
    public void execute(UserSessionHistoryDto userSessionHistoryDto) {
        this.userSessionService.saveUserSessionHistory(userSessionHistoryDto);
    }

    @Autowired
    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

}
