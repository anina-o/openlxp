package cn.elvea.lxp.core.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户会话实体
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_session")
public class UserSessionEntity extends BaseEntity {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 会话ID
     */
    private String sessionId;
    /**
     * Token
     */
    private String token;
    /**
     * 用户名
     */
    private String username;
    /**
     * 登录主机
     */
    private String host;
    /**
     * 登录设备
     */
    private String device;
    /**
     * 登录平台
     */
    private String platform;
    /**
     * 客户端版本
     */
    private String clientVersion;
    /**
     * 会话开始时间
     */
    private String startDatetime;
    /**
     * 最近访问时间
     */
    private String lastAccessDatetime;
    /**
     * 会话结束时间
     */
    private String endDatetime;
    /**
     * 会话开始年
     */
    private String startYear;
    /**
     * 会话开始月
     */
    private String startMonth;
    /**
     * 会话开始日
     */
    private String startDay;
    /**
     * 会话开始时
     */
    private String startHour;
    /**
     * 会话开始分
     */
    private String startMinute;
}
