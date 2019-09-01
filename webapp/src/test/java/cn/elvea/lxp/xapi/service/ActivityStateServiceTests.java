package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.common.utils.UUIDUtils;
import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * ActivityStateServiceTests
 *
 * @author elvea
 */
public class ActivityStateServiceTests extends BaseXapiTests {

    @Autowired
    private ActivityStateService activityStateService;

    @Test
    public void getMultipleTests() throws Exception {
        String activityId1 = "http://elvea.cn/activities/1";
        String activityId2 = "http://elvea.cn/activities/2";
        String activityId3 = "http://elvea.cn/activities/3";
        String stateId1 = "http://elvea.cn/states/1";
        String stateId2 = "http://elvea.cn/states/2";
        String stateId3 = "http://elvea.cn/states/3";
        //
        String agentJson = getDefaultAgent().toJson();
        String mboxAgentJson = getMboxAgent().toJson();
        String openIdAgentJson = getOpenIdAgent().toJson();
        //
        String reg = UUIDUtils.randomUUID();

        // put state
        this.activityStateService.saveActivityState(activityId1, agentJson, reg, stateId1, agentJson);
        this.activityStateService.saveActivityState(activityId2, mboxAgentJson, reg, stateId2, mboxAgentJson);
        this.activityStateService.saveActivityState(activityId3, openIdAgentJson, reg, stateId1, openIdAgentJson);
        this.activityStateService.saveActivityState(activityId3, openIdAgentJson, reg, stateId2, openIdAgentJson);
        this.activityStateService.saveActivityState(activityId3, openIdAgentJson, reg, stateId3, openIdAgentJson);

        // get states
        List<String> getResult = this.activityStateService.getActivityStateList(
                activityId3, openIdAgentJson, reg, null);
        Assertions.assertEquals(3, getResult.size());

        // post first state
        this.activityStateService.saveActivityState(
                activityId1, agentJson, reg, stateId1, mboxAgentJson);

        // get new first state
        String getStateResult = this.activityStateService.getActivityState(
                activityId1, mboxAgentJson, reg, stateId1, null);
        Assertions.assertEquals(getStateResult, mboxAgentJson);

        // delete first state
        this.activityStateService.deleteActivityState(
                activityId1, mboxAgentJson, stateId1, null);

        List<String> afterResult = this.activityStateService.getActivityStateList(
                activityId1, null, null, null);
        Assertions.assertEquals(afterResult.size(), 0);

        // delete all
        this.activityStateService.deleteActivityStateList(activityId2, null, null);
        this.activityStateService.deleteActivityStateList(activityId3, null, null);

        List<String> afterDelResult = this.activityStateService.getActivityStateList(
                activityId3, null, null, null);
        Assertions.assertEquals(afterDelResult.size(), 0);
    }

}
