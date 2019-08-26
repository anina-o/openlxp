package cn.elvea.lxp.xapi;

import cn.elvea.lxp.xapi.json.JsonMapper;
import cn.elvea.lxp.xapi.json.JsonObject;
import cn.elvea.lxp.xapi.utils.XApiVersion;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Person
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Person implements AbstractJsonObject {
    /**
     *
     */
    protected final String objectType = "Person";
    /**
     *
     */
    private List<String> name;
    /**
     *
     */
    private List<String> mbox;
    /**
     *
     */
    private List<String> mbox_sha1sum;
    /**
     *
     */
    private List<String> openid;
    /**
     *
     */
    private List<Account> account;

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        ObjectNode node = JsonMapper.getInstance().createObjectNode();

        node.put("objectType", this.getObjectType());

        if (this.name != null && this.name.size() > 0) {
            ArrayNode name = JsonMapper.getInstance().createArrayNode();
            for (String element : this.getName()) {
                name.add(element);
            }
            node.set("name", name);
        }

        if (this.mbox != null && this.mbox.size() > 0) {
            ArrayNode mbox = JsonMapper.getInstance().createArrayNode();
            for (String element : this.getMbox()) {
                mbox.add(element);
            }
            node.set("mbox", mbox);
        }

        if (this.mbox_sha1sum != null && this.mbox_sha1sum.size() > 0) {
            ArrayNode mbox_sha1sum = JsonMapper.getInstance().createArrayNode();
            for (String element : this.getMbox_sha1sum()) {
                mbox_sha1sum.add(element);
            }
            node.set("mbox_sha1sum", mbox_sha1sum);
        }

        if (this.openid != null && this.openid.size() > 0) {
            ArrayNode openid = JsonMapper.getInstance().createArrayNode();
            for (String element : this.getOpenid()) {
                openid.add(element);
            }
            node.set("openid", openid);
        }

        if (this.account != null && this.account.size() > 0) {
            ArrayNode account = JsonMapper.getInstance().createArrayNode();
            for (Account element : this.getAccount()) {
                account.add(element.toJsonNode(version));
            }
            node.set("account", account);
        }

        return node;
    }
}
