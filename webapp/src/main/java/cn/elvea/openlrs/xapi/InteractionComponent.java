package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * InteractionComponent
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class InteractionComponent {
    /**
     *
     */
    private String id;
    /**
     *
     */
    private LanguageMap description;
}
