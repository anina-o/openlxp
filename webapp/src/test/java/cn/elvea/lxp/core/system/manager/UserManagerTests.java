package cn.elvea.lxp.core.system.manager;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.core.system.entity.UserEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserManagerTests
 *
 * @author elvea
 */
public class UserManagerTests extends BaseTests {

    @Autowired
    private UserManager userManager;

    @Test
    public void baseTest() {
        UserEntity userEntityFindByUsername = this.userManager.findUserByUsername("admin");
        UserEntity userEntityFindByEmail = this.userManager.findUserByEmail("master@elvea.cn");
        UserEntity userEntityFindByMobile = this.userManager.findUserByMobile("13800138000");
        UserEntity userEntityFindById = this.userManager.findUserById(1L);
        Assertions.assertNotNull(userEntityFindByUsername);
        Assertions.assertNotNull(userEntityFindByEmail);
        Assertions.assertNotNull(userEntityFindByMobile);
        Assertions.assertNotNull(userEntityFindById);
    }

}
