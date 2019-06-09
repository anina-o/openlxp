package cn.elvea.openlrs.xapi;

import cn.elvea.openlrs.xapi.json.JsonMapper;
import cn.elvea.openlrs.xapi.json.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Maps;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Extensions
 *
 * @author elvea
 */
public class Extensions implements XApiJsonObject {

    private final HashMap<URI, JsonNode> _map = Maps.newHashMap();

    public Extensions(JsonNode jsonNode) throws URISyntaxException {
        Iterator<Map.Entry<String, JsonNode>> items = jsonNode.fields();
        while (items.hasNext()) {
            Map.Entry<String, JsonNode> item = items.next();
            this.put(new URI(item.getKey()), item.getValue());
        }
    }

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        return JsonMapper.getInstance().createObjectNode();
    }

    public Object put(URI key, JsonNode val) {
        return this._map.put(key, val);
    }

    public Object put(String key, JsonNode val) throws URISyntaxException {
        return this.put(new URI(key), val);
    }

    public Object put(URI key, Object val) {
        JsonNode storeVal = JsonMapper.getInstance().valueToTree(val);
        return this.put(key, storeVal);
    }

    public Object put(String key, Object val) throws URISyntaxException {
        return this.put(new URI(key), val);
    }

    public JsonNode get(URI key) {
        return this._map.get(key);
    }

    public JsonNode get(String key) throws URISyntaxException {
        return this.get(new URI(key));
    }

}
