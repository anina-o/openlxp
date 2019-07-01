package cn.elvea.lxp.core.service;

import cn.elvea.lxp.BaseTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserServiceTests
 *
 * @author elvea
 */
public class UserServiceTests extends BaseTests {

    @Autowired
    UserService userService;

    @Test
    void findByUsernameTest() {
        this.userService.findByUsername("admin");
    }

}
