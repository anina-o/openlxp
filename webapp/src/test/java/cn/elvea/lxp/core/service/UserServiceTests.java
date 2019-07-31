package cn.elvea.lxp.core.service;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.core.dto.UserDto;
import cn.elvea.lxp.core.form.Register;
import org.apache.commons.lang3.RandomStringUtils;
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
    void findTest() {
        UserDto userDtoByUsername = this.userService.findByUsername("admin");
        Assertions.assertNotNull(userDtoByUsername);
        UserDto userDtoById = this.userService.findById(1L);
        Assertions.assertNotNull(userDtoById);
    }

    @Test
    void registerTest() {
        String username = RandomStringUtils.randomAlphabetic(6);

        Register register = new Register();
        register.setUsername(username);
        register.setPassword("123456");
        this.userService.register(register);

        UserDto userDto = this.userService.findByUsername(username);
        Assertions.assertNotNull(userDto);
    }

}
