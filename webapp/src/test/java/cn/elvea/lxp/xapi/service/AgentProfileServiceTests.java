package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.BaseXapiTests;
import cn.elvea.lxp.xapi.utils.XApiUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * AgentProfileServiceTests
 *
 * @author elvea
 */
public class AgentProfileServiceTests extends BaseXapiTests {

    @Autowired
    private AgentProfileService agentProfileService;

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
        String profileId1 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String profileId2 = "http://elvea.cn/profiles/" + this.idWorker.nextId();

        for (String agentJson : agentJsonList) {
            // 先新增记录
            this.agentProfileService.saveAgentProfile(agentJson, profileId1, contentJson1);
            this.agentProfileService.saveAgentProfile(agentJson, profileId2, contentJson2);
            // 获取签名新增记录
            String content1 = this.agentProfileService.getAgentProfile(agentJson, profileId1);
            String content2 = this.agentProfileService.getAgentProfile(agentJson, profileId2);
            Assertions.assertNotNull(content1);
            Assertions.assertNotNull(content2);
            Assertions.assertEquals(contentJson1, content1);
            Assertions.assertEquals(contentJson2, content2);

            // 更新已有记录
            this.agentProfileService.saveAgentProfile(agentJson, profileId1, contentJson2);
            this.agentProfileService.saveAgentProfile(agentJson, profileId2, contentJson1);
            // 获取更新记录
            String content3 = this.agentProfileService.getAgentProfile(agentJson, profileId1);
            String content4 = this.agentProfileService.getAgentProfile(agentJson, profileId2);
            Assertions.assertNotNull(content3);
            Assertions.assertNotNull(content4);
            Assertions.assertEquals(contentJson2, content3);
            Assertions.assertEquals(contentJson1, content4);

            // 删除已添加记录
            this.agentProfileService.deleteAgentProfile(agentJson, profileId1);
            this.agentProfileService.deleteAgentProfile(agentJson, profileId2);
            // 查询记录
            String content5 = this.agentProfileService.getAgentProfile(agentJson, profileId1);
            String content6 = this.agentProfileService.getAgentProfile(agentJson, profileId2);
            Assertions.assertTrue(StringUtils.isEmpty(content5));
            Assertions.assertTrue(StringUtils.isEmpty(content6));

            List<String> profileIdList = this.agentProfileService.getAgentProfileList(agentJson, null);
            Assertions.assertNotNull(profileIdList);
            Assertions.assertEquals(0, profileIdList.size());
        }
    }

    @Test
    public void baseMultipleTests() {
        String[] agentJsonList = new String[]{
                getMboxAgent().toJson(),
                getDefaultAgent().toJson(),
                getMboxSha1Agent().toJson(),
                getOpenIdAgent().toJson()
        };

        List<String> profileIdList;
        for (String agentJson : agentJsonList) {
            String profileId1 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
            String profileId2 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
            String profileId3 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
            // 新增第一条记录
            Date date1 = new Date();
            this.agentProfileService.saveAgentProfile(agentJson, profileId1, agentJson);
            Date date2 = new Date();
            this.agentProfileService.saveAgentProfile(agentJson, profileId2, agentJson);
            Date date3 = new Date();
            this.agentProfileService.saveAgentProfile(agentJson, profileId3, agentJson);
            Date date4 = new Date();

            profileIdList = this.agentProfileService.getAgentProfileList(agentJson, null);
            Assertions.assertNotNull(profileIdList);
            Assertions.assertEquals(3, profileIdList.size());
            Assertions.assertTrue(profileIdList.contains(profileId1));
            Assertions.assertTrue(profileIdList.contains(profileId2));
            Assertions.assertTrue(profileIdList.contains(profileId3));

            profileIdList = this.agentProfileService.getAgentProfileList(agentJson, XApiUtils.formatTimestamp(date1));
            Assertions.assertNotNull(profileIdList);
            Assertions.assertEquals(3, profileIdList.size());
            Assertions.assertTrue(profileIdList.contains(profileId1));
            Assertions.assertTrue(profileIdList.contains(profileId2));
            Assertions.assertTrue(profileIdList.contains(profileId3));

            profileIdList = this.agentProfileService.getAgentProfileList(agentJson, XApiUtils.formatTimestamp(date2));
            Assertions.assertNotNull(profileIdList);
            Assertions.assertEquals(2, profileIdList.size());
            Assertions.assertTrue(profileIdList.contains(profileId2));
            Assertions.assertTrue(profileIdList.contains(profileId3));

            profileIdList = this.agentProfileService.getAgentProfileList(agentJson, XApiUtils.formatTimestamp(date3));
            Assertions.assertNotNull(profileIdList);
            Assertions.assertEquals(1, profileIdList.size());
            Assertions.assertTrue(profileIdList.contains(profileId3));

            profileIdList = this.agentProfileService.getAgentProfileList(agentJson, XApiUtils.formatTimestamp(date4));
            Assertions.assertNotNull(profileIdList);
            Assertions.assertEquals(0, profileIdList.size());

            this.agentProfileService.deleteAgentProfile(agentJson, profileId1);
            this.agentProfileService.deleteAgentProfile(agentJson, profileId2);
            this.agentProfileService.deleteAgentProfile(agentJson, profileId3);

            profileIdList = this.agentProfileService.getAgentProfileList(agentJson, null);
            Assertions.assertNotNull(profileIdList);
            Assertions.assertEquals(0, profileIdList.size());
        }
    }

}
