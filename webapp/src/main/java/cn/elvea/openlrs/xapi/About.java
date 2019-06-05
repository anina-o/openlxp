package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * About
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class About {
    /**
     *
     */
    private List<XAPIVersion> version;
    /**
     * {@link Extensions}
     */
    private Extensions extensions;
}
