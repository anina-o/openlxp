package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Verb {
    /**
     * IRI
     */
    private URI id;
    /**
     * Language Map
     */
    private Map<String, String> display;
}
