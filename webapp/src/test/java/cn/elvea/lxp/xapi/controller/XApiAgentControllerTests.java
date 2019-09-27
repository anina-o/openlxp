package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.BaseXapiTests;
import cn.elvea.lxp.xapi.model.Agent;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;

import static cn.elvea.lxp.xapi.utils.XApiConstants.XAPI_CONTENT_TYPE;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * AgentControllerTests
 *
 * @author elvea
 */
public class XApiAgentControllerTests extends BaseXapiTests {

    @Test
    public void accountTests() throws Exception {
        Agent accountAgent = getDefaultAgent();
        String accountAgentJson = accountAgent.toJson();
        MvcResult accountResult = mockMvc.perform(get("/xAPI/agents")
                .param("agent", accountAgentJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(XAPI_CONTENT_TYPE))
                .andExpect(jsonPath("$.data.objectType")
                        .value("Person"))
                .andExpect(jsonPath("$.data.name",
                        hasItem(accountAgent.getName())))
                .andExpect(jsonPath("$.data.account[0].name")
                        .value(accountAgent.getAccount().getName()))
                .andExpect(jsonPath("$.data.account[0].homePage")
                        .value(accountAgent.getAccount().getHomePage()))
                .andReturn();
        System.out.println(accountResult.getResponse().getContentAsString());
    }

    @Test
    public void openIDTests() throws Exception {
        Agent openIdAgent = getOpenIdAgent();
        String openIdAgentJson = openIdAgent.toJson();
        MvcResult openIdResult = mockMvc.perform(get("/xAPI/agents")
                .param("agent", openIdAgentJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(XAPI_CONTENT_TYPE))
                .andExpect(jsonPath("$.data.objectType")
                        .value("Person"))
                .andExpect(jsonPath("$.data.name",
                        hasItem(openIdAgent.getName())))
                .andExpect(jsonPath("$.data.openid",
                        hasItem(openIdAgent.getOpenID())))
                .andReturn();
        System.out.println(openIdResult.getResponse().getContentAsString());
    }

    @Test
    public void mboxTests() throws Exception {
        Agent mboxAgent = getMboxAgent();
        String mboxAgentJson = mboxAgent.toJson();
        MvcResult mboxResult = mockMvc.perform(get("/xAPI/agents")
                .param("agent", mboxAgentJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(XAPI_CONTENT_TYPE))
                .andExpect(jsonPath("$.data.objectType")
                        .value("Person"))
                .andExpect(jsonPath("$.data.name",
                        hasItem(mboxAgent.getName())))
                .andExpect(jsonPath("$.data.mbox",
                        hasItem(mboxAgent.getMbox())))
                .andReturn();
        System.out.println(mboxResult.getResponse().getContentAsString());
    }

    @Test
    public void mboxSha1Tests() throws Exception {
        Agent mboxSha1Agent = getMboxSha1Agent();
        String mboxSha1AgentJson = mboxSha1Agent.toJson();
        MvcResult mboxSha1AgentResult = mockMvc.perform(get("/xAPI/agents")
                .param("agent", mboxSha1AgentJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(XAPI_CONTENT_TYPE))
                .andExpect(jsonPath("$.data.objectType")
                        .value("Person"))
                .andExpect(jsonPath("$.data.name",
                        hasItem(mboxSha1Agent.getName())))
                .andExpect(jsonPath("$.data.mbox_sha1sum",
                        hasItem(mboxSha1Agent.getMboxSHA1Sum())))
                .andReturn();
        System.out.println(mboxSha1AgentResult.getResponse().getContentAsString());
    }

}
