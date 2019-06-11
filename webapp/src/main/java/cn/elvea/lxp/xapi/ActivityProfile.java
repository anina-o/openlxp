package cn.elvea.lxp.xapi;

import cn.elvea.lxp.xapi.json.JsonObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ActivityProfile
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ActivityProfile implements Serializable {
    /**
     *
     */
    private String activityId;
    /**
     *
     */
    private String profileId;
    /**
     *
     */
    private JsonObject profile;
}
