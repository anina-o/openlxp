package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Group
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Group extends Actor {
    /**
     *
     */
    private final String objectType = "Group";
    /**
     *
     */
    private String name;
    /**
     *
     */
    private List<Agent> members;
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
    private AgentAccount account;
}
