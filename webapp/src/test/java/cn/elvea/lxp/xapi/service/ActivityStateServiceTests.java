package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ActivityStateServiceTests
 *
 * @author elvea
 */
public class ActivityStateServiceTests extends BaseXapiTests {

    @Autowired
    private ActivityStateService activityStateService;

    @Test
    public void crudTests() throws Exception {
        String agentJson = getDefaultAgent().toJson();
        String activityId = "http://elvea.cn/activities/1";
        String stateId = "http://elvea.cn/states/1";

        this.activityStateService.saveActivityState(activityId, agentJson, null, stateId, agentJson);

    }

}
