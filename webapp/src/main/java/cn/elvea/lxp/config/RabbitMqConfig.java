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

    /**
     * 用户登录会话
     */
    @Bean
    public Queue userSessionQueue() {
        return new Queue(CoreConstants.QUEUE_USER_SESSION);
    }

    /**
     * 用户登录会话历史记录
     */
    @Bean
    public Queue userSessionHistoryQueue() {
        return new Queue(CoreConstants.QUEUE_USER_SESSION_HISTORY);
    }

    /**
     * 用户登录历史记录
     */
    @Bean
    public Queue userLoginHistoryQueue() {
        return new Queue(CoreConstants.QUEUE_USER_LOGIN_HISTORY);
    }

}
