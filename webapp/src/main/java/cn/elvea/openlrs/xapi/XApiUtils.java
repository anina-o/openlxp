package cn.elvea.openlrs.xapi;

import cn.elvea.openlrs.xapi.exception.XAPIException;
import cn.elvea.openlrs.xapi.json.JsonMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/**
 * XApiUtils
 */
public class XApiUtils {

    /**
     * 获取Agent的唯一标识标记
     *
     * @param agent {@link Agent}
     * @return 唯一标识标记
     */
    public static String extractAgentUniqueIdentifier(Agent agent) throws XAPIException {
        String uniqueIdentifier = null;
        if (agent != null && Strings.isNotEmpty(agent.getMbox())) {
            uniqueIdentifier = "mbox";
        } else if (agent != null && Strings.isNotEmpty(agent.getMboxSHA1Sum())) {
            uniqueIdentifier = "mboxSHA1Sum";
        } else if (agent != null && Strings.isNotEmpty(agent.getOpenID())) {
            uniqueIdentifier = "openID";
        } else if (agent != null && agent.getAccount() != null &&
                (Strings.isNotEmpty(agent.getAccount().getName()) && Strings.isNotEmpty(agent.getAccount().getHomePage()))) {
            uniqueIdentifier = "account";
        }
        if (Strings.isNotEmpty(uniqueIdentifier)) {
            return uniqueIdentifier;
        } else {
            throw new XAPIException("Invalid agent param.");
        }
    }

    /**
     * 从字符串获取Agent对象
     *
     * @param json String
     * @return {@link Agent}
     */
    public static Agent extractAgentObject(String json) throws XAPIException {
        try {
            return new Agent(JsonMapper.toJsonNode(json));
        } catch (IOException e) {
            throw new XAPIException("Invalid agent param.");
        }
    }

    public static Map<String, String> jsonNodeToExtensions(JsonNode jsonNode) {
        Map<String, String> extensions = Maps.newHashMap();
        Iterator<Map.Entry<String, JsonNode>> items = jsonNode.fields();
        while (items.hasNext()) {
            Map.Entry<String, JsonNode> item = items.next();
            extensions.put(item.getKey(), item.getValue().textValue());
        }
        return extensions;
    }

    public static ObjectNode extensionsToJsonNode(Map<String, String> extensions) {
        ObjectNode node = JsonMapper.getInstance().createObjectNode();
        for (Map.Entry<String, String> entry : extensions.entrySet()) {
            node.put(entry.getKey(), entry.getValue());
        }
        return node;
    }

}
