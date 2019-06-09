package cn.elvea.openlrs.xapi;

import cn.elvea.openlrs.xapi.json.JsonMapper;
import cn.elvea.openlrs.xapi.json.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;

import static cn.elvea.openlrs.xapi.XApiConstants.OBJECT_TYPE_AGENT;
import static cn.elvea.openlrs.xapi.XApiConstants.OBJECT_TYPE_GROUP;

/**
 * XApiObject
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public abstract class Actor implements XApiObject {
    /**
     *
     */
    private String name;
    /**
     *
     */
    private String mbox;
    /**
     *
     */
    private String mboxSHA1Sum;
    /**
     *
     */
    private String openID;
    /**
     *
     */
    private Account account;

    public static Actor fromJson(String json) throws IOException {
        return fromJsonNode(JsonMapper.toJsonNode(json));
    }

    public static Actor fromJsonNode(JsonNode jsonNode) {
        String objectType = OBJECT_TYPE_AGENT;
        JsonNode objectTypeNode = jsonNode.path("objectType");
        if (!objectTypeNode.isMissingNode()) {
            objectType = objectTypeNode.textValue();
        }
        return OBJECT_TYPE_GROUP.equals(objectType) ? new Group(jsonNode) : new Agent(jsonNode);
    }

    public Actor(JsonNode jsonNode) {
        JsonNode nameNode = jsonNode.path("name");
        if (!nameNode.isMissingNode()) {
            this.setName(nameNode.textValue());
        }

        JsonNode mboxNode = jsonNode.path("mbox");
        if (!mboxNode.isMissingNode()) {
            this.setMbox(mboxNode.textValue());
        }

        JsonNode mboxSHA1SumNode = jsonNode.path("mbox_sha1sum");
        if (!mboxSHA1SumNode.isMissingNode()) {
            this.setMboxSHA1Sum(mboxSHA1SumNode.textValue());
        }

        JsonNode openIDNode = jsonNode.path("openid");
        if (!openIDNode.isMissingNode()) {
            this.setOpenID(openIDNode.textValue());
        }

        JsonNode acctNode = jsonNode.path("account");
        if (!acctNode.isMissingNode()) {
            this.setAccount(new Account(acctNode));
        }
    }

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        ObjectNode node = JsonMapper.getInstance().createObjectNode();
        node.put("objectType", this.getObjectType());
        if (Strings.isNotEmpty(this.getName())) {
            node.put("name", this.getName());
        }
        if (Strings.isNotEmpty(this.getMbox())) {
            node.put("mbox", this.getMbox());
        }
        if (Strings.isNotEmpty(this.getMboxSHA1Sum())) {
            node.put("mbox_sha1sum", this.getMboxSHA1Sum());
        }
        if (Strings.isNotEmpty(this.getOpenID())) {
            node.put("openid", this.getOpenID());
        }
        if (this.getAccount() != null) {
            node.set("account", this.getAccount().toJsonNode(version));
        }
        return node;
    }

}
