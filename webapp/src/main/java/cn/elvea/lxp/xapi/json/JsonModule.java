package cn.elvea.lxp.xapi.json;

import cn.elvea.lxp.xapi.XApiJsonObject;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * JsonModule
 *
 * @author elvea
 */
public class JsonModule {

    public static class Serializer extends JsonSerializer<XApiJsonObject> {
        @Override
        public void serialize(XApiJsonObject value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        }
    }

}
