package cn.elvea.lxp.core.mapper;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.common.utils.IdWorker;
import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.type.UserStatusTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserRepositoryTests
 *
 * @author elvea
 */
public class UserMapperTests extends BaseTests {

    @Autowired
    IdWorker idWorker;

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void baseTests() {
        UserEntity userEntityFindByUsername = this.userMapper.findByUsername("admin");
        UserEntity userEntityFindById = this.userMapper.selectById(1L);
        System.out.println(1);
    }

    @Test
    public void baseCrudTests() {
        String randomUsername = String.valueOf(idWorker.nextId());
        String username = "username_" + randomUsername;
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username_" + randomUsername);
        userEntity.setFullname("fullname_" + randomUsername);
        userEntity.setNickname("nickname_" + randomUsername);
        userEntity.setActive(true);
        userEntity.setStatus(UserStatusTypeEnum.OK.getValue());

        this.userMapper.insert(userEntity);
        Assertions.assertNotNull(userEntity.getId());

        UserEntity entityByUsername = this.userMapper.findByUsername(username);
        Assertions.assertNotNull(entityByUsername);

        UserEntity entityById = this.userMapper.selectById(userEntity.getId());
        Assertions.assertNotNull(entityById);

        this.userMapper.selectById(userEntity.getId());
        this.userMapper.findByUsername(username);
        this.userMapper.selectById(userEntity.getId());
        this.userMapper.findByUsername(username);
    }

}
