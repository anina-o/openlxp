package cn.elvea.lxp.security.auth;

import cn.elvea.lxp.BaseWebTests;
import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * AuthTests
 *
 * @author elvea
 */
public class AuthTests extends BaseWebTests {

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(post("/api/login")
                .param("username", "admin")
                .param("password", "123456"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.status").value("1"))
                .andExpect(jsonPath("$.data.token").exists())
                .andDo(result -> {
                    System.out.println(result.getResponse().getContentAsString());
                });
    }

}
