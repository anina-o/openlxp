package cn.elvea.lxp.core.security;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.common.utils.IdWorker;
import cn.elvea.lxp.common.utils.UUIDUtils;
import com.google.common.collect.Lists;
import com.nimbusds.jose.JOSEException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * SecurityUtilsTests
 *
 * @author elvea
 */
public class SecurityUtilsTests extends BaseTests {

    @Autowired
    IdWorker idWorker;

    @Test
    public void randomSecretTest() {
        System.out.println(RandomStringUtils.randomAlphabetic(32));
    }

    @Test
    public void jwtTest() throws JOSEException {
        String uuid = UUIDUtils.randomUUID();
        SecurityUser securityUser = new SecurityUser("admin", "admin", true, Lists.newArrayList());
        securityUser.setId(idWorker.nextId());
        securityUser.setNickname("Administrator");
        securityUser.setEmail("admin@host.com");
        securityUser.setMobile("13800138000");
        String token = SecurityUtils.sign(uuid, securityUser);
        System.out.println(token);
    }

}
