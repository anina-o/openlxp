package cn.elvea.lxp.core.manager.impl;

import cn.elvea.lxp.common.service.AbstractEntityManager;
import cn.elvea.lxp.core.entity.UserEntity;
import cn.elvea.lxp.core.manager.UserManager;
import cn.elvea.lxp.core.mapper.UserMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import static cn.elvea.lxp.core.CoreConstants.CACHE_USER_KEY;

/**
 * UserManagerImpl
 *
 * @author elvea
 */
@Service
public class UserManagerImpl extends AbstractEntityManager<UserMapper, UserEntity, Long> implements UserManager {

    /**
     * @see UserManager#findByUsername(String)
     */
    @Override
    @Cacheable(value = CACHE_USER_KEY, key = "#username", condition = "#result != null")
    public UserEntity findByUsername(String username) {
        return repository.findByUsername(username);
    }

    /**
     * @see UserManager#findById(Object)
     */
    @Override
    @Cacheable(value = CACHE_USER_KEY, key = "#id", condition = "#result != null")
    public UserEntity findById(Long id) {
        return repository.selectById(id);
    }

    /**
     * @see UserManager#save(Object)
     */
    @Override
    @Caching(put = {
            @CachePut(value = CACHE_USER_KEY, key = "#result.id"),
            @CachePut(value = CACHE_USER_KEY, key = "#result.username")
    })
    public UserEntity save(UserEntity entity) {
        return super.save(entity);
    }

    /**
     * @see UserManager#delete(Object)
     */
    @Override
    @Caching(evict = {
            @CacheEvict(value = CACHE_USER_KEY, key = "#entity.id"),
            @CacheEvict(value = CACHE_USER_KEY, key = "#entity.username")
    })
    public void delete(@NotNull UserEntity entity) {
        save(entity);
    }

    /**
     * @see UserManager#clear()
     */
    @Caching(evict = {
            @CacheEvict(value = CACHE_USER_KEY, beforeInvocation = true, allEntries = true),
    })
    public void clear() {
    }

}
