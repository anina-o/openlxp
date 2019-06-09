package cn.elvea.openlrs.xapi.document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

/**
 * Document
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Document {

    /**
     * Set by Learning Record Provider,
     * unique within the scope of the Agent or Activity.
     */
    private String id;

    /**
     * When the document was most recently modified
     */
    private DateTime updated;

    /**
     * The contents of the document
     */
    private byte[] content;

}
