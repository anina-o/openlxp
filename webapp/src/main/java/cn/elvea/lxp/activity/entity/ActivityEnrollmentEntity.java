package cn.elvea.lxp.activity.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 课程报名实体
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_course_enrollment")
public class ActivityEnrollmentEntity extends BaseEntity {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 课程ID
     */
    private Long courseId;
    /**
     * 报名日期
     */
    private Date enrollDatetime;
    /**
     * 报名状态
     */
    private String enrollStatus;
    /**
     * 首次访问时间
     */
    private Date commenceDatetime;
    /**
     * 最近访问时间
     */
    private Date lastAccessDatetime;
    /**
     * 尝试总次数
     */
    private Long totalAttempt;
    /**
     * 学习总时长
     */
    private Long totalTime;
    /**
     * 完成时间
     */
    private Date completeDatetime;
    /**
     * 完成状态
     */
    private String completeStatus;
    /**
     * 分数
     */
    private Float score;
    /**
     * 启用状态
     */
    private Boolean active;
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
    /**
     * 删除时间
     */
    private Date deletedAt;
    /**
     * 删除人
     */
    private Long deletedBy;
}
