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
     * 用户ID
     */
    private Long userId;
    /**
     * 年份
     */
    private Integer year;
    /**
     * 月份
     */
    private Integer month;
    /**
     * 日期
     */
    private Integer day;
    /**
     * 当天首次访问时间
     */
    private Date firstAccessDatetime;
    /**
     * 当天最后访问时间
     */
    private Date lastAccessDatetime;
    /**
     * 当天在线时长
     */
    private Long totalTime;
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
