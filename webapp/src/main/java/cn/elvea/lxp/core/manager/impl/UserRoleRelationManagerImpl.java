package cn.elvea.lxp.core.manager.impl;

import cn.elvea.lxp.common.model.BaseEntity;
import cn.elvea.lxp.core.entity.UserRoleRelationEntity;
import cn.elvea.lxp.core.manager.UserRoleRelationManager;
import cn.elvea.lxp.core.repository.UserRoleRelationRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UserRoleRelationManagerImpl
 *
 * @author elvea
 * @see UserRoleRelationManager
 */
@Service
public class UserRoleRelationManagerImpl implements UserRoleRelationManager {

    private final static String CACHE_NAME = "USER_ROLE_RELATION";

    private UserRoleRelationRepository userRoleRelationRepository;

    /**
     * @see UserRoleRelationManager#assignRoles(Long, List)
     */
    @CachePut(value = CACHE_NAME, key = "#userId")
    public void assignRoles(Long userId, List<Long> roleIdList) {
        // 先删除所有关联
        this.userRoleRelationRepository.deleteByUserId(userId);
        // 重新保存所有关联
        if (!CollectionUtils.isEmpty(roleIdList)) {
            List<UserRoleRelationEntity> entityList = roleIdList.stream().map(roleId -> {
                UserRoleRelationEntity entity = new UserRoleRelationEntity();
                entity.setUserId(userId);
                entity.setRoleId(roleId);
                return entity;
            }).collect(Collectors.toList());
            this.userRoleRelationRepository.saveAll(entityList);
        }
    }

    /**
     * @see UserRoleRelationManager#findRoleIdListByUserId(Long)
     */
    @Override
    @Cacheable(value = CACHE_NAME, key = "#userId")
    public List<Long> findRoleIdListByUserId(Long userId) {
        List<UserRoleRelationEntity> entityList = this.userRoleRelationRepository.findByUserId(userId);
        //
        return CollectionUtils.isEmpty(entityList) ?
                Lists.newArrayList() :
                entityList.stream().map(BaseEntity::getId).collect(Collectors.toList());
    }

    @Autowired
    public void setUserRoleRelationRepository(UserRoleRelationRepository userRoleRelationRepository) {
        this.userRoleRelationRepository = userRoleRelationRepository;
    }

}
