package cn.elvea.lxp.activity.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 课程实体
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_course")
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
    private String publishStartDatetime;
    /**
     * 发布结束日期
     */
    private String publishEndDatetime;
    /**
     * 报名开始日期
     */
    private String enrollStartDatetime;
    /**
     * 报名结束日期
     */
    private String enrollEndDatetime;
    /**
     * 学习开始日期
     */
    private String startDatetime;
    /**
     * 学习结束日期
     */
    private String endDatetime;
    /**
     * 用户状态
     */
    private Integer status;
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
