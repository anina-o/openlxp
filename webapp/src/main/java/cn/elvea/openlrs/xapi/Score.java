package cn.elvea.openlrs.xapi;

import cn.elvea.openlrs.xapi.json.JsonMapper;
import cn.elvea.openlrs.xapi.json.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Score
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Score implements XApiJsonObject {
    /**
     *
     */
    private Double scaled;
    /**
     *
     */
    private Double raw;
    /**
     *
     */
    private Double min;
    /**
     *
     */
    private Double max;

    public Score(JsonNode jsonNode) {
        this();

        JsonNode scaledNode = jsonNode.path("scaled");
        if (!scaledNode.isMissingNode()) {
            this.setScaled(scaledNode.doubleValue());
        }

        JsonNode rawNode = jsonNode.path("raw");
        if (!rawNode.isMissingNode()) {
            this.setRaw(rawNode.doubleValue());
        }

        JsonNode minNode = jsonNode.path("min");
        if (!minNode.isMissingNode()) {
            this.setMin(minNode.doubleValue());
        }

        JsonNode maxNode = jsonNode.path("max");
        if (!maxNode.isMissingNode()) {
            this.setMax(maxNode.doubleValue());
        }
    }

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        ObjectNode node = JsonMapper.getInstance().createObjectNode();

        if (this.scaled != null) {
            node.put("scaled", this.getScaled());
        }
        if (this.raw != null) {
            node.put("raw", this.getRaw());
        }
        if (this.min != null) {
            node.put("min", this.getMin());
        }
        if (this.max != null) {
            node.put("max", this.getMax());
        }

        return node;
    }
}