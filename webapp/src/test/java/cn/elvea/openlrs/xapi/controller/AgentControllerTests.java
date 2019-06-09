package cn.elvea.openlrs.xapi.controller;

import cn.elvea.openlrs.BaseWebTests;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * AgentControllerTests
 *
 * @author elvea
 */
public class AgentControllerTests extends BaseWebTests {

    @Test
    public void testGetActivites() throws Exception {
        mockMvc.perform(get("/xAPI/agents")
                .param("agent", "{}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.version").isArray())
        ;
    }

}
