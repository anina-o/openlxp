package cn.elvea.openlrs.xapi;

import cn.elvea.openlrs.xapi.json.JsonMapper;
import cn.elvea.openlrs.xapi.json.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

import static cn.elvea.openlrs.xapi.XApiConstants.OBJECT_TYPE_SUBSTATEMENT;

/**
 * SubStatement
 *
 * @author elveas
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SubStatement extends XApiStatement implements XApiObject {

    /**
     *
     */
    private final String objectType = OBJECT_TYPE_SUBSTATEMENT;

    public SubStatement(JsonNode jsonNode) throws MalformedURLException, URISyntaxException, IOException, NoSuchAlgorithmException {
        super(jsonNode);
    }

    public SubStatement(String json) throws Exception {
        super(JsonMapper.toJsonNode(json));
    }

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        ObjectNode node = super.toJsonNode(version);
        node.put("objectType", this.getObjectType());
        return node;
    }

}
