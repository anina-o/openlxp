package cn.elvea.lxp.xapi.model;

import cn.elvea.lxp.xapi.enums.VersionEnum;
import cn.elvea.lxp.xapi.json.JsonMapper;
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

    /**
     *
     */
    ObjectNode toJsonNode(VersionEnum version);

    /**
     *
     */
    default ObjectNode toJsonNode() {
        return this.toJsonNode(VersionEnum.latest());
    }

    /**
     *
     */
    default String toJson(VersionEnum version, Boolean pretty) {
        ObjectWriter writer = JsonMapper.getWriter(pretty);
        try {
            return writer.writeValueAsString(this.toJsonNode(version));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Exception in JSONBase Class: " + e.toString();
        }
    }

    /**
     * 按指定版本输出
     */
    default String toJson(VersionEnum version) {
        return this.toJson(version, true);
    }

    /**
     * 是否格式化
     */
    default String toJson(Boolean pretty) {
        return this.toJson(VersionEnum.latest(), pretty);
    }

    /**
     * 未指定版本时默认按最新版本输出
     */
    default String toJson() {
        return this.toJson(VersionEnum.latest(), true);
    }

}
