package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.List;

/**
 * AbstractStatement
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public abstract class AbstractStatement {
    /**
     *
     */
    private Agent actor;
    /**
     *
     */
    private Verb verb;
    /**
     *
     */
    private XAPIObject object;
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
