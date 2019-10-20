package cn.elvea.lxp.core.system.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * UserSessionStatisticsEntity
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_session_statistics")
public class UserSessionStatisticsEntity extends BaseEntity {
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
     * 首次访问时间
     */
    private Date firstAccessDatetime;
    /**
     * 最后访问时间
     */
    private Date lastAccessDatetime;
    /**
     * 总时长
     */
    private Long totalTime;
    /**
     * 年份
     */
    private Integer startYear;
    /**
     * 月份
     */
    private Integer startMonth;
    /**
     * 日期
     */
    private Integer startDay;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 创建人
     */
    private Long createdBy;
    /**
     * 更新时间
     */
    private Date modifiedAt;
    /**
     * 更新人
     */
    private Long modifiedBy;
}
