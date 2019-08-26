package cn.elvea.lxp.xapi.entity;

import cn.elvea.lxp.xapi.Account;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import static cn.elvea.lxp.xapi.utils.XApiConstants.OBJECT_TYPE_AGENT;

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
