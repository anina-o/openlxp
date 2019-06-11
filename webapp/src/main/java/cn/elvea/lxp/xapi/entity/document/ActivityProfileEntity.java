package cn.elvea.lxp.xapi.entity.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ActivityEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document
public class ActivityProfileEntity extends BaseDocumentEntity {
    /**
     * ID
     */
    @Id
    String objectId;
}
