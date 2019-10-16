package cn.elvea.lxp.resource.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 资源类型实体类
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_resource_type")
public class ResourceTypeEntity extends BaseEntity {
    /**
     * 类型
     */
    private String type;
    /**
     * 启用状态
     */
    private Boolean active;
}
