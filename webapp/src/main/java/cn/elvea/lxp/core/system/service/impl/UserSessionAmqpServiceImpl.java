package cn.elvea.lxp.core.system.service.impl;

import cn.elvea.lxp.common.service.BaseAmqpServiceImpl;
import cn.elvea.lxp.core.system.CoreConstants;
import cn.elvea.lxp.core.system.dto.UserSessionDto;
import cn.elvea.lxp.core.system.service.UserSessionAmqpService;
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
@RabbitListener(queues = CoreConstants.QUEUE_USER_SESSION)
public class UserSessionAmqpServiceImpl extends BaseAmqpServiceImpl<UserSessionDto> implements UserSessionAmqpService {

    private UserSessionService userSessionService;

    @Override
    public void saveUserSession(UserSessionDto userSessionDto) {
        if (isAmqpEnable()) {
            this.rabbitTemplate.convertAndSend(CoreConstants.QUEUE_USER_SESSION, userSessionDto);
        } else {
            execute(userSessionDto);
        }
    }

    @Override
    public void execute(UserSessionDto userSessionDto) {
        this.userSessionService.saveUserSession(userSessionDto);
    }

    @Autowired
    public void setUserSessionService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

}
