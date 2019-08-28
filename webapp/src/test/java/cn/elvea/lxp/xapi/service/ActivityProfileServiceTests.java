package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ActivityProfileServiceTests
 *
 * @author elvea
 */
public class ActivityProfileServiceTests extends BaseXapiTests {

    @Autowired
    private ActivityProfileService activityProfileService;

    @Test
    public void crudTests() throws Exception {
        String agentJson = getDefaultAgent().toJson();
        String activityId = "http://elvea.cn/activities/1";
        String profileId = "http://elvea.cn/profiles/1";
        this.activityProfileService.saveActivityProfile(activityId, profileId, agentJson);
    }

}
