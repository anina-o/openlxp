package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Agent Profile ResourceEntity
 *
 * @author elvea
 */
public class AgentProfileControllerTests extends BaseXapiTests {

    @Test
    public void testPut() throws Exception {
        mockMvc.perform(
                put("/xAPI/agents/profile")
                        .param("agent", getMboxAgent().toJson())
                        .param("profileId", profileId)
                        .content(getMboxAgent().toJson())
        ).andExpect(status().isOk());
    }

}
