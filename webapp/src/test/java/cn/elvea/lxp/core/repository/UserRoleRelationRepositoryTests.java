package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.BaseTests;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * UserRepositoryTests
 *
 * @author elvea
 */
public class UserRoleRelationRepositoryTests extends BaseTests {

    @Autowired
    UserRoleRelationRepository userRoleRelationRepository;

    @Test
    public void baseTests() {
        List<Long> roleIdList = this.userRoleRelationRepository.findByUserId(1L);
        Assertions.assertTrue(CollectionUtils.isNotEmpty(roleIdList));
        List<Long> idList = this.userRoleRelationRepository.findByUserId(1L);
        Assertions.assertTrue(CollectionUtils.isNotEmpty(idList));
    }

}
