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
 * XApiActivityStateControllerTests
 *
 * @author elvea
 */
public class XApiActivityStateControllerTests extends BaseXapiTests {

    @Test
    public void baseTests() throws Exception {
        String contentJson1 = getMboxAgent().toJson();
        String contentJson2 = getMboxSha1Agent().toJson();
        String[] agentJsonList = new String[]{
                getMboxAgent().toJson(),
                getDefaultAgent().toJson(),
                getMboxSha1Agent().toJson(),
                getOpenIdAgent().toJson()
        };
        String activityId = "http://elvea.cn/activities/" + this.idWorker.nextId();
        String stateId1 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String stateId2 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String registration = UUIDUtils.randomUUID();

        for (String agentJson : agentJsonList) {
            mockMvc.perform(put("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId1)
                    .param("registration", registration)
                    .param("activityId", activityId)
                    .content(contentJson1)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(put("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId2)
                    .param("registration", registration)
                    .param("activityId", activityId)
                    .content(contentJson1)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(get("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId1)
                    .param("registration", registration)
                    .param("activityId", activityId)
            ).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.data").value(contentJson1))
                    .andReturn();

            mockMvc.perform(get("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId2)
                    .param("registration", registration)
                    .param("activityId", activityId)
            ).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(XAPI_CONTENT_TYPE))
                    .andExpect(jsonPath("$.data").value(contentJson1))
                    .andReturn();

            mockMvc.perform(post("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId1)
                    .param("registration", registration)
                    .param("activityId", activityId)
                    .content(contentJson2)
            ).andExpect(status().isOk());

            mockMvc.perform(post("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId2)
                    .param("registration", registration)
                    .param("activityId", activityId)
                    .content(contentJson2)
            ).andExpect(status().isOk());

            mockMvc.perform(get("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId1)
                    .param("registration", registration)
                    .param("activityId", activityId)
            ).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.data").value(contentJson2))
                    .andReturn();

            mockMvc.perform(get("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId2)
                    .param("registration", registration)
                    .param("activityId", activityId)
            ).andDo(print()).andExpect(status().isOk())
                    .andExpect(jsonPath("$.data").value(contentJson2))
                    .andReturn();

            mockMvc.perform(delete("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId1)
                    .param("registration", registration)
                    .param("activityId", activityId)
            ).andExpect(status().isOk());

            mockMvc.perform(delete("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId2)
                    .param("registration", registration)
                    .param("activityId", activityId)
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
        String stateId1 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String stateId2 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String stateId3 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String stateId4 = "http://elvea.cn/states/" + this.idWorker.nextId();
        String registration = UUIDUtils.randomUUID();

        for (String agentJson : agentJsonList) {
            mockMvc.perform(put("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId1)
                    .param("registration", registration)
                    .param("activityId", activityId)
                    .content(agentJson)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(put("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId2)
                    .param("registration", registration)
                    .param("activityId", activityId)
                    .content(agentJson)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(put("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId3)
                    .param("activityId", activityId)
                    .content(agentJson)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(put("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("stateId", stateId4)
                    .param("activityId", activityId)
                    .content(agentJson)
            ).andDo(print()).andExpect(status().isOk());

            mockMvc.perform(get("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("activityId", activityId)
                    .param("registration", registration)
            ).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(XAPI_CONTENT_TYPE))
                    .andExpect(jsonPath("$.data", hasItem(stateId1)))
                    .andExpect(jsonPath("$.data", hasItem(stateId2)))
                    .andReturn();

            mockMvc.perform(get("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("activityId", activityId)
            ).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(XAPI_CONTENT_TYPE))
                    .andExpect(jsonPath("$.data", hasItem(stateId1)))
                    .andExpect(jsonPath("$.data", hasItem(stateId2)))
                    .andExpect(jsonPath("$.data", hasItem(stateId3)))
                    .andExpect(jsonPath("$.data", hasItem(stateId4)))
                    .andReturn();

            mockMvc.perform(delete("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("activityId", activityId)
                    .param("registration", registration)
            ).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(XAPI_CONTENT_TYPE)).andReturn();

            mockMvc.perform(get("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("activityId", activityId)
                    .param("registration", registration)
            ).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(XAPI_CONTENT_TYPE)).andReturn();

            mockMvc.perform(delete("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("activityId", activityId)
            ).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(XAPI_CONTENT_TYPE)).andReturn();

            mockMvc.perform(get("/xAPI/activites/state")
                    .param("agent", agentJson)
                    .param("activityId", activityId)
            ).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType(XAPI_CONTENT_TYPE)).andReturn();
        }
    }

}
