package cn.elvea.lxp.core.system.service;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.core.system.dto.UserDto;
import cn.elvea.lxp.core.system.form.Register;
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
        UserDto userDtoByUsername = this.userService.findUserByUsername("admin");
        UserDto userDtoByEmail = this.userService.findUserByEmail("master@elvea.cn");
        UserDto userDtoByMobile = this.userService.findUserByMobile("13800138000");
        UserDto userDtoById = this.userService.findById(1L);
        Assertions.assertNotNull(userDtoById);
        Assertions.assertNotNull(userDtoByUsername);
        Assertions.assertNotNull(userDtoByEmail);
        Assertions.assertNotNull(userDtoByMobile);
    }

    @Test
    void registerTest() {
        String username = RandomStringUtils.randomAlphabetic(6);

        Register register = new Register();
        register.setUsername(username);
        register.setPassword("123456");
        this.userService.register(register);

        UserDto userDto = this.userService.findUserByUsername(username);
        Assertions.assertNotNull(userDto);
    }

}
