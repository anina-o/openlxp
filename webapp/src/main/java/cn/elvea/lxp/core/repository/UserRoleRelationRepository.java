package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.UserRoleRelationEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static cn.elvea.lxp.core.CoreConstants.CACHE_USER_ROLE_KEY;

/**
 * UserRoleRelationRepository
 *
 * @author elvea
 */
@Repository
public interface UserRoleRelationRepository extends CrudRepository<UserRoleRelationEntity, Long> {

    /**
     * 查找用户所有角色关联
     */
    @CachePut(value = CACHE_USER_ROLE_KEY, key = "#userId")
    List<UserRoleRelationEntity> findByUserId(@Param("userId") Long userId);

    /**
     * 删除用户所有角色关联
     */
    @CacheEvict(value = CACHE_USER_ROLE_KEY, key = "#userId", beforeInvocation = true)
    void deleteByUserId(@Param("userId") Long userId);

}
