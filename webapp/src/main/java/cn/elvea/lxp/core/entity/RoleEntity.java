package cn.elvea.lxp.core.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 角色
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
public class RoleEntity extends BaseEntity {
    /**
     * 编号
     */
    private String code;
    /**
     * 多语言文本
     */
    private String label;
    /**
     * 标题
     */
    private String title;
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
