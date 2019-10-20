package cn.elvea.lxp.core.system.service.impl;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.system.dto.RoleDto;
import cn.elvea.lxp.core.system.entity.RoleEntity;
import cn.elvea.lxp.core.system.manager.RoleManager;
import cn.elvea.lxp.core.system.manager.UserRoleRelationManager;
import cn.elvea.lxp.core.system.service.RoleService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.elvea.lxp.core.system.CoreConstants.DEFAULT_USER_ROLE_ID;

/**
 * RoleServiceImpl
 *
 * @author elvea
 * @see RoleService
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleManager roleManager;

    @Autowired
    private UserRoleRelationManager userRoleRelationManager;

    /**
     * @see RoleService#findById(Long)
     */
    @Override
    public RoleDto findById(Long id) {
        RoleEntity entity = this.roleManager.findRoleById(id);
        return this.getRoleDto(entity);
    }

    private RoleDto getRoleDto(@NotNull RoleEntity roleEntity) {
        RoleDto userDto = ConvertUtils.sourceToTarget(roleEntity, RoleDto.class);
        //
        return userDto;
    }

    /**
     * @see RoleService#findRolesByUserId(Long)
     */
    @Override
    public List<RoleDto> findRolesByUserId(Long userId) {
        List<Long> roleIdList = this.userRoleRelationManager.findByUserId(userId);
        return roleIdList.stream().map(entity -> {
            RoleEntity roleEntity = this.roleManager.findRoleById(entity);
            return ConvertUtils.sourceToTarget(roleEntity, RoleDto.class);
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * @see RoleService#getDefaultRole()
     */
    @Override
    public RoleDto getDefaultRole() {
        RoleEntity roleEntity = this.roleManager.findRoleById(DEFAULT_USER_ROLE_ID);
        return this.getRoleDto(roleEntity);
    }

    /**
     * @see RoleService#assignRoles(Long, List)
     */
    public List<RoleDto> assignRoles(Long userId, List<Long> roleIdList) {
        // 删除已有关联
        this.userRoleRelationManager.deleteByUserId(userId);
        // 保存关联
        if (!CollectionUtils.isEmpty(roleIdList)) {
            this.userRoleRelationManager.saveByUserId(userId, roleIdList);
        }
        //
        return this.findRolesByUserId(userId);
    }

}
