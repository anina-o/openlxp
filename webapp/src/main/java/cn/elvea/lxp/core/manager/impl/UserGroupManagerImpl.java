package cn.elvea.lxp.core.manager.impl;

import cn.elvea.lxp.common.Context;
import cn.elvea.lxp.core.entity.UserGroupEntity;
import cn.elvea.lxp.core.manager.UserGroupManager;
import cn.elvea.lxp.core.repository.UserGroupRepository;
import cn.elvea.lxp.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * UserGroupManagerImpl
 *
 * @author elvea
 */
public class UserGroupManagerImpl implements UserGroupManager {

    private final static String CACHE_NAME = "USER-GROUP";

    private Context context;

    private UserGroupRepository userGroupRepository;

    @Override
    @CachePut(value = CACHE_NAME, key = "#entity.id")
    public UserGroupEntity save(UserGroupEntity entity) {
        return userGroupRepository.save(entity);
    }

    @Override
    @Cacheable(value = CACHE_NAME, key = "#id")
    public UserGroupEntity findById(Long id) {
        return userGroupRepository.findById(id).orElse(null);
    }

    @Override
    @CacheEvict(value = CACHE_NAME, key = "#entity.id")
    public void delete(UserGroupEntity entity) {
        entity.setActive(false);
        entity.setDeletedAt(context.getDate());
        entity.setDeletedBy(SecurityUtils.getCurrentUserId());
        userGroupRepository.save(entity);
    }

    @Autowired
    public void setContext(Context context) {
        this.context = context;
    }

    @Autowired
    public void setUserGroupRepository(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

}
