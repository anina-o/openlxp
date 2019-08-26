package cn.elvea.lxp.xapi;

import cn.elvea.lxp.xapi.json.JsonMapper;
import cn.elvea.lxp.xapi.utils.XApiVersion;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.Serializable;

/**
 * XApiJsonObject
 *
 * @author elvea
 */
public interface AbstractJsonObject extends Serializable {

    ObjectNode toJsonNode(XApiVersion version);

    default ObjectNode toJsonNode() {
        return this.toJsonNode(XApiVersion.latest());
    }

    default String toJson(XApiVersion version, Boolean pretty) {
        ObjectWriter writer = JsonMapper.getWriter(pretty);
        try {
            return writer.writeValueAsString(this.toJsonNode(version));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Exception in JSONBase Class: " + e.toString();
        }
    }

    default String toJson(XApiVersion version) {
        return this.toJson(version, true);
    }

    default String toJson(Boolean pretty) {
        return this.toJson(XApiVersion.latest(), pretty);
    }

    default String toJson() {
        return this.toJson(XApiVersion.latest(), true);
    }

}
