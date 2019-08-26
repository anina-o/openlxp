package cn.elvea.lxp.xapi;

import cn.elvea.lxp.xapi.json.JsonMapper;
import cn.elvea.lxp.xapi.json.JsonObject;
import cn.elvea.lxp.xapi.utils.XApiVersion;
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
     *
     */
    private List<XApiVersion> version = Lists.newArrayList();
    /**
     *
     */
    private Map<String, String> extensions;

    public About() {
        this.version = Lists.newArrayList(XApiVersion.values());
    }

    public About(JsonNode jsonNode) {
        if (jsonNode.hasNonNull("version")) {
            Iterator it = jsonNode.get("version").elements();
            while (it.hasNext()) {
                version.add(XApiVersion.fromString(((JsonNode) it.next()).textValue()));
            }
        }
        if (jsonNode.hasNonNull("extensions")) {
            this.extensions = jsonNodeToExtensions(jsonNode.get("extensions"));
        }
    }

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        ObjectNode result = new ObjectNode(JsonMapper.getInstance().getNodeFactory());
        if (!this.version.isEmpty()) {
            ArrayNode versions = JsonMapper.getInstance().createArrayNode();
            for (XApiVersion xapiVersion : this.getVersion()) {
                versions.add(xapiVersion.toString());
            }
            result.set("version", versions);
        }
        if (!CollectionUtils.isEmpty(this.extensions)) {
            result.set("extensions", extensionsToJsonNode(extensions));
        }
        return result;
    }

}
