package cn.elvea.lxp.xapi.entity;

import cn.elvea.lxp.xapi.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Statement
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "openlxp_statement")
public class StatementEntity implements Serializable {
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * Stored
     */
    private DateTime stored;
    /**
     * Authority
     */
    private Agent authority;
    /**
     * Version
     */
    private String version;
    /**
     *
     */
    private Actor actor;
    /**
     *
     */
    private Verb verb;
    /**
     *
     */
    private AbstractObject object;
    /**
     *
     */
    private Result result;
    /**
     *
     */
    private Context context;
    /**
     *
     */
    private DateTime timestamp;
    /**
     *
     */
    private List<Attachment> attachments;
}
