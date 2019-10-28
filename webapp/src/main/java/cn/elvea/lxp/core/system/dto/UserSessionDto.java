package cn.elvea.lxp.core.system.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * UserSessionDto
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class UserSessionDto implements Serializable {
    /**
     * 租户ID
     */
    private Long tenantId;
    /**
     * 用户ID
     */
    private Long userId;
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
    /**
     * 辅助属性
     * 1. create - 新增会话
     * 2. update - 更新会话
     * 3. delete - 结束会话
     */
    @JsonIgnore
    private String action;

    public boolean isCreate() {
        return StringUtils.isNotEmpty(this.action)
                && this.action.equalsIgnoreCase("create");
    }

    public boolean isUpdate() {
        return StringUtils.isNotEmpty(this.action)
                && this.action.equalsIgnoreCase("update");
    }

    public boolean isDelete() {
        return StringUtils.isNotEmpty(this.action)
                && this.action.equalsIgnoreCase("delete");
    }
}
