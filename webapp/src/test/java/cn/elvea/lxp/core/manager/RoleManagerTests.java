package cn.elvea.lxp.core.manager;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.common.utils.IdWorker;
import cn.elvea.lxp.core.entity.RoleEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * RoleManagerTests
 *
 * @author elvea
 */
public class RoleManagerTests extends BaseTests {

    @Autowired
    IdWorker idWorker;

    @Autowired
    RoleManager roleManager;

    @Test
    public void baseCrudTests() {
        String randomUsername = String.valueOf(idWorker.nextId());
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setCode("code_" + randomUsername);
        roleEntity.setTitle("title_" + randomUsername);
        roleEntity.setActive(true);
        this.roleManager.save(roleEntity);
        Assertions.assertNotNull(roleEntity.getId());

        RoleEntity newEntity = this.roleManager.findById(roleEntity.getId());
        Assertions.assertNotNull(newEntity.getId());
    }

}