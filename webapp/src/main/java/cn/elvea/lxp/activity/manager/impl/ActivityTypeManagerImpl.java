package cn.elvea.lxp.activity.manager.impl;

import cn.elvea.lxp.activity.entity.ActivityTypeEntity;
import cn.elvea.lxp.activity.manager.ActivityTypeManager;
import cn.elvea.lxp.activity.mapper.ActivityTypeMapper;
import cn.elvea.lxp.common.service.AbstractEntityManager;
import cn.elvea.lxp.resource.entity.ResourceTypeEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import static cn.elvea.lxp.core.CoreConstants.CACHE_ACTIVITY_TYPE_KEY;

/**
 * ActivityTypeManagerImpl
 *
 * @author elvea
 */
@Service
public class ActivityTypeManagerImpl
        extends AbstractEntityManager<ActivityTypeMapper, ActivityTypeEntity, Long>
        implements ActivityTypeManager {

    @Autowired
    private ActivityTypeMapper activityTypeRepository;

    @Override
    @Cacheable(value = CACHE_ACTIVITY_TYPE_KEY, key = "#p0")
    public ActivityTypeEntity findByType(@NotNull String type) {
        return this.activityTypeRepository.findByType(type).orElse(null);
    }

    @Override
    @Cacheable(value = CACHE_ACTIVITY_TYPE_KEY, key = "#p0")
    public ActivityTypeEntity findById(@NotNull Long id) {
        return super.findById(id);
    }

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
