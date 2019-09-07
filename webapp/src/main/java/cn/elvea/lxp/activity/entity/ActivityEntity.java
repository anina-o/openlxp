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
 * 课程实体
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_course")
@EntityListeners(AuditingEntityListener.class)
public class ActivityEntity extends BaseEntity {
    /**
     * 电子邮箱
     */
    private String code;
    /**
     * 手机号码
     */
    private String title;
    /**
     * 发布开始日期
     */
    @Column(name = "publish_start_datetime")
    private String publishStartDatetime;
    /**
     * 发布结束日期
     */
    @Column(name = "publish_end_datetime")
    private String publishEndDatetime;
    /**
     * 报名开始日期
     */
    @Column(name = "enroll_start_datetime")
    private String enrollStartDatetime;
    /**
     * 报名结束日期
     */
    @Column(name = "enroll_end_datetime")
    private String enrollEndDatetime;
    /**
     * 学习开始日期
     */
    @Column(name = "start_datetime")
    private String startDatetime;
    /**
     * 学习结束日期
     */
    @Column(name = "end_datetime")
    private String endDatetime;
    /**
     * 用户状态
     */
    private Integer status;
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
