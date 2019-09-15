package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;

import static cn.elvea.lxp.xapi.utils.XApiConstants.XAPI_CONTENT_TYPE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Agent Profile ResourceEntity
 *
 * @author elvea
 */
public class XApiActivityProfileControllerTests extends BaseXapiTests {

    @Test
    public void testPut() throws Exception {
        mockMvc.perform(
                put("/xAPI/activites/profile")
                        .param("activityId", defaultActivityId)
                        .param("profileId", defaultProfileId)
                        .content(getDefaultAgent().toJson()))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(
                post("/xAPI/activites/profile")
                        .param("activityId", defaultActivityId)
                        .param("profileId", defaultProfileId)
                        .content(getMboxAgent().toJson()))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(
                get("/xAPI/activites/profile")
                        .param("activityId", defaultActivityId)
                        .param("profileId", defaultProfileId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(XAPI_CONTENT_TYPE))
                .andExpect(jsonPath("$.data").value(getMboxAgent().toJson()));
        
        mockMvc.perform(
                delete("/xAPI/activites/profile")
                        .param("activityId", defaultActivityId)
                        .param("profileId", defaultProfileId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(XAPI_CONTENT_TYPE));
    }

}
