package cn.elvea.lxp.xapi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static cn.elvea.lxp.xapi.utils.XApiConstants.OBJECT_TYPE_ACTIVITY;

/**
 * ActivityEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "openlxp_activity")
public class ActivityEntity extends BaseEntity {
    /**
     * Object Type
     */
    private String objectType = OBJECT_TYPE_ACTIVITY;
    /**
     *
     */
    @Field("id")
    private String id;
}
