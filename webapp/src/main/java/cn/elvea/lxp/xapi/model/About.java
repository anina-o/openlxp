package cn.elvea.lxp.xapi.model;

import cn.elvea.lxp.xapi.enums.VersionEnum;
import cn.elvea.lxp.xapi.json.JsonMapper;
import cn.elvea.lxp.xapi.json.JsonObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static cn.elvea.lxp.xapi.utils.XApiUtils.extensionsToJsonNode;
import static cn.elvea.lxp.xapi.utils.XApiUtils.jsonNodeToExtensions;

/**
 * About
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class About implements AbstractJsonObject {
    /**
     * xAPI versions this LRS supports
     */
    private List<String> version = Lists.newLinkedList();
    /**
     * A map of other properties as needed
     */
    private Map<String, String> extensions;

    public About() {
        this.version = VersionEnum.versions();
    }

    public About(JsonNode jsonNode) {
        if (jsonNode.hasNonNull("version")) {
            Iterator it = jsonNode.get("version").elements();
            while (it.hasNext()) {
                String version = VersionEnum.fromString(((JsonNode) it.next()).textValue()).getText();
                if (!this.version.contains(version)) {
                    this.version.add(version);
                }
            }
        }
        if (jsonNode.hasNonNull("extensions")) {
            this.extensions = jsonNodeToExtensions(jsonNode.get("extensions"));
        }
    }

    /**
     * @see JsonObject#toJsonNode(VersionEnum)
     */
    @Override
    public ObjectNode toJsonNode(VersionEnum version) {
        ObjectNode result = new ObjectNode(JsonMapper.getInstance().getNodeFactory());
        if (!this.version.isEmpty()) {
            ArrayNode versions = JsonMapper.getInstance().createArrayNode();
            for (String v : this.version) {
                versions.add(v);
            }
            result.set("version", versions);
        }
        if (!CollectionUtils.isEmpty(this.extensions)) {
            result.set("extensions", extensionsToJsonNode(extensions));
        }
        return result;
    }

}
