package cn.elvea.lxp.core.manager;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.core.entity.UserEntity;
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
        UserEntity userEntityFindByUsername = this.userManager.findByUsername("admin");
        UserEntity userEntityFindById = this.userManager.findById(1L);
        System.out.println(1);
    }

}
