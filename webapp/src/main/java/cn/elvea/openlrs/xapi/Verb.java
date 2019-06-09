package cn.elvea.openlrs.xapi;

import cn.elvea.openlrs.xapi.json.JsonMapper;
import cn.elvea.openlrs.xapi.json.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Verb
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Verb implements XApiJsonObject {
    /**
     * IRI
     */
    private URI id;
    /**
     * Language Map
     */
    private LanguageMap display;

    public Verb(JsonNode jsonNode) throws URISyntaxException {
        this();

        JsonNode idNode = jsonNode.path("id");
        if (!idNode.isMissingNode()) {
            this.setId(new URI(idNode.textValue()));
        }

        JsonNode displayNode = jsonNode.path("display");
        if (!displayNode.isMissingNode()) {
            this.setDisplay(new LanguageMap(displayNode));
        }
    }

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        ObjectNode node = JsonMapper.getInstance().createObjectNode();
        if (this.id != null) {
            node.put("id", this.getId().toString());
        }
        if (this.display != null) {
            node.set("display", this.getDisplay().toJsonNode(version));
        }
        return node;
    }

}
