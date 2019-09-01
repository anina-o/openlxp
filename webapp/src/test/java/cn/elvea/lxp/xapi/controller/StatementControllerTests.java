package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.BaseXapiTests;
import cn.elvea.lxp.xapi.utils.XApiConstants;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * StatementControllerTests
 *
 * @author elvea
 */
public class StatementControllerTests extends BaseXapiTests {
    @Test
    public void testPut() throws Exception {
        Resource putResource = new ClassPathResource("/json/statement/statement-example-put.json");
        String putJson = FileUtils.readFileToString(putResource.getFile(), XApiConstants.ENCODING);
        mockMvc.perform(put("/xAPI/statements").content(putJson))
                .andExpect(status().isOk());

        Resource postResource = new ClassPathResource("/json/statement/statement-example-post.json");
        String postJson = FileUtils.readFileToString(postResource.getFile(), XApiConstants.ENCODING);
        mockMvc.perform(put("/xAPI/statements").content(postJson))
                .andExpect(status().isOk());
    }

    @Test
    public void testPost() throws Exception {

    }
}
