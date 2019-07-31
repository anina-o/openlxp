package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.common.utils.IdWorker;
import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.type.UserStatusType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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
        String username = "username_" + randomUsername;
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username_" + randomUsername);
        userEntity.setFullname("fullname_" + randomUsername);
        userEntity.setNickname("nickname_" + randomUsername);
        userEntity.setActive(true);
        userEntity.setStatus(UserStatusType.OK.getValue());

        UserEntity entitySaved = this.userRepository.save(userEntity);
        Assertions.assertNotNull(userEntity.getId());
        Assertions.assertNotNull(entitySaved.getId());

        Optional<UserEntity> entityByUsername = this.userRepository.findByUsername(username);
        Assertions.assertTrue(entityByUsername.isPresent());

        Optional<UserEntity> entityById = this.userRepository.findById(userEntity.getId());
        Assertions.assertTrue(entityById.isPresent());

        this.userRepository.findById(userEntity.getId());
        this.userRepository.findByUsername(username);
        this.userRepository.clear();
        this.userRepository.findById(userEntity.getId());
        this.userRepository.findByUsername(username);
    }

}
