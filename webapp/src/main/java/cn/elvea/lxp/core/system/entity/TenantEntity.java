package cn.elvea.lxp.core.system.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 租户实体类
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class TenantEntity extends BaseEntity {
    /**
     * 编号
     */
    private String code;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 用户数限制
     */
    private Integer quota;
    /**
     * 有效期开始时间
     */
    private Date startDatetime;
    /**
     * 有效期结束时间
     */
    private Date endDatetime;
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
