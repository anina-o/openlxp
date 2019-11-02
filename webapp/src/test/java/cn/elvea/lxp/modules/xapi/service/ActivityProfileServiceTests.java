package cn.elvea.lxp.modules.xapi.service;

import cn.elvea.lxp.modules.xapi.BaseXapiTests;
import cn.elvea.lxp.modules.xapi.utils.XApiUtils;
import org.apache.commons.lang3.StringUtils;
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
        String contentJson1 = getMboxAgent().toJson();
        String contentJson2 = getMboxSha1Agent().toJson();
        String activityId = "http://elvea.cn/activities/" + this.idWorker.nextId();
        String profileId1 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String profileId2 = "http://elvea.cn/profiles/" + this.idWorker.nextId();

        // 先新增记录
        this.activityProfileService.saveActivityProfile(activityId, profileId1, contentJson1);
        this.activityProfileService.saveActivityProfile(activityId, profileId2, contentJson2);
        // 获取签名新增记录
        String content1 = this.activityProfileService.getActivityProfile(activityId, profileId1);
        String content2 = this.activityProfileService.getActivityProfile(activityId, profileId2);
        Assertions.assertNotNull(content1);
        Assertions.assertNotNull(content2);
        Assertions.assertEquals(contentJson1, content1);
        Assertions.assertEquals(contentJson2, content2);

        // 更新已有记录
        this.activityProfileService.saveActivityProfile(activityId, profileId1, contentJson2);
        this.activityProfileService.saveActivityProfile(activityId, profileId2, contentJson1);
        // 获取更新记录
        String content3 = this.activityProfileService.getActivityProfile(activityId, profileId1);
        String content4 = this.activityProfileService.getActivityProfile(activityId, profileId2);
        Assertions.assertNotNull(content3);
        Assertions.assertNotNull(content4);
        Assertions.assertEquals(contentJson2, content3);
        Assertions.assertEquals(contentJson1, content4);

        // 删除已添加记录
        this.activityProfileService.deleteActivityProfile(activityId, profileId1);
        this.activityProfileService.deleteActivityProfile(activityId, profileId2);
        // 查询记录
        String content5 = this.activityProfileService.getActivityProfile(activityId, profileId1);
        String content6 = this.activityProfileService.getActivityProfile(activityId, profileId2);
        Assertions.assertTrue(StringUtils.isEmpty(content5));
        Assertions.assertTrue(StringUtils.isEmpty(content6));

        List<String> profileIdList = this.activityProfileService.getActivityProfileList(activityId, null);
        Assertions.assertNotNull(profileIdList);
        Assertions.assertEquals(0, profileIdList.size());

    }

    @Test
    public void baseMultipleTests() {
        String agentJson = getMboxAgent().toJson();
        String activityId = "http://elvea.cn/activities/" + this.idWorker.nextId();
        String profileId1 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String profileId2 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String profileId3 = "http://elvea.cn/profiles/" + this.idWorker.nextId();

        // 新增加记录，每增加一条记录前都记录当前时间方便后面查询
        Date date1 = new Date();
        this.activityProfileService.saveActivityProfile(activityId, profileId1, agentJson);
        Date date2 = new Date();
        this.activityProfileService.saveActivityProfile(activityId, profileId2, agentJson);
        Date date3 = new Date();
        this.activityProfileService.saveActivityProfile(activityId, profileId3, agentJson);
        Date date4 = new Date();

        List<String> profileIdList = this.activityProfileService.getActivityProfileList(activityId, null);
        Assertions.assertNotNull(profileIdList);
        Assertions.assertEquals(3, profileIdList.size());
        Assertions.assertTrue(profileIdList.contains(profileId1));
        Assertions.assertTrue(profileIdList.contains(profileId2));
        Assertions.assertTrue(profileIdList.contains(profileId3));

        profileIdList = this.activityProfileService.getActivityProfileList(activityId, XApiUtils.formatTimestamp(date1));
        Assertions.assertNotNull(profileIdList);
        Assertions.assertEquals(3, profileIdList.size());
        Assertions.assertTrue(profileIdList.contains(profileId1));
        Assertions.assertTrue(profileIdList.contains(profileId2));
        Assertions.assertTrue(profileIdList.contains(profileId3));

        profileIdList = this.activityProfileService.getActivityProfileList(activityId, XApiUtils.formatTimestamp(date2));
        Assertions.assertNotNull(profileIdList);
        Assertions.assertEquals(2, profileIdList.size());
        Assertions.assertTrue(profileIdList.contains(profileId2));
        Assertions.assertTrue(profileIdList.contains(profileId3));

        profileIdList = this.activityProfileService.getActivityProfileList(activityId, XApiUtils.formatTimestamp(date3));
        Assertions.assertNotNull(profileIdList);
        Assertions.assertEquals(1, profileIdList.size());
        Assertions.assertTrue(profileIdList.contains(profileId3));

        profileIdList = this.activityProfileService.getActivityProfileList(activityId, XApiUtils.formatTimestamp(date4));
        Assertions.assertNotNull(profileIdList);
        Assertions.assertEquals(0, profileIdList.size());

        this.activityProfileService.deleteActivityProfile(activityId, profileId1);
        this.activityProfileService.deleteActivityProfile(activityId, profileId2);
        this.activityProfileService.deleteActivityProfile(activityId, profileId3);

        profileIdList = this.activityProfileService.getActivityProfileList(activityId, null);
        Assertions.assertNotNull(profileIdList);
        Assertions.assertEquals(0, profileIdList.size());
    }

}
