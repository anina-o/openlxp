package cn.elvea.lxp.activity.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.Date;

/**
 * 课程报名实体
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_course_enrollment")
@EntityListeners(AuditingEntityListener.class)
public class ActivityEnrollmentEntity extends BaseEntity {
    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;
    /**
     * 课程ID
     */
    @Column(name = "course_id")
    private Long courseId;
    /**
     * 报名日期
     */
    @Column(name = "enroll_datetime")
    private Date enrollDatetime;
    /**
     * 报名状态
     */
    @Column(name = "enroll_status")
    private String enrollStatus;
    /**
     * 首次访问时间
     */
    @Column(name = "commence_datetime")
    private Date commenceDatetime;
    /**
     * 最近访问时间
     */
    @Column(name = "last_access_datetime")
    private Date lastAccessDatetime;
    /**
     * 尝试总次数
     */
    @Column(name = "total_attempt")
    private Long totalAttempt;
    /**
     * 学习总时长
     */
    @Column(name = "total_time")
    private Long totalTime;
    /**
     * 完成时间
     */
    @Column(name = "complete_datetime")
    private Date completeDatetime;
    /**
     * 完成状态
     */
    @Column(name = "complete_status")
    private String completeStatus;
    /**
     * 分数
     */
    @Column
    private Float score;
    /**
     * 启用状态
     */
    @Column
    private Boolean active;
    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;
    /**
     * 创建人
     */
    @CreatedBy
    @Column(name = "created_by")
    private Long createdBy;
    /**
     * 更新时间
     */
    @LastModifiedDate
    @Column(name = "modified_at")
    private Date modifiedAt;
    /**
     * 更新人
     */
    @LastModifiedBy
    @Column(name = "modified_by")
    private Long modifiedBy;
    /**
     * 删除时间
     */
    @Column(name = "deleted_at")
    private Date deletedAt;
    /**
     * 删除人
     */
    @Column(name = "deleted_by")
    private Long deletedBy;
}
