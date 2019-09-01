package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.BaseXapiTests;
import cn.elvea.lxp.xapi.model.Statement;
import cn.elvea.lxp.xapi.utils.XApiConstants;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * StatementServiceTests
 *
 * @author elvea
 */
public class StatementServiceTests extends BaseXapiTests {
    @Autowired
    private StatementService statementService;

    @Test
    public void baseTest() throws Exception {
        String[] jsonFileList = {
                "/json/statement/statement-example-1.json",
                "/json/statement/statement-example-2.json",
        };
        for (String jsonFile : jsonFileList) {
            Resource resource = new ClassPathResource(jsonFile);
            String json = FileUtils.readFileToString(resource.getFile(), XApiConstants.ENCODING);
            Statement stmt = new Statement(json);
//            this.statementService.saveStatement(stmt);
        }
    }

}
