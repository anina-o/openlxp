package cn.elvea.lxp.core.mapper;

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
public class UserRoleRelationMapperTests extends BaseTests {

    @Autowired
    UserRoleRelationMapper userRoleRelationMapper;

    @Test
    public void baseTests() {
        List<Long> roleIdList = this.userRoleRelationMapper.findByUserId(1L);
        Assertions.assertTrue(CollectionUtils.isNotEmpty(roleIdList));
        List<Long> idList = this.userRoleRelationMapper.findByUserId(1L);
        Assertions.assertTrue(CollectionUtils.isNotEmpty(idList));
    }

}
