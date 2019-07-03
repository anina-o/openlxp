package cn.elvea.lxp.common;

import cn.elvea.lxp.BaseTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ContextTests
 *
 * @author elvea
 */
@Slf4j
public class ContextTests extends BaseTests {

    @Autowired
    Context context;

    @Test
    public void getPropertyTest() {
        Assertions.assertTrue(this.context.getProperty("spring.cache.type").equalsIgnoreCase("redis"));
    }

    @Test
    public void getMessageTest() {
        String copyright = this.context.getMessage("site_copyright", new Object[]{"2019"});
        log.debug(copyright);
        Assertions.assertNotNull(copyright);
    }

}
