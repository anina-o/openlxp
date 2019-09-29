package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.BaseXapiTests;
import cn.elvea.lxp.xapi.enums.VersionEnum;
import cn.elvea.lxp.xapi.model.About;
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
        Assertions.assertTrue(about.getVersion().contains(VersionEnum.V103.getText()));
        Assertions.assertTrue(about.getVersion().contains(VersionEnum.V102.getText()));
        Assertions.assertTrue(about.getVersion().contains(VersionEnum.V101.getText()));
    }

}
