package cn.elvea.lxp.xapi.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ActivityStateEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "openlxp_activity_state")
public class ActivityStateEntity {
}
