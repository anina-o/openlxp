package cn.elvea.lxp.xapi.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * XAPITestUtils
 *
 * @author elvea
 */
public class XApiUtilsTests {

    @Test
    public void parseTest() {
        String str = "2019-01-01 00:00:00";
        Date date = XApiUtils.parseTimestamp(str);
        Assertions.assertNotNull(date);

        str = "2019-01-01T13:14:15+0800";
        date = XApiUtils.parseTimestamp(str);
        Assertions.assertNotNull(date);
    }

    @Test
    public void uuidTest() {
        String uuid = XApiUtils.randomUUID();
        Assertions.assertNotNull(uuid);
    }

}
