package cn.elvea.lxp.security.auth;

import cn.elvea.lxp.BaseWebTests;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * AuthTests
 *
 * @author elvea
 */
public class AuthTests extends BaseWebTests {

    @Test
    public void testGetAbout() throws Exception {
        mockMvc.perform(post("/api/login")
                .param("username", "admin")
                .param("password", "123456"))
                .andExpect(status().isOk());
    }

}
