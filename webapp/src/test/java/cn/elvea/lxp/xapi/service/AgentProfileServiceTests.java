package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.BaseXapiTests;
import cn.elvea.lxp.xapi.utils.XApiUtils;
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
    public void getMultipleTests() {
        String since = "2019-01-01 00:00:00";
        //
        String profileId1 = "http://elvea.cn/profiles/1";
        String profileId2 = "http://elvea.cn/profiles/2";
        String profileId3 = "http://elvea.cn/profiles/3";
        //
        String agentJson = getDefaultAgent().toJson();
        String mboxAgentJson = getMboxAgent().toJson();
        String openIdAgentJson = getOpenIdAgent().toJson();
        // 新增第一条记录
        this.agentProfileService.saveAgentProfile(agentJson, profileId1, agentJson);
        // 保存第一条记录后获取当前时间
        String now = XApiUtils.formatTimestamp(new Date());
        // 再次保存两条记录
        this.agentProfileService.saveAgentProfile(agentJson, profileId2, mboxAgentJson);
        this.agentProfileService.saveAgentProfile(agentJson, profileId3, openIdAgentJson);
        this.agentProfileService.saveAgentProfile(mboxAgentJson, profileId2, mboxAgentJson);
        // 获取前面获取的当前时间后的记录数
        List<String> idsResult = this.agentProfileService.getAgentProfileIdList(agentJson, now);
        Assertions.assertEquals(idsResult.size(), 2);
        // 删除已有记录
        this.agentProfileService.deleteAgentProfile(agentJson, profileId1);
        this.agentProfileService.deleteAgentProfile(mboxAgentJson, profileId2);
        this.agentProfileService.deleteAgentProfile(agentJson, profileId2);
        this.agentProfileService.deleteAgentProfile(agentJson, profileId3);
    }

}
