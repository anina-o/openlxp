package cn.elvea.lxp.common.web.jackson;

import cn.elvea.lxp.common.utils.DateUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * TimestampDeserializer
 *
 * @author elvea
 */
public class TimestampDeserializer extends JsonDeserializer<Timestamp> {

    /**
     * @see JsonDeserializer#deserialize(JsonParser, DeserializationContext)
     */
    @Override
    public Timestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return new Timestamp(DateUtils.parseTimestamp(p.getValueAsString()).getTime());
    }

}
