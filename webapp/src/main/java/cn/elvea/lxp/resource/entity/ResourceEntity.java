package cn.elvea.lxp.resource.entity;

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
 * 课件实体
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_resource")
@EntityListeners(AuditingEntityListener.class)
public class ResourceEntity extends BaseEntity {
    /**
     * 类型
     */
    private String type;
    /**
     * 编号
     */
    private String code;
    /**
     * 标题
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
     * URL
     */
    private String url;
    /**
     * 内容
     */
    private String content;
    /**
     * 分数
     */
    private String score;
    /**
     * 及格分数
     */
    @Column(name = "pass_score")
    private String passScore;
    /**
     * 最大允许学习时长
     */
    @Column(name = "time_limit")
    private Integer timeLimit;
    /**
     * 最多允许尝试次数
     */
    @Column(name = "attempt_limit")
    private Integer attemptLimit;
    /**
     * 尝试次数计算策略
     */
    @Column(name = "attempt_policy")
    private Integer attemptPolicy;
    /**
     * 试卷生成策略
     */
    @Column(name = "paper_generate_mode")
    private Integer paper_generate_mode;
    /**
     * 是否允许暂停
     */
    @Column(name = "paper_allow_pause_ind")
    private Boolean paperAllowPauseInd;
    /**
     * 答案显示形式
     */
    @Column(name = "paper_display_answer_mode")
    private Integer paperDisplayAnswerMode;
    /**
     * 试卷计分方式
     */
    @Column(name = "paper_score_mode")
    private Integer paperScoreMode;
    /**
     * 试卷计分策略
     */
    @Column(name = "paper_score_policy")
    private Integer paperScorePolicy;
    /**
     * 发布状态
     */
    @Column
    private String status;
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
