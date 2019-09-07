package cn.elvea.lxp.resource.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 资源类型实体类
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_resource_type")
public class ResourceTypeEntity extends BaseEntity {
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
