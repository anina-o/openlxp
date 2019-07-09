package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.common.utils.IdWorker;
import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.type.UserStatusType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserRepositoryTests
 *
 * @author elvea
 */
public class UserRepositoryTests extends BaseTests {

    @Autowired
    IdWorker idWorker;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void baseCrudTests() {
        String randomUsername = String.valueOf(idWorker.nextId());
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username_" + randomUsername);
        userEntity.setFullname("fullname_" + randomUsername);
        userEntity.setNickname("nickname_" + randomUsername);
        userEntity.setActive(true);
        userEntity.setStatus(UserStatusType.OK.getValue());
        this.userRepository.save(userEntity);
        Assertions.assertNotNull(userEntity.getId());
    }

}
