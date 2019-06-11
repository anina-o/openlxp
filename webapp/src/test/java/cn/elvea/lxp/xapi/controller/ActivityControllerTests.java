package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.BaseWebTests;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ActivityControllerTests
 *
 * @author elvea
 */
public class ActivityControllerTests extends BaseWebTests {

    @Test
    public void testGetActivites() throws Exception {
        mockMvc.perform(get("/xAPI/activites")
                .param("activityId", "1"))
                .andExpect(status().isOk())
        ;
    }

}
