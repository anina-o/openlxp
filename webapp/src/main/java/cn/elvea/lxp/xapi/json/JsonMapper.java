package cn.elvea.lxp.xapi.json;

import cn.elvea.lxp.xapi.exception.XAPIException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

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

    public static JsonNode toJsonNode(String json) throws XAPIException {
        try {
            return JsonMapper.getInstance().readValue(json, JsonNode.class);
        } catch (IOException e) {
            throw new XAPIException("");
        }
    }

}
