package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.BaseXapiTests;
import cn.elvea.lxp.xapi.utils.XApiUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * ActivityProfileServiceTests
 *
 * @author elvea
 */
public class ActivityProfileServiceTests extends BaseXapiTests {

    @Autowired
    private ActivityProfileService activityProfileService;

    @Test
    public void baseTests() {
        String since = "2019-01-01 00:00:00";
        //
        String activityId1 = "http://elvea.cn/activities/1";
        String activityId2 = "http://elvea.cn/activities/2";
        String activityId3 = "http://elvea.cn/activities/3";
        //
        String profileId1 = "http://elvea.cn/profiles/1";
        String profileId2 = "http://elvea.cn/profiles/2";
        String profileId3 = "http://elvea.cn/profiles/3";
        //
        String agentJson = getDefaultAgent().toJson();
        String mboxAgentJson = getMboxAgent().toJson();
        String openIdAgentJson = getOpenIdAgent().toJson();
        // 新增第一条记录
        this.activityProfileService.saveActivityProfile(activityId1, profileId1, agentJson);
        // 保存第一条记录后获取当前时间
        String now = XApiUtils.formatTimestamp(new Date());
        // 再次保存两条记录
        this.activityProfileService.saveActivityProfile(activityId1, profileId2, mboxAgentJson);
        this.activityProfileService.saveActivityProfile(activityId1, profileId3, openIdAgentJson);
        this.activityProfileService.saveActivityProfile(activityId2, profileId2, agentJson);
        this.activityProfileService.saveActivityProfile(activityId3, profileId2, agentJson);
        // 获取前面获取的当前时间后的记录数
        List<String> idsResult = this.activityProfileService.getActivityProfileIdList(activityId1, now);
        Assertions.assertEquals(idsResult.size(), 2);
    }

}
