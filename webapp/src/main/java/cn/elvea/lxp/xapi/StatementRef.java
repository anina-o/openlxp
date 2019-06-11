package cn.elvea.lxp.xapi;

import cn.elvea.lxp.xapi.json.JsonMapper;
import cn.elvea.lxp.xapi.json.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

import static cn.elvea.lxp.xapi.XApiConstants.OBJECT_TYPE_STATEMENT_REF;

/**
 * Statement References
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StatementRef implements XApiObject {
    /**
     * objectType
     */
    private final String objectType = OBJECT_TYPE_STATEMENT_REF;
    /**
     * ID
     */
    private UUID id;

    public StatementRef(JsonNode jsonNode) {
        JsonNode idNode = jsonNode.path("id");
        if (!idNode.isMissingNode()) {
            this.setId(UUID.fromString(idNode.textValue()));
        }
    }

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        ObjectNode node = JsonMapper.getInstance().createObjectNode();
        node.put("objectType", this.objectType);
        node.put("id", this.getId().toString());
        return node;
    }

}
