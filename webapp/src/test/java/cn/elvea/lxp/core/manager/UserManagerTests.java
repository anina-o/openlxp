package cn.elvea.lxp.core.manager;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.common.utils.IdWorker;
import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.type.UserStatusType;
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
    IdWorker idWorker;

    @Autowired
    UserManager userManager;

    @Test
    public void baseCrudTests() {
        String randomUsername = String.valueOf(idWorker.nextId());
        UserEntity userEntity = new UserEntity();
        userEntity.setId(idWorker.nextId());
        userEntity.setUsername("username_" + randomUsername);
        userEntity.setFullname("fullname_" + randomUsername);
        userEntity.setNickname("nickname_" + randomUsername);
        userEntity.setActive(true);
        userEntity.setStatus(UserStatusType.OK.getValue());
        this.userManager.save(userEntity);
        Assertions.assertNotNull(userEntity.getId());

        UserEntity newUserEntity = this.userManager.findById(userEntity.getId());
        Assertions.assertNotNull(newUserEntity.getId());
    }


}