package cn.elvea.lxp.xapi.entity.document;

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
@Document
public class ActivityStateEntity extends BaseDocumentEntity {
}
