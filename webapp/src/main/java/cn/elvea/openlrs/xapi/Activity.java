package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.net.URI;

/**
 * Activity
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Activity {
    /**
     *
     */
    private final String objectType = "Activity";
    /**
     *
     */
    private URI id;
    /**
     *
     */
    private ActivityDefinition definition;
}
