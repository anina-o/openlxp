package cn.elvea.lxp.modules.xapi.controller;

import cn.elvea.lxp.modules.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * ActivityControllerTests
 *
 * @author elvea
 */
public class XApiActivityControllerTests extends BaseXapiTests {

    @Test
    public void testGetActivites() throws Exception {
        mockMvc.perform(get("/xAPI/activites")
                .param("activityId", defaultActivityId))
                .andDo(print())
                .andExpect(status().isOk())
        ;
    }

}
