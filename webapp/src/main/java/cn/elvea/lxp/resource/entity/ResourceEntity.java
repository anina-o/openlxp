package cn.elvea.lxp.resource.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 课件实体
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_resource_type")
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
    private String publishStartDatetime;
    /**
     * 发布结束日期
     */
    private String publishEndDatetime;
    /**
     * 学习开始日期
     */
    private String startDatetime;
    /**
     * 学习结束日期
     */
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
    private String passScore;
    /**
     * 最大允许学习时长
     */
    private Integer timeLimit;
    /**
     * 最多允许尝试次数
     */
    private Integer attemptLimit;
    /**
     * 尝试次数计算策略
     */
    private Integer attemptPolicy;
    /**
     * 试卷生成策略
     */
    private Integer paper_generate_mode;
    /**
     * 是否允许暂停
     */
    private Boolean paperAllowPauseInd;
    /**
     * 答案显示形式
     */
    private Integer paperDisplayAnswerMode;
    /**
     * 试卷计分方式
     */
    private Integer paperScoreMode;
    /**
     * 试卷计分策略
     */
    private Integer paperScorePolicy;
    /**
     * 发布状态
     */
    private String status;
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
