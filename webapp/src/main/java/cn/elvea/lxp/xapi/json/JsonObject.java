package cn.elvea.lxp.xapi.json;

import cn.elvea.lxp.xapi.utils.XApiVersion;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * XApiJsonObject
 *
 * @author elvea
 */
public interface JsonObject {

    /**
     * toJsonNode
     *
     * @param version {@link XApiVersion}
     * @return {@link ObjectNode}
     */
    ObjectNode toJsonNode(XApiVersion version);

    /**
     * toJsonNode
     *
     * @return {@link ObjectNode}
     */
    ObjectNode toJsonNode();

    /**
     * toJson
     *
     * @param version {@link XApiVersion}
     * @param pretty  是否格式化
     * @return json
     */
    String toJson(XApiVersion version, Boolean pretty);

    /**
     * toJson
     *
     * @param version {@link XApiVersion}
     * @return json
     */
    String toJson(XApiVersion version);

    /**
     * toJson
     *
     * @param pretty 是否格式化
     * @return json
     */
    String toJson(Boolean pretty);

    /**
     * toJson
     *
     * @return json
     */
    String toJson();

}
