package cn.elvea.lxp.core.service.impl;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.dto.RoleDto;
import cn.elvea.lxp.core.entity.RoleEntity;
import cn.elvea.lxp.core.entity.UserRoleRelationEntity;
import cn.elvea.lxp.core.repository.RoleRepository;
import cn.elvea.lxp.core.repository.UserRoleRelationRepository;
import cn.elvea.lxp.core.service.RoleService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRelationRepository userRoleRelationRepository;

    /**
     * @see RoleService#findById(Long)
     */
    @Override
    public RoleDto findById(Long id) {
        Optional<RoleEntity> entity = this.roleRepository.findById(id);
        return entity.map(this::getRoleDto).orElse(null);
    }

    /**
     * 获取用户信息
     * 包含附件关联的信息
     */
    private RoleDto getRoleDto(@NotNull RoleEntity roleEntity) {
        RoleDto userDto = ConvertUtils.sourceToTarget(roleEntity, RoleDto.class);
        //
        return userDto;
    }

    /**
     * @see RoleService#findByUserId(Long)
     */
    @Override
    public List<RoleDto> findByUserId(Long userId) {
        List<Long> entityList = this.userRoleRelationRepository.findByUserId(userId);
        return entityList.stream().map(entity -> {
            Optional<RoleEntity> roleEntity = this.roleRepository.findById(entity);
            return roleEntity.map(e -> {
                return ConvertUtils.sourceToTarget(e, RoleDto.class);
            }).orElse(null);
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * @see RoleService#getDefaultRole()
     */
    @Override
    public RoleDto getDefaultRole() {
        Optional<RoleEntity> roleEntity = this.roleRepository.findById(DEFAULT_USER_ROLE_ID);
        return roleEntity.map(this::getRoleDto).orElse(null);
    }

    /**
     * @see RoleService#assignRoles(Long, List)
     */
    public List<RoleDto> assignRoles(Long userId, List<Long> roleIdList) {
        // 删除已有关联
        this.userRoleRelationRepository.deleteByUserId(userId);
        // 保存关联
        if (!CollectionUtils.isEmpty(roleIdList)) {
            List<UserRoleRelationEntity> entityList = new ArrayList<>();
            for (Long roleId : roleIdList) {
                entityList.add(new UserRoleRelationEntity(userId, roleId));
            }
            this.userRoleRelationRepository.saveAll(entityList);
        }
        //
        return this.findByUserId(userId);
    }

}
