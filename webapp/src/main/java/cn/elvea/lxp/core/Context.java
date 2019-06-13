package cn.elvea.lxp.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 全局上下文
 * 封装系统一些相对核心底层的基本操作
 * 1. 系统基础配置
 * 2. 获取多语言文本
 * 3. 获取配置文件里面的系统配置项
 * 4. 获取页面配置系统的设置
 *
 * @author elvea
 */
@Slf4j
@Component
public class Context implements InitializingBean {

    /**
     * 系统环境变量
     */
    private Environment env = null;

    /**
     * 多语言资源文件
     */
    private MessageSource messageSource;

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(this.env, "A Environment must be set");
        Assert.notNull(this.messageSource, "A MessageSource must be set");
    }

    @Lazy
    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @Lazy
    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Environment getEnv() {
        return env;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

}
