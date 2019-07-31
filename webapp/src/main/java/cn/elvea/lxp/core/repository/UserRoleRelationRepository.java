package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.UserRoleRelationEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
     * 查询用户所有权限的ID集合
     */
    @Cacheable(value = CACHE_USER_ROLE_KEY, key = "#p0")
    @Query("select e.roleId from UserRoleRelationEntity e where e.userId = :userId")
    List<Long> findByUserId(@Param("userId") Long userId);

    /**
     * 删除用户所有角色关联
     */
    @Modifying
    @Query("delete from UserRoleRelationEntity e where e.userId = :userId")
    @CacheEvict(value = CACHE_USER_ROLE_KEY, key = "#p0", beforeInvocation = true)
    void deleteByUserId(@Param("userId") Long userId);

}
