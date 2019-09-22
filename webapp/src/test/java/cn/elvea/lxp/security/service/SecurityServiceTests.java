package cn.elvea.lxp.security.service;

import cn.elvea.lxp.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SecurityServiceTests
 *
 * @author elvea
 */
public class SecurityServiceTests extends BaseTests {

    @Autowired
    SecurityUserService securityService;

    @Test
    public void encryptPasswordTest() {
        String presentedPassword = "123456";
        String encodedPassword = this.securityService.encryptPassword(presentedPassword);
        System.out.println("encodedPassword - " + encodedPassword);
        Assertions.assertTrue(this.securityService.isPasswordMatch(presentedPassword, encodedPassword));
    }

}
