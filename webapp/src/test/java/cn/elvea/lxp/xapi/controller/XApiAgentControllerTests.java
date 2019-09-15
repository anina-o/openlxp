package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.model.Agent;
import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;

import static cn.elvea.lxp.xapi.utils.XApiConstants.XAPI_CONTENT_TYPE;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * AgentControllerTests
 *
 * @author elvea
 */
public class XApiAgentControllerTests extends BaseXapiTests {

    @Test
    public void testGetActivites() throws Exception {
        Agent agent = getMboxAgent();
        String agentJson = agent.toJson();
        mockMvc.perform(get("/xAPI/agents")
                .param("agent", agentJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(XAPI_CONTENT_TYPE))
                .andExpect(jsonPath("$.data.name",
                        hasItem(agent.getName())))
                .andExpect(jsonPath("$.data.mbox",
                        hasItem(agent.getMbox())))
        ;
    }

}
