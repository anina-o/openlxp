package cn.elvea.lxp.resource.repository;

import cn.elvea.lxp.resource.entity.ResourceTypeEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static cn.elvea.lxp.core.CoreConstants.CACHE_RESOURCE_TYPE_KEY;

/**
 * ResourceTypeRepository
 *
 * @author elvea
 */
@Repository
public interface ResourceTypeRepository extends PagingAndSortingRepository<ResourceTypeEntity, Long> {

    /**
     * 获取资源类型
     */
    @Cacheable(value = CACHE_RESOURCE_TYPE_KEY, key = "#p0")
    Optional<ResourceTypeEntity> findByType(@NotNull String type);

    /**
     * 获取资源类型
     */
    @Override
    @Cacheable(value = CACHE_RESOURCE_TYPE_KEY, key = "#p0")
    Optional<ResourceTypeEntity> findById(@NotNull Long id);

    /**
     * 删除
     */
    @Caching(evict = {
            @CacheEvict(value = CACHE_RESOURCE_TYPE_KEY, key = "#entity.id"),
            @CacheEvict(value = CACHE_RESOURCE_TYPE_KEY, key = "#entity.type")
    })
    default void clear(@NotNull ResourceTypeEntity entity) {
    }

    /**
     * 清空缓存
     */
    @Caching(evict = {
            @CacheEvict(value = CACHE_RESOURCE_TYPE_KEY, beforeInvocation = true, allEntries = true),
    })
    default void clear() {
    }

}

