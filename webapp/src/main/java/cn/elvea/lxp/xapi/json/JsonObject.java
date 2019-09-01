package cn.elvea.lxp.xapi.json;

import cn.elvea.lxp.xapi.enums.VersionEnum;
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
     * @param version {@link VersionEnum}
     * @return {@link ObjectNode}
     */
    ObjectNode toJsonNode(VersionEnum version);

    /**
     * toJsonNode
     *
     * @return {@link ObjectNode}
     */
    ObjectNode toJsonNode();

    /**
     * toJson
     *
     * @param version {@link VersionEnum}
     * @param pretty  是否格式化
     * @return json
     */
    String toJson(VersionEnum version, Boolean pretty);

    /**
     * toJson
     *
     * @param version {@link VersionEnum}
     * @return json
     */
    String toJson(VersionEnum version);

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
