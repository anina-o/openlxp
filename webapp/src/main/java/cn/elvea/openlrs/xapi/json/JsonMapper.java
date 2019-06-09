package cn.elvea.openlrs.xapi.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;

/**
 * JsonMapper
 *
 * @author elvea
 */
public class JsonMapper {

    private static final ObjectMapper instance = new ObjectMapper();

    public static ObjectMapper getInstance() {
        return instance;
    }

    public static ObjectWriter getWriter(Boolean pretty) {
        ObjectMapper mapper = getInstance();

        ObjectWriter writer;
        if (pretty) {
            writer = mapper.writer().withDefaultPrettyPrinter();
        } else {
            writer = mapper.writer();
        }

        return writer;
    }

    public static JsonNode toJsonNode(String json) throws IOException {
        if (Strings.isEmpty(json)) {
            return null;
        }
        return JsonMapper.getInstance().readValue(json, JsonNode.class);
    }

}
