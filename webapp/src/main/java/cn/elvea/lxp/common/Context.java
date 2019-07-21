package cn.elvea.lxp.common;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Locale;

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
    private Environment env;

    /**
     * 多语言资源文件
     */
    private MessageSourceAccessor messages;

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(this.env, "A Environment must be set");
        Assert.notNull(this.messages, "A MessageSource must be set");
    }

    /**
     * 获取当前语言区域
     * 1. 用户已登录时取用户喜好设置的语言
     * 2. 用户未登录时返回默认语言
     *
     * @return Locale
     */
    public Locale getLocale() {
        return Constants.DEFAULT_LOCALE;
    }

    /**
     * 获取配置文件里面的配置项
     *
     * @param key 配置项
     * @return String
     */
    public String getProperty(String key) {
        return this.env.getProperty(key);
    }

    /**
     * 获取配置文件里面的配置项
     *
     * @param key          配置项
     * @param defaultValue 默认值
     * @return String
     */
    public String getProperty(String key, String defaultValue) {
        return this.env.getProperty(key, defaultValue);
    }

    /**
     * 获取配置文件里面的配置项
     *
     * @param key   配置项
     * @param clazz 返回值类型
     * @return T
     */
    public <T> T getProperty(String key, Class<T> clazz) {
        return this.env.getProperty(key, clazz);
    }

    /**
     * 获取配置文件里面的配置项
     *
     * @param key          配置项
     * @param clazz        返回值类型
     * @param defaultValue 默认值
     * @return T
     */
    public <T> T getProperty(String key, Class<T> clazz, T defaultValue) {
        return this.env.getProperty(key, clazz, defaultValue);
    }

    /**
     * 获取多语言文本
     *
     * @param code 文本编号
     * @return String
     */
    public String getMessage(String code) {
        return getMessage(code, getLocale());
    }

    /**
     * 获取多语言文本
     *
     * @param code   文本编号
     * @param locale 语言区域
     * @return String
     */
    public String getMessage(String code, Locale locale) {
        return this.messages.getMessage(code, locale);
    }

    /**
     * 获取多语言文本
     *
     * @param code 文本编号
     * @param args 文本参数
     * @return String
     */
    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, getLocale());
    }

    /**
     * 获取多语言文本
     *
     * @param code   文本编号
     * @param args   文本参数
     * @param locale 语言区域
     * @return String
     */
    public String getMessage(String code, Object[] args, Locale locale) {
        return messages.getMessage(code, args, locale);
    }

    /**
     * 获取多语言文本
     *
     * @param code           文本编号
     * @param args           文本参数
     * @param defaultMessage 默认文本
     * @return String
     */
    public String getMessage(String code, Object[] args, String defaultMessage) {
        return getMessage(code, args, defaultMessage, getLocale());
    }

    /**
     * 获取多语言文本
     *
     * @param code           文本编号
     * @param args           文本参数
     * @param defaultMessage 默认文本
     * @param locale         语言区域
     * @return String
     */
    public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
        return messages.getMessage(code, args, defaultMessage, locale);
    }

    /**
     * 获取当前日期
     */
    public Date getDate() {
        return new DateTime().toDate();
    }

    @Lazy
    @Autowired
    public void setEnv(@NotNull Environment env) {
        this.env = env;
    }

    @Lazy
    @Autowired
    public void setMessageSource(@NotNull MessageSource messageSource) {
        this.messages = new MessageSourceAccessor(messageSource);
    }

}
