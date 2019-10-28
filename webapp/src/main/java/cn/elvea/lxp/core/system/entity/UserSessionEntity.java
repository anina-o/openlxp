package cn.elvea.lxp.core.system.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

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
     * 租户ID
     */
    private String tenantId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 会话ID
     */
    private String sessionId;
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
    private String deviceModel;
    /**
     * 登录设备版本
     */
    private String deviceVersion;
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
    private Date startDatetime;
    /**
     * 最近访问时间
     */
    private Date lastAccessDatetime;
    /**
     * 会话结束时间
     */
    private Date endDatetime;
    /**
     * 会话开始年
     */
    private Integer year;
    /**
     * 会话开始月
     */
    private Integer month;
    /**
     * 会话开始日
     */
    private Integer day;
    /**
     * 会话开始时
     */
    private Integer hour;
    /**
     * 会话开始分
     */
    private Integer minute;
}
