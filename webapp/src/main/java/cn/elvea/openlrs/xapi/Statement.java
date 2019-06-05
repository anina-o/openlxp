package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.UUID;

/**
 * Statement
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Statement {
    /**
     * objectType
     */
    private UUID id;
    /**
     * objectType
     */
    private DateTime stored;
    /**
     * objectType
     */
    private Actor authority;
    /**
     * objectType
     */
    private XAPIVersion version;
}
