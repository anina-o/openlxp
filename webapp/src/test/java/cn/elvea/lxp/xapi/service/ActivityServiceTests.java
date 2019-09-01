package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.model.Activity;
import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AgentServiceTests
 *
 * @author elvea
 */
public class ActivityServiceTests extends BaseXapiTests {

    @Autowired
    private ActivityService activityService;

    @Test
    public void agentTests() {
        String activityId = defaultActivityId;
        Activity activity = this.activityService.getActivities(activityId);
        Assertions.assertNotNull(activity);
    }

}
