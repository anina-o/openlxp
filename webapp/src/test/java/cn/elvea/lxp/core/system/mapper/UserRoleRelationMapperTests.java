package cn.elvea.lxp.core.system.mapper;

import cn.elvea.lxp.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserRoleRelationMapperTests
 *
 * @author elvea
 */
public class UserRoleRelationMapperTests extends BaseTests {

    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;

    @Test
    public void baseTests() {
        Assertions.assertNotNull(this.userRoleRelationMapper);
    }

}
