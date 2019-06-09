package cn.elvea.openlrs.xapi;

import cn.elvea.openlrs.xapi.json.JsonMapper;
import cn.elvea.openlrs.xapi.json.JsonObject;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static cn.elvea.openlrs.xapi.XApiConstants.*;

/**
 * XApiStatement
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public abstract class XApiStatement implements XApiJsonObject {
    /**
     *
     */
    private Actor actor;
    /**
     *
     */
    private Verb verb;
    /**
     *
     */
    private XApiObject object;
    /**
     *
     */
    private Result result;
    /**
     *
     */
    private Context context;
    /**
     *
     */
    private DateTime timestamp;
    /**
     *
     */
    private List<Attachment> attachments;

    public XApiStatement(String json) throws IOException, URISyntaxException, NoSuchAlgorithmException {
        this(JsonMapper.toJsonNode(json));
    }

    public XApiStatement(JsonNode jsonNode) throws URISyntaxException, MalformedURLException, IOException, NoSuchAlgorithmException {
        this();

        JsonNode actorNode = jsonNode.path("actor");
        if (!actorNode.isMissingNode()) {
            this.setActor(Agent.fromJsonNode(actorNode));
        }

        JsonNode verbNode = jsonNode.path("verb");
        if (!verbNode.isMissingNode()) {
            this.setVerb(new Verb(verbNode));
        }

        JsonNode objectNode = jsonNode.path("object");
        if (!objectNode.isMissingNode()) {
            String objectType = objectNode.path("objectType").textValue();
            if (OBJECT_TYPE_AGENT.equals(objectType) || OBJECT_TYPE_GROUP.equals(objectType)) {
                this.setObject(Agent.fromJsonNode(objectNode));
            } else if (OBJECT_TYPE_STATEMENT_REF.equals(objectType)) {
                this.setObject(new StatementRef(objectNode));
            } else if (OBJECT_TYPE_SUBSTATEMENT.equals(objectType)) {
                this.setObject(new SubStatement(objectNode));
            } else {
                this.setObject(new Activity(objectNode));
            }
        }

        JsonNode resultNode = jsonNode.path("result");
        if (!resultNode.isMissingNode()) {
            this.setResult(new Result(resultNode));
        }

        JsonNode contextNode = jsonNode.path("context");
        if (!contextNode.isMissingNode()) {
            this.setContext(new Context(contextNode));
        }

        JsonNode timestampNode = jsonNode.path("timestamp");
        if (!timestampNode.isMissingNode()) {
            this.setTimestamp(new DateTime(timestampNode.textValue()));
        }

        JsonNode attachmentsNode = jsonNode.path("attachments");
        if (!attachmentsNode.isMissingNode()) {
            this.attachments = Lists.newArrayList();
            for (JsonNode element : attachmentsNode) {
                this.attachments.add(new Attachment(element));
            }
        }

    }

    public XApiStatement(Agent actor, Verb verb, XApiObject object, Result result, Context context) {
        this();

        this.setActor(actor);
        this.setVerb(verb);
        this.setObject(object);
        this.setResult(result);
        this.setContext(context);
    }

    public XApiStatement(Agent actor, Verb verb, XApiObject object) {
        this(actor, verb, object, null, null);
    }

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        ObjectNode node = JsonMapper.getInstance().createObjectNode();
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime().withZoneUTC();

        node.set("actor", this.getActor().toJsonNode(version));
        node.set("verb", this.getVerb().toJsonNode(version));
        node.set("object", this.getObject().toJsonNode(version));
        if (this.result != null) {
            node.set("result", this.getResult().toJsonNode(version));
        }
        if (this.context != null) {
            node.set("context", this.getContext().toJsonNode(version));
        }
        if (this.timestamp != null) {
            node.put("timestamp", fmt.print(this.getTimestamp()));
        }
        if (this.getAttachments() != null && this.getAttachments().size() > 0) {
            ArrayNode attachmentsNode = JsonMapper.getInstance().createArrayNode();
            for (Attachment attachment : this.getAttachments()) {
                attachmentsNode.add(attachment.toJsonNode(version));
            }
            node.set("attachments", attachmentsNode);
        }

        return node;
    }

}
