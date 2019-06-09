package cn.elvea.openlrs.xapi.json;

import cn.elvea.openlrs.xapi.XApiVersion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * AbstractJsonObject
 *
 * @author elvea
 */
@Slf4j
public abstract class AbstractJsonObject implements JsonObject, Serializable {

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public abstract ObjectNode toJsonNode(XApiVersion version);

    /**
     * @see JsonObject#toJsonNode()
     */
    @Override
    public ObjectNode toJsonNode() {
        return this.toJsonNode(XApiVersion.latest());
    }

    /**
     * @see JsonObject#toJson(XApiVersion, Boolean)
     */
    @Override
    public String toJson(XApiVersion version, Boolean pretty) {
        ObjectWriter writer = JsonMapper.getWriter(pretty);
        try {
            return writer.writeValueAsString(this.toJsonNode(version));
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException", e);
            return "Exception in JSONBase Class: " + e.toString();
        }
    }

    /**
     * @see JsonObject#toJson(XApiVersion)
     */
    @Override
    public String toJson(XApiVersion version) {
        return this.toJson(version, false);
    }

    /**
     * @see JsonObject#toJson(Boolean)
     */
    @Override
    public String toJson(Boolean pretty) {
        return this.toJson(XApiVersion.latest(), pretty);
    }

    /**
     * @see JsonObject#toJson()
     */
    @Override
    public String toJson() {
        return this.toJson(XApiVersion.latest(), false);
    }

}
