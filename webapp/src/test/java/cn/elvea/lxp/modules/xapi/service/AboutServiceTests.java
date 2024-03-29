package cn.elvea.lxp.modules.xapi.service;

import cn.elvea.lxp.modules.xapi.BaseXapiTests;
import cn.elvea.lxp.modules.xapi.enums.XApiVersionEnum;
import cn.elvea.lxp.modules.xapi.model.About;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * XapiServiceTests
 *
 * @author elvea
 */
public class AboutServiceTests extends BaseXapiTests {

    @Autowired
    private AboutService aboutService;

    @Test
    public void aboutTests() {
        About about = this.aboutService.about();
        Assertions.assertTrue(about.getVersion().contains(XApiVersionEnum.V103.getText()));
        Assertions.assertTrue(about.getVersion().contains(XApiVersionEnum.V102.getText()));
        Assertions.assertTrue(about.getVersion().contains(XApiVersionEnum.V101.getText()));
    }

}
