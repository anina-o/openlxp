package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AgentProfileServiceTests
 *
 * @author elvea
 */
public class AgentProfileServiceTests extends BaseXapiTests {

    @Autowired
    private AgentProfileService agentProfileService;

    @Test
    public void crudTests() throws Exception {
        String agentJson = getDefaultAgent().toJson();
        String profileId = "http://elvea.cn/profiles/1";
        this.agentProfileService.saveAgentProfile(agentJson, profileId, agentJson);
    }

}
