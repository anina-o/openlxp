package cn.elvea.lxp.core.manager.impl;

import cn.elvea.lxp.common.Context;
import cn.elvea.lxp.core.entity.RoleEntity;
import cn.elvea.lxp.core.manager.RoleManager;
import cn.elvea.lxp.core.repository.RoleRepository;
import cn.elvea.lxp.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * RoleManagerImpl
 *
 * @author elvea
 */
@Service
public class RoleManagerImpl implements RoleManager {

    private final static String CACHE_NAME = "ROLE";

    private Context context;

    private RoleRepository roleRepository;

    /**
     * @see RoleManager#save(Object)
     */
    @Override
    @CachePut(value = CACHE_NAME, key = "#entity.id")
    public RoleEntity save(RoleEntity entity) {
        return roleRepository.save(entity);
    }

    /**
     * @see RoleManager#findById(Object)
     */
    @Override
    @Cacheable(value = CACHE_NAME, key = "#id")
    public RoleEntity findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    /**
     * @see RoleManager#delete(Object)
     */
    @Override
    @CacheEvict(value = CACHE_NAME, key = "#entity.id")
    public void delete(RoleEntity entity) {
        entity.setActive(false);
        entity.setDeletedAt(context.getDate());
        entity.setDeletedBy(SecurityUtils.getCurrentUserId());
        roleRepository.save(entity);
    }

    @Autowired
    public void setContext(Context context) {
        this.context = context;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

}
