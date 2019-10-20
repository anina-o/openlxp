package cn.elvea.lxp.core.security.auth;

import cn.elvea.lxp.BaseWebTests;
import cn.elvea.lxp.core.security.SecurityConstants;
import cn.elvea.lxp.core.security.filter.SecurityAuthenticationFilter;
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
    public void testLoginByUsername() throws Exception {
        mockMvc.perform(post(SecurityConstants.LOGIN_URL)
                .param(securityAuthenticationFilter.getUsernameParameter(), "admin")
                .param(securityAuthenticationFilter.getPasswordParameter(), "123456"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE_JSON))
                .andExpect(jsonPath("$.status").value("1"))
                .andExpect(jsonPath("$.data.token").exists())
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()));
    }

    @Test
    public void testLoginByEmail() throws Exception {
        mockMvc.perform(post(SecurityConstants.LOGIN_URL)
                .param(securityAuthenticationFilter.getUsernameParameter(), "master@elvea.cn")
                .param(securityAuthenticationFilter.getPasswordParameter(), "123456"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE_JSON))
                .andExpect(jsonPath("$.status").value("1"))
                .andExpect(jsonPath("$.data.token").exists())
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()));
    }

    @Test
    public void testLoginByMobile() throws Exception {
        mockMvc.perform(post(SecurityConstants.LOGIN_URL)
                .param(securityAuthenticationFilter.getUsernameParameter(), "13800138000")
                .param(securityAuthenticationFilter.getPasswordParameter(), "123456"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE_JSON))
                .andExpect(jsonPath("$.status").value("1"))
                .andExpect(jsonPath("$.data.token").exists())
                .andDo(result -> System.out.println(result.getResponse().getContentAsString()));
    }

}
