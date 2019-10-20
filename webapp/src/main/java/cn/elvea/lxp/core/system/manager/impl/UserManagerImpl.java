package cn.elvea.lxp.core.system.manager.impl;

import cn.elvea.lxp.core.system.entity.UserEntity;
import cn.elvea.lxp.core.system.manager.UserManager;
import cn.elvea.lxp.core.system.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Map;

import static cn.elvea.lxp.core.system.CoreConstants.CACHE_USER_KEY;

/**
 * UserManagerImpl
 *
 * @author elvea
 */
@Slf4j
@Service
public class UserManagerImpl extends ServiceImpl<UserMapper, UserEntity> implements UserManager {

    /**
     * @see UserManager#findUserByUsername(String)
     */
    @Override
    @Cacheable(value = CACHE_USER_KEY, key = "#username", condition = "#result != null")
    public UserEntity findUserByUsername(String username) {
        Map<String, Object> conditionMap = Maps.newHashMap();
        conditionMap.put("username", username);
        conditionMap.put("usernameExactMatch", true);
        return this.baseMapper.findByUsername(conditionMap);
    }

    /**
     * @see UserManager#findUserByEmail(String)
     */
    @Override
    @Cacheable(value = CACHE_USER_KEY, key = "#email", condition = "#result != null")
    public UserEntity findUserByEmail(String email) {
        Map<String, Object> conditionMap = Maps.newHashMap();
        conditionMap.put("email", email);
        return this.baseMapper.findByEmail(conditionMap);
    }

    /**
     * @see UserManager#findUserByMobile(String)
     */
    @Override
    @Cacheable(value = CACHE_USER_KEY, key = "#mobile", condition = "#result != null")
    public UserEntity findUserByMobile(String mobile) {
        Map<String, Object> conditionMap = Maps.newHashMap();
        conditionMap.put("mobile", mobile);
        return this.baseMapper.findByMobile(conditionMap);
    }

    /**
     * @see UserManager#findUserById(Long)
     */
    @Override
    @Cacheable(value = CACHE_USER_KEY, key = "#id", condition = "#result != null")
    public UserEntity findUserById(Long id) {
        return this.baseMapper.selectById(id);
    }

    /**
     * @see UserManager#saveUser(UserEntity)
     */
    @Override
    @Caching(put = {
            @CachePut(value = CACHE_USER_KEY, key = "#entity.id"),
            @CachePut(value = CACHE_USER_KEY, key = "#entity.email"),
            @CachePut(value = CACHE_USER_KEY, key = "#entity.mobile"),
            @CachePut(value = CACHE_USER_KEY, key = "#entity.username")
    })
    public UserEntity saveUser(UserEntity entity) {
        if (entity.getId() == null) {
            super.save(entity);
        } else {
            super.updateById(entity);
        }
        return entity;
    }

    /**
     * @see UserManager#deleteUserById(Long)
     */
    @Override
    @CacheEvict(value = CACHE_USER_KEY, key = "#id")
    public void deleteUserById(@NotNull Long id) {
        super.removeById(id);
    }

    /**
     * @see UserManager#clearAllCache()
     */
    @CacheEvict(value = CACHE_USER_KEY, beforeInvocation = true, allEntries = true)
    public void clearAllCache() {
        log.debug("clear user cache.");
    }

}
