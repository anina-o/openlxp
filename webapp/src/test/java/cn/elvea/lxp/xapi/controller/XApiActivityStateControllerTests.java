package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Agent Profile ResourceEntity
 *
 * @author elvea
 */
public class XApiActivityStateControllerTests extends BaseXapiTests {

    @Test
    public void baseTests() throws Exception {
        mockMvc.perform(
                put("/xAPI/activites/state")
                        .param("agent", getMboxAgent().toJson())
                        .param("stateId", defaultStateId)
                        .param("activityId", defaultActivityId)
                        .content(getDefaultAgent().toJson())
        ).andExpect(status().isOk());

        mockMvc.perform(
                post("/xAPI/activites/state")
                        .param("agent", getMboxAgent().toJson())
                        .param("stateId", defaultStateId)
                        .param("activityId", defaultActivityId)
                        .content(getMboxAgent().toJson())
        ).andExpect(status().isOk());

        mockMvc.perform(
                get("/xAPI/activites/state")
                        .param("agent", getMboxAgent().toJson())
                        .param("stateId", defaultStateId)
                        .param("activityId", defaultActivityId)
                        .content(getMboxAgent().toJson())
        ).andExpect(status().isOk());

        mockMvc.perform(
                delete("/xAPI/activites/state")
                        .param("agent", getMboxAgent().toJson())
                        .param("stateId", defaultStateId)
                        .param("activityId", defaultActivityId)
                        .content(getMboxAgent().toJson())
        ).andExpect(status().isOk());

    }

}
