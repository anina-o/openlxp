package cn.elvea.lxp.core.service.impl;

import cn.elvea.lxp.common.model.BaseEntity;
import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.dto.RoleDto;
import cn.elvea.lxp.core.entity.RoleEntity;
import cn.elvea.lxp.core.entity.UserRoleRelationEntity;
import cn.elvea.lxp.core.repository.RoleRepository;
import cn.elvea.lxp.core.repository.UserRoleRelationRepository;
import cn.elvea.lxp.core.service.RoleService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static cn.elvea.lxp.core.CoreConstants.DEFAULT_USER_ROLE_ID;

/**
 * RoleServiceImpl
 *
 * @author elvea
 * @see RoleService
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRoleRelationRepository userRoleRelationRepository;

    /**
     * @see RoleService#findByUserId(Long)
     */
    @Override
    public List<RoleDto> findByUserId(Long userId) {
        List<UserRoleRelationEntity> entityList = this.userRoleRelationRepository.findByUserId(userId);
        return entityList.stream().map(entity -> {
            RoleEntity roleEntity = this.roleRepository.findById(entity.getId()).get();
            return ConvertUtils.sourceToTarget(roleEntity, RoleDto.class);
        }).collect(Collectors.toList());
    }

    /**
     * @see RoleService#getDefaultRole()
     */
    @Override
    public RoleDto getDefaultRole() {
        RoleEntity roleEntity = this.roleRepository.findById(DEFAULT_USER_ROLE_ID).get();
        return ConvertUtils.sourceToTarget(roleEntity, RoleDto.class);
    }

    /**
     * @see RoleService#assignRoles(Long, List)
     */
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
     * @see RoleService#findRoleIdListByUserId(Long)
     */
    public List<Long> findRoleIdListByUserId(Long userId) {
        List<UserRoleRelationEntity> entityList = this.userRoleRelationRepository.findByUserId(userId);
        //
        return CollectionUtils.isEmpty(entityList) ?
                Lists.newArrayList() :
                entityList.stream().map(BaseEntity::getId).collect(Collectors.toList());
    }

}
