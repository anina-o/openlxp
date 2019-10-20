package cn.elvea.lxp.core.system.mapper;

import cn.elvea.lxp.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * RoleMapperTests
 *
 * @author elvea
 */
public class RoleMapperTests extends BaseTests {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void baseTests() {
        Assertions.assertNotNull(roleMapper);
    }

}
