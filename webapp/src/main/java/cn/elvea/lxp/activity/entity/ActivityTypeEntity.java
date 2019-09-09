package cn.elvea.lxp.activity.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 活动类型实体类
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_activity_type")
public class ActivityTypeEntity extends BaseEntity {
    /**
     * 类型
     */
    @Column
    private String type;
    /**
     * 启用状态
     */
    @Column
    private Boolean active;
}
