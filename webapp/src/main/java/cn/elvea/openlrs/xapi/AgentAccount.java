package cn.elvea.openlrs.xapi;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * AgentAccount
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class AgentAccount {
    /**
     *
     */
    private String homePage;
    /**
     *
     */
    private String name;
}
