package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.BaseWebTests;
import cn.elvea.lxp.xapi.enums.VersionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;

import static cn.elvea.lxp.xapi.utils.XApiConstants.XAPI_CONTENT_TYPE;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * AboutControllerTests
 *
 * @author elvea
 */
public class XApiAboutControllerTests extends BaseWebTests {

    @Test
    public void aboutTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/xAPI/about"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(XAPI_CONTENT_TYPE))
                .andExpect(jsonPath("$.data.version").isArray())
                .andExpect(jsonPath("$.data.version",
                        hasItem(VersionEnum.V103.getText())))
                .andExpect(jsonPath("$.data.version",
                        hasItem(VersionEnum.V102.getText())))
                .andExpect(jsonPath("$.data.version",
                        hasItem(VersionEnum.V101.getText())))
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

}