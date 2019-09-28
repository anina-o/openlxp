package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.common.utils.UUIDUtils;
import cn.elvea.lxp.xapi.BaseXapiTests;
import org.apache.commons.lang3.StringUtils;
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
    public void multipleGetAndDeleteTests() {
        String[] agentJsonList = new String[]{
                getMboxAgent().toJson(),
                getDefaultAgent().toJson(),
                getMboxSha1Agent().toJson(),
                getOpenIdAgent().toJson()
        };

        String activityId = "http://elvea.cn/activities/" + this.idWorker.nextId();
        String stateId1 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String stateId2 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String stateId3 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String stateId4 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String registration = UUIDUtils.randomUUID();

        for (String agentJson : agentJsonList) {
            this.activityStateService.saveActivityState(activityId, agentJson, registration, stateId1, agentJson);
            this.activityStateService.saveActivityState(activityId, agentJson, registration, stateId2, agentJson);
            this.activityStateService.saveActivityState(activityId, agentJson, null, stateId3, agentJson);
            this.activityStateService.saveActivityState(activityId, agentJson, null, stateId4, agentJson);

            List<String> stateIdList1 = this.activityStateService.getActivityStateList(activityId, agentJson, registration, null);
            Assertions.assertNotNull(stateIdList1);
            Assertions.assertEquals(2, stateIdList1.size());
            Assertions.assertTrue(stateIdList1.contains(stateId1));
            Assertions.assertTrue(stateIdList1.contains(stateId2));

            List<String> stateIdList2 = this.activityStateService.getActivityStateList(activityId, agentJson, null, null);
            Assertions.assertNotNull(stateIdList2);
            Assertions.assertEquals(4, stateIdList2.size());
            Assertions.assertTrue(stateIdList2.contains(stateId1));
            Assertions.assertTrue(stateIdList2.contains(stateId2));
            Assertions.assertTrue(stateIdList2.contains(stateId3));
            Assertions.assertTrue(stateIdList2.contains(stateId4));

            this.activityStateService.deleteActivityStateList(activityId, agentJson, registration, null);
            List<String> stateIdList3 = this.activityStateService.getActivityStateList(activityId, agentJson, registration, null);
            Assertions.assertNotNull(stateIdList3);
            Assertions.assertEquals(0, stateIdList3.size());

            this.activityStateService.deleteActivityStateList(activityId, agentJson, null, null);
            List<String> stateIdList4 = this.activityStateService.getActivityStateList(activityId, agentJson, null, null);
            Assertions.assertNotNull(stateIdList4);
            Assertions.assertEquals(0, stateIdList4.size());
        }
    }

    @Test
    public void baseTests() {
        String[] agentJsonList = new String[]{
                getMboxAgent().toJson(),
                getDefaultAgent().toJson(),
                getMboxSha1Agent().toJson(),
                getOpenIdAgent().toJson()
        };
        String contentJson1 = getMboxAgent().toJson();
        String contentJson2 = getMboxSha1Agent().toJson();
        String activityId = "http://elvea.cn/activities/" + this.idWorker.nextId();
        String stateId1 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String stateId2 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String registration = UUIDUtils.randomUUID();

        for (String agentJson : agentJsonList) {
            this.activityStateService.saveActivityState(activityId, agentJson, registration, stateId1, contentJson1);
            this.activityStateService.saveActivityState(activityId, agentJson, registration, stateId2, contentJson1);
            String content1 = this.activityStateService.getActivityState(activityId, agentJson, registration, stateId1);
            String content2 = this.activityStateService.getActivityState(activityId, agentJson, registration, stateId2);
            Assertions.assertNotNull(content1);
            Assertions.assertNotNull(content2);
            Assertions.assertEquals(contentJson1, content1);
            Assertions.assertEquals(contentJson1, content2);

            this.activityStateService.saveActivityState(activityId, agentJson, null, stateId1, contentJson2);
            this.activityStateService.saveActivityState(activityId, agentJson, null, stateId2, contentJson2);
            String content3 = this.activityStateService.getActivityState(activityId, agentJson, null, stateId1);
            String content4 = this.activityStateService.getActivityState(activityId, agentJson, null, stateId2);
            Assertions.assertNotNull(content3);
            Assertions.assertNotNull(content4);
            Assertions.assertEquals(contentJson2, content3);
            Assertions.assertEquals(contentJson2, content4);
            this.activityStateService.deleteActivityState(activityId, agentJson, stateId1, registration);
            this.activityStateService.deleteActivityState(activityId, agentJson, stateId2, registration);
            String content5 = this.activityStateService.getActivityState(activityId, agentJson, registration, stateId1);
            String content6 = this.activityStateService.getActivityState(activityId, agentJson, registration, stateId2);
            Assertions.assertTrue(StringUtils.isEmpty(content5));
            Assertions.assertTrue(StringUtils.isEmpty(content6));

            List<String> stateIdList1 = this.activityStateService.getActivityStateList(activityId, agentJson, registration, null);
            List<String> stateIdList2 = this.activityStateService.getActivityStateList(activityId, agentJson, null, null);
            Assertions.assertNotNull(stateIdList1);
            Assertions.assertNotNull(stateIdList2);
            Assertions.assertEquals(0, stateIdList1.size());
            Assertions.assertEquals(0, stateIdList2.size());
        }
    }

}
