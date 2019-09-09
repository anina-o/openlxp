package cn.elvea.lxp.activity.manager;

import cn.elvea.lxp.activity.repository.ActivityTypeRepository;
import cn.elvea.lxp.common.service.AbstractEntityManager;
import cn.elvea.lxp.resource.entity.ResourceTypeEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static cn.elvea.lxp.core.CoreConstants.CACHE_ACTIVITY_TYPE_KEY;

/**
 * ActivityTypeManagerImpl
 *
 * @author elvea
 */
@Service
public class ActivityTypeManagerImpl extends AbstractEntityManager {

    @Autowired
    private ActivityTypeRepository activityTypeRepository;

    @Override
    protected PagingAndSortingRepository getRepository() {
        return activityTypeRepository;
    }

    @Cacheable(value = CACHE_ACTIVITY_TYPE_KEY, key = "#p0")
    public Optional<ResourceTypeEntity> findByType(@NotNull String type) {
        return this.activityTypeRepository.findByType(type);
    }

    @Cacheable(value = CACHE_ACTIVITY_TYPE_KEY, key = "#p0")
    public Optional<ResourceTypeEntity> findById(@NotNull Long id) {
        return this.activityTypeRepository.findById(id);
    }

    /**
     * 删除
     */
    @Caching(evict = {
            @CacheEvict(value = CACHE_ACTIVITY_TYPE_KEY, key = "#entity.id"),
            @CacheEvict(value = CACHE_ACTIVITY_TYPE_KEY, key = "#entity.type")
    })
    public void clear(@NotNull ResourceTypeEntity entity) {
    }

    /**
     * 清空缓存
     */
    @Caching(evict = {
            @CacheEvict(value = CACHE_ACTIVITY_TYPE_KEY, beforeInvocation = true, allEntries = true),
    })
    public void clear() {
    }

}
