package cn.elvea.lxp.common.web.jackson;

import cn.elvea.lxp.common.utils.DateUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * DateDeserializer
 *
 * @author elvea
 */
public class DateDeserializer extends JsonDeserializer<Date> {

    /**
     * @see JsonDeserializer#deserialize(JsonParser, DeserializationContext)
     */
    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return DateUtils.parseTimestamp(p.getValueAsString());
    }

}
