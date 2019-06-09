package cn.elvea.openlrs.xapi;

import cn.elvea.openlrs.xapi.json.JsonObject;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.UUID;

/**
 * Statement
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Statement extends XApiStatement {
    /**
     * ID
     */
    private UUID id;
    /**
     * Stored
     */
    private DateTime stored;
    /**
     * Authority
     */
    private Agent authority;
    /**
     * Version
     */
    private XApiVersion version;

    /**
     * @see JsonObject#toJsonNode(XApiVersion)
     */
    @Override
    public ObjectNode toJsonNode(XApiVersion version) {
        ObjectNode node = super.toJsonNode(version);
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime().withZoneUTC();

        if (this.id != null) {
            node.put("id", this.getId().toString());
        }
        if (this.stored != null) {
            node.put("stored", fmt.print(this.getStored()));
        }
        if (this.authority != null) {
            node.set("authority", this.getAuthority().toJsonNode(version));
        }
        return node;
    }

}
