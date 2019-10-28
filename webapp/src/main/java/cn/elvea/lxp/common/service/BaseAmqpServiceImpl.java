package cn.elvea.lxp.common.service;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;

import java.io.IOException;

/**
 * 核心队列服务
 * 有关系统业务方便的通用封装在这个服务里面实现
 *
 * @author elvea
 */
@Slf4j
public abstract class BaseAmqpServiceImpl<T> implements BaseAmqpService {
    @Autowired
    protected RabbitTemplate rabbitTemplate;

    @RabbitHandler
    public void handler(T t, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        int i = 0;
        while (true) {
            try {
                execute(t);
                channel.basicAck(tag, false);
                break;
            } catch (Exception e) {
                log.error("mq error.", e);

                if (i++ >= 3) {
                    try {
                        channel.basicNack(tag, false, false);
                    } catch (IOException ee) {
                        log.error("mq error.", ee);
                    }
                    // 出现异常时
                    // 抛出这个异常告诉MQ不要重发
                    throw new AmqpRejectAndDontRequeueException(e.getMessage());
                } else {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /**
     * 用于子类中实现具体的业务
     *
     * @param t 消息内容
     */
    public abstract void execute(T t);

    /**
     * 是否全局启动AMQP队列
     */
    protected boolean isAmqpEnable() {
        return true;
    }

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

}
