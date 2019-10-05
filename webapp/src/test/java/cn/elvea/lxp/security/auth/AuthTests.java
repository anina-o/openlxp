package cn.elvea.lxp.security.auth;

import cn.elvea.lxp.BaseWebTests;
import cn.elvea.lxp.security.SecurityConstants;
import cn.elvea.lxp.security.filter.SecurityAuthenticationFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static cn.elvea.lxp.common.Constants.CONTENT_TYPE_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * AuthTests
 *
 * @author elvea
 */
public class AuthTests extends BaseWebTests {

    @Autowired
    SecurityAuthenticationFilter securityAuthenticationFilter;

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(post(SecurityConstants.LOGIN_URL)
                .param(securityAuthenticationFilter.getUsernameParameter(), "admin")
                .param(securityAuthenticationFilter.getPasswordParameter(), "123456"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE_JSON))
                .andExpect(jsonPath("$.status").value("1"))
                .andExpect(jsonPath("$.data.token").exists())
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()));
    }

}
