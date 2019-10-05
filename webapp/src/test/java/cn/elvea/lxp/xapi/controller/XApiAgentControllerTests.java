package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.BaseXapiTests;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * XApiAgentControllerTests
 *
 * @author elvea
 */
public class XApiAgentControllerTests extends BaseXapiTests {

    @Test
    public void accountTests() throws Exception {
        mockMvc.perform(get("/xAPI/agents")
                .param("agent", getDefaultAgent().toJson()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.objectType").value("Person"))
                .andExpect(jsonPath("$.data.name", hasItem(getDefaultAgent().getName())))
                .andExpect(jsonPath("$.data.account[0].name").value(getDefaultAgent().getAccount().getName()))
                .andExpect(jsonPath("$.data.account[0].homePage").value(getDefaultAgent().getAccount().getHomePage()));
    }

    @Test
    public void openIDTests() throws Exception {
        mockMvc.perform(get("/xAPI/agents")
                .param("agent", getOpenIdAgent().toJson()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.objectType").value("Person"))
                .andExpect(jsonPath("$.data.name", hasItem(getOpenIdAgent().getName())))
                .andExpect(jsonPath("$.data.openid", hasItem(getOpenIdAgent().getOpenID())));
    }

    @Test
    public void mboxTests() throws Exception {
        mockMvc.perform(get("/xAPI/agents")
                .param("agent", getMboxAgent().toJson()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.objectType").value("Person"))
                .andExpect(jsonPath("$.data.name", hasItem(getMboxAgent().getName())))
                .andExpect(jsonPath("$.data.mbox", hasItem(getMboxAgent().getMbox())));
    }

    @Test
    public void mboxSha1Tests() throws Exception {
        mockMvc.perform(get("/xAPI/agents")
                .param("agent", getMboxSha1Agent().toJson()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.objectType").value("Person"))
                .andExpect(jsonPath("$.data.name", hasItem(getMboxSha1Agent().getName())))
                .andExpect(jsonPath("$.data.mbox_sha1sum", hasItem(getMboxSha1Agent().getMboxSHA1Sum())));
    }

}
