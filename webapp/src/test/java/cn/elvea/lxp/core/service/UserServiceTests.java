package cn.elvea.lxp.core.service;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.core.dto.UserDto;
import org.junit.jupiter.api.Assertions;
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
        UserDto userDto = this.userService.findByUsername("admin");
        Assertions.assertNotNull(userDto);
    }

}
