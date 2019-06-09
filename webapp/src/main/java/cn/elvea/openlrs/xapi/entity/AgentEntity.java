package cn.elvea.openlrs.xapi.entity;

import cn.elvea.openlrs.xapi.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import static cn.elvea.openlrs.xapi.XApiConstants.OBJECT_TYPE_AGENT;

/**
 * AgentEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document
public class AgentEntity extends BaseEntity {
    /**
     * Object Type
     */
    private String objectType = OBJECT_TYPE_AGENT;
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
}
