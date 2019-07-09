package cn.elvea.lxp.core.manager;

import cn.elvea.lxp.BaseTests;
import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserRoleRelationManagerTests
 *
 * @author elvea
 */
public class UserRoleRelationManagerTests extends BaseTests {

    @Autowired
    UserRoleRelationManager userRoleRelationManager;

    @Test
    public void crudTest() {
        userRoleRelationManager.assignRoles(1L, Lists.newArrayList(1L, 2L, 3L));
    }

}
