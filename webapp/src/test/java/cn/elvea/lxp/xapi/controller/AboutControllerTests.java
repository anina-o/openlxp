package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.BaseWebTests;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * AboutControllerTests
 *
 * @author elvea
 */
public class AboutControllerTests extends BaseWebTests {

    @Test
    public void testGetAbout() throws Exception {
        mockMvc.perform(get("/xAPI/about"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.version").isArray())
        ;
    }

}
