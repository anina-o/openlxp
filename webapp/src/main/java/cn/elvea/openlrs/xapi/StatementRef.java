package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

/**
 * Statement References
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StatementRef {
    /**
     * objectType
     */
    private final String objectType = "StatementRef";
    /**
     * ID
     */
    private UUID id;
}
