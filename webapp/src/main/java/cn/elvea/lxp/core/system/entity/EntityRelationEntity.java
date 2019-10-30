package cn.elvea.lxp.core.system.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * ActorRelationEntity
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_entity_relation")
public class EntityRelationEntity extends BaseEntity {
    /**
     * 实体关联父ID
     */
    private Long parentId;
    /**
     * 实体关联子ID
     */
    private Long childId;
    /**
     * 实体关联是否直接关联
     */
    private Boolean parentInd;
    /**
     * 实体关联层级
     */
    private Integer idx;
    /**
     * 实体关联类型
     */
    private String type;
    /**
     * 实体关联完整路径
     */
    private String path;
    /**
     * 实体关联时间
     */
    private Date createdAt;
    /**
     * 实体关联人
     */
    private Long createdBy;
}
