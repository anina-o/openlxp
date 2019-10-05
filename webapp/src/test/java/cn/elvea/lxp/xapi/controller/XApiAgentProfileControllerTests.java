package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.common.utils.UUIDUtils;
import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;

import static cn.elvea.lxp.xapi.utils.XApiConstants.XAPI_CONTENT_TYPE;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * XApiAgentProfileControllerTests
 *
 * @author elvea
 */
public class XApiAgentProfileControllerTests extends BaseXapiTests {

    @Test
    public void baseTests() throws Exception {
        String[] agentJsonList = new String[]{
                getMboxAgent().toJson(),
                getDefaultAgent().toJson(),
                getMboxSha1Agent().toJson(),
                getOpenIdAgent().toJson()
        };
        String profileId = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String contentJson1 = getMboxAgent().toJson();
        String contentJson2 = getMboxSha1Agent().toJson();

        for (String agentJson : agentJsonList) {
            mockMvc.perform(put("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId)
                    .content(contentJson1)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(get("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId)
            ).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.data").value(contentJson1))
                    .andReturn();

            mockMvc.perform(post("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId)
                    .content(contentJson2)
            ).andExpect(status().isOk());

            mockMvc.perform(get("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId)
            ).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.data").value(contentJson2))
                    .andReturn();

            mockMvc.perform(delete("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId)
            ).andExpect(status().isOk());
        }
    }

    @Test
    public void baseMultipleTests() throws Exception {
        String[] agentJsonList = new String[]{
                getMboxAgent().toJson(),
                getDefaultAgent().toJson(),
                getMboxSha1Agent().toJson(),
                getOpenIdAgent().toJson()
        };

        String activityId = "http://elvea.cn/activities/" + this.idWorker.nextId();
        String profileId1 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String profileId2 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String profileId3 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String registration = UUIDUtils.randomUUID();

        for (String agentJson : agentJsonList) {
            mockMvc.perform(put("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId1)
                    .content(agentJson)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(put("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId2)
                    .content(agentJson)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(put("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId3)
                    .content(agentJson)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(get("/xAPI/agents/profile")
                    .param("agent", agentJson)
            ).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(XAPI_CONTENT_TYPE))
                    .andExpect(jsonPath("$.data", hasItem(profileId1)))
                    .andExpect(jsonPath("$.data", hasItem(profileId2)))
                    .andExpect(jsonPath("$.data", hasItem(profileId3)))
                    .andReturn();

            mockMvc.perform(delete("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId1)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(delete("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId2)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(delete("/xAPI/agents/profile")
                    .param("agent", agentJson)
                    .param("profileId", profileId3)
            ).andDo(print()).andExpect(status().isOk());
        }
    }

}
