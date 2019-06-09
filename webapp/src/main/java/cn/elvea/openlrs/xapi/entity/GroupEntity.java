package cn.elvea.openlrs.xapi.entity;

import cn.elvea.openlrs.xapi.Agent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import static cn.elvea.openlrs.xapi.XApiConstants.OBJECT_TYPE_GROUP;

/**
 * GroupEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document
public class GroupEntity extends BaseEntity {
    /**
     * Object Type
     */
    private String objectType = OBJECT_TYPE_GROUP;
    /**
     *
     */
    @DBRef
    private List<Agent> members;
}
