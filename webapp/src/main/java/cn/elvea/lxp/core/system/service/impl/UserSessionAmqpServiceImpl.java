package cn.elvea.lxp.core.system.service.impl;

import cn.elvea.lxp.common.service.BaseAmqpServiceImpl;
import cn.elvea.lxp.core.system.CoreConstants;
import cn.elvea.lxp.core.system.dto.UserSessionDto;
import cn.elvea.lxp.core.system.service.UserSessionAmqpService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * UserSessionAmqpServiceImpl
 *
 * @author elvea
 */
@Service
@RabbitListener(queues = CoreConstants.QUEUE_USER_SESSION)
public class UserSessionAmqpServiceImpl extends BaseAmqpServiceImpl<UserSessionDto> implements UserSessionAmqpService {

    @Override
    public void execute(UserSessionDto userSessionDto) {
    }

}
