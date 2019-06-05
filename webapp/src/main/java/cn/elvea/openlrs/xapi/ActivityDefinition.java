package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.List;

/**
 * ActivityDefinition
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ActivityDefinition {
    /**
     *
     */
    private LanguageMap name;
    /**
     *
     */
    private LanguageMap description;
    /**
     *
     */
    private URI type;
    /**
     *
     */
    private URI moreInfo;
    /**
     *
     */
    private Extensions extensions;
    /**
     *
     */
    private InteractionType interactionType;
    /**
     *
     */
    private List<String> correctResponsesPattern;
    /**
     *
     */
    private List<InteractionComponent> choices;
    /**
     *
     */
    private List<InteractionComponent> scale;
    /**
     *
     */
    private List<InteractionComponent> source;
    /**
     *
     */
    private List<InteractionComponent> target;
    /**
     *
     */
    private List<InteractionComponent> steps;
}
