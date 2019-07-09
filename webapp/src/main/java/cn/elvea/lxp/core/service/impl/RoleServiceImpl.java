package cn.elvea.lxp.core.service.impl;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.dto.RoleDto;
import cn.elvea.lxp.core.entity.RoleEntity;
import cn.elvea.lxp.core.manager.RoleManager;
import cn.elvea.lxp.core.manager.UserRoleRelationManager;
import cn.elvea.lxp.core.service.RoleService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * RoleServiceImpl
 *
 * @author elvea
 * @see RoleService
 */
@Service
public class RoleServiceImpl implements RoleService {

    private RoleManager roleManager;

    private UserRoleRelationManager userRoleRelationManager;

    /**
     * @see RoleService#findByUserId(Long)
     */
    @Override
    public List<RoleDto> findByUserId(Long userId) {
        List<Long> roleIdList = this.userRoleRelationManager.findRoleIdListByUserId(userId);
        if (CollectionUtils.isEmpty(roleIdList)) {
            return Lists.newArrayList();
        }
        return roleIdList.stream().map(roleId -> {
            RoleEntity roleEntity = this.roleManager.findById(roleId);
            return ConvertUtils.sourceToTarget(roleEntity, RoleDto.class);
        }).collect(Collectors.toList());
    }

    @Autowired
    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    @Autowired
    public void setUserRoleRelationManager(UserRoleRelationManager userRoleRelationManager) {
        this.userRoleRelationManager = userRoleRelationManager;
    }

}
