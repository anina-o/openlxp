package cn.elvea.lxp.xapi;

import cn.elvea.lxp.xapi.json.JsonMapper;
import cn.elvea.lxp.xapi.json.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.net.URISyntaxException;

import static cn.elvea.lxp.xapi.XApiConstants.OBJECT_TYPE_ACTIVITY;

/**
 * Activity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Activity implements XApiObject {
    /**
     *
     */
    private final String objectType = OBJECT_TYPE_ACTIVITY;
    /**
     *
     */
    private String id;
    /**
     *
     */
    private ActivityDefinition definition;

    public Activity(String id) {
        this.id = id;
    }

    public Activity(JsonNode jsonNode) throws URISyntaxException {
        this();

        JsonNode idNode = jsonNode.path("id");
        if (!idNode.isMissingNode()) {
            this.setId(idNode.textValue());
        }

        JsonNode definitionNode = jsonNode.path("definition");
        if (!definitionNode.isMissingNode()) {
            this.setDefinition(new ActivityDefinition(definitionNode));
        }
    }

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        ObjectNode node = JsonMapper.getInstance().createObjectNode();
        node.put("objectType", this.getObjectType());
        if (this.id != null) {
            node.put("id", this.getId().toString());
        }
        if (this.definition != null) {
            node.set("definition", this.getDefinition().toJsonNode());
        }
        return node;
    }

}
