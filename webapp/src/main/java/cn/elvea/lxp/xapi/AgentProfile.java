package cn.elvea.lxp.xapi;

import cn.elvea.lxp.xapi.json.JsonObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * AgentProfile
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class AgentProfile implements Serializable {
    /**
     *
     */
    private Agent agent;
    /**
     *
     */
    private String profileId;
    /**
     *
     */
    private JsonObject profile;
}
