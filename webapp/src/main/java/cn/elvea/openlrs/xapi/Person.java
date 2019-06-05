package cn.elvea.openlrs.xapi;

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
public class Person {
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
    private List<AgentAccount> account;
}
