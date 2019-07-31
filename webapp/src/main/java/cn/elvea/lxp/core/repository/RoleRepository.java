package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.RoleEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static cn.elvea.lxp.core.CoreConstants.CACHE_ROLE_KEY;

/**
 * RoleRepository
 *
 * @author elvea
 */
@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
    /**
     * 根据用户ID获取用户
     */
    @Override
    @Cacheable(value = CACHE_ROLE_KEY, key = "#p0")
    Optional<RoleEntity> findById(@NotNull Long id);

    /**
     * 保存用户
     */
    @Override
    @CachePut(value = CACHE_ROLE_KEY, key = "#result.id")
    <S extends RoleEntity> S save(@NotNull S entity);

    /**
     * 删除用户
     */
    @Override
    @CacheEvict(value = CACHE_ROLE_KEY, key = "#entity.id")
    void delete(@NotNull RoleEntity entity);

    /**
     * 清空缓存
     */
    @Caching(evict = {
            @CacheEvict(value = CACHE_ROLE_KEY, beforeInvocation = true, allEntries = true),
    })
    default void clear() {
    }

}
