package cn.elvea.lxp.modules.xapi.model;

import cn.elvea.lxp.modules.xapi.enums.XApiVersionEnum;
import cn.elvea.lxp.modules.xapi.json.JsonMapper;
import cn.elvea.lxp.modules.xapi.json.JsonObject;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * StatementsResult
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class StatementsResult implements AbstractJsonObject {
    /**
     * Statements
     */
    private List<Statement> statements = Lists.newArrayList();
    /**
     * URL
     */
    private String more;

    /**
     * @see JsonObject#toJsonNode(XApiVersionEnum)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersionEnum version) {
        ObjectNode node = JsonMapper.getInstance().createObjectNode();

        if (this.getStatements() != null) {
            ArrayNode statementsNode = JsonMapper.getInstance().createArrayNode();
            for (Statement statement : this.getStatements()) {
                statementsNode.add(statement.toJsonNode(version));
            }
            node.set("statements", statementsNode);
        }

        if (this.getMore() != null) {
            node.put("more", this.getMore());
        }
        return node;
    }

}
