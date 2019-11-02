package cn.elvea.lxp.modules.xapi.controller;

import cn.elvea.lxp.modules.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * XApiActivityProfileControllerTests
 *
 * @author elvea
 */
public class XApiActivityProfileControllerTests extends BaseXapiTests {

    @Test
    public void baseTests() throws Exception {
        String contentJson1 = getMboxAgent().toJson();
        String contentJson2 = getMboxSha1Agent().toJson();
        String activityId = "http://elvea.cn/activities/" + this.idWorker.nextId();
        String profileId = "http://elvea.cn/profiles/" + this.idWorker.nextId();

        mockMvc.perform(put("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId)
                .content(contentJson1)
        ).andDo(print()).andExpect(status().isOk());

        mockMvc.perform(get("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId)
        ).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(contentJson1))
                .andReturn();

        mockMvc.perform(post("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId)
                .content(contentJson2)
        ).andExpect(status().isOk());

        mockMvc.perform(get("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId)
        ).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data").value(contentJson2))
                .andReturn();

        mockMvc.perform(delete("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId)
        ).andExpect(status().isOk());
    }

    @Test
    public void baseMultipleTests() throws Exception {
        String activityId = "http://elvea.cn/activities/" + this.idWorker.nextId();
        String profileId1 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String profileId2 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String profileId3 = "http://elvea.cn/profiles/" + this.idWorker.nextId();
        String agentJson = getMboxAgent().toJson();

        mockMvc.perform(put("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId1)
                .content(agentJson)
        ).andDo(print()).andExpect(status().isOk());

        mockMvc.perform(put("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId2)
                .content(agentJson)
        ).andDo(print()).andExpect(status().isOk());

        mockMvc.perform(put("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId3)
                .content(agentJson)
        ).andDo(print()).andExpect(status().isOk());

        mockMvc.perform(get("/xAPI/activities/profile")
                .param("activityId", activityId)
        ).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data", hasItem(profileId1)))
                .andExpect(jsonPath("$.data", hasItem(profileId2)))
                .andExpect(jsonPath("$.data", hasItem(profileId3)))
                .andReturn();

        mockMvc.perform(delete("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId1)
        ).andExpect(status().isOk());

        mockMvc.perform(delete("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId2)
        ).andExpect(status().isOk());

        mockMvc.perform(delete("/xAPI/activities/profile")
                .param("activityId", activityId)
                .param("profileId", profileId3)
        ).andExpect(status().isOk());
    }

}
