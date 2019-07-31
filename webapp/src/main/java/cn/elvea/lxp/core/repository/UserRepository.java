package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.UserEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static cn.elvea.lxp.core.CoreConstants.CACHE_USER_KEY;

/**
 * UserRepository
 *
 * @author elvea
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    /**
     * 根据用户名获取用户
     */
    @Cacheable(value = CACHE_USER_KEY, key = "#p0")
    Optional<UserEntity> findByUsername(@NotNull String username);

    /**
     * 根据用户ID获取用户
     */
    @Override
    @Cacheable(value = CACHE_USER_KEY, key = "#p0")
    Optional<UserEntity> findById(@NotNull Long id);

    /**
     * 保存用户
     */
    @Override
    @Caching(put = {
            @CachePut(value = CACHE_USER_KEY, key = "#result.id"),
            @CachePut(value = CACHE_USER_KEY, key = "#result.username")
    })
    <S extends UserEntity> S save(@NotNull S entity);

    /**
     * 删除用户
     */
    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_USER_KEY, key = "#entity.id"),
            @CacheEvict(value = CACHE_USER_KEY, key = "#entity.username")
    })
    void delete(@NotNull UserEntity entity);

    /**
     * 清空缓存
     */
    @Caching(evict = {
            @CacheEvict(value = CACHE_USER_KEY, beforeInvocation = true, allEntries = true),
    })
    default void clear() {
    }

}
