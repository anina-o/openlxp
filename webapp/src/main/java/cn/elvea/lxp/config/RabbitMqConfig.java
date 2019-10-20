package cn.elvea.lxp.config;

import cn.elvea.lxp.core.system.CoreConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息队列设置
 *
 * @author dfox
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue userSessionQueue() {
        return new Queue(CoreConstants.QUEUE_USER_SESSION);
    }

}
