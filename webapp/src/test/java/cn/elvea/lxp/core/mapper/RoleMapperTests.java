package cn.elvea.lxp.core.mapper;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.common.utils.IdWorker;
import cn.elvea.lxp.core.entity.RoleEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UserRepositoryTests
 *
 * @author elvea
 */
public class RoleMapperTests extends BaseTests {

    @Autowired
    IdWorker idWorker;

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void baseCrudTests() {
        String randomString = String.valueOf(idWorker.nextId());
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setCode("code_" + randomString);
        roleEntity.setTitle("title_" + randomString);
        roleEntity.setActive(true);
        this.roleMapper.save(roleEntity);
        Assertions.assertNotNull(roleEntity.getId());

        Long id = roleEntity.getId();

        RoleEntity roleEntity2 = this.roleMapper.findById(id);
        Assertions.assertNotNull(roleEntity2);

        roleEntity2.setTitle("title_title_" + randomString);
        this.roleMapper.save(roleEntity);

        Assertions.assertEquals(roleEntity2.getTitle(), "title_title_" + randomString);
    }

}
