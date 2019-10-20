package cn.elvea.lxp.core.system.mapper;

import cn.elvea.lxp.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserMapperTests
 *
 * @author elvea
 */
public class UserMapperTests extends BaseTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void baseTests() {
        Assertions.assertNotNull(userMapper);
    }

}
