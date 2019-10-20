package cn.elvea.lxp.core.system.controller;

import cn.elvea.lxp.BaseWebTests;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * UserControllerTests
 *
 * @author elvea
 */
public class UserControllerTests extends BaseWebTests {

    @Test
    public void baseCrudTests() throws Exception {
        mockMvc.perform(post("/api/register")
                .param("username", "admin")
                .param("password", "123456"))
                .andExpect(status().isOk());
    }

}