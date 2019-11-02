package cn.elvea.lxp.modules.xapi.controller;

import cn.elvea.lxp.BaseWebTests;
import cn.elvea.lxp.modules.xapi.enums.XApiVersionEnum;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * AboutControllerTests
 *
 * @author elvea
 */
public class XApiAboutControllerTests extends BaseWebTests {

    @Test
    public void aboutTest() throws Exception {
        mockMvc.perform(get("/xAPI/about"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.data.version").isArray())
                .andExpect(jsonPath("$.data.version", hasItem(XApiVersionEnum.V103.getText())))
                .andExpect(jsonPath("$.data.version", hasItem(XApiVersionEnum.V102.getText())))
                .andExpect(jsonPath("$.data.version", hasItem(XApiVersionEnum.V101.getText())));
    }

}
