package cn.elvea.lxp.core.service;

import cn.elvea.lxp.core.dto.RoleDto;

import java.util.List;

/**
 * RoleService
 *
 * @author elvea
 */
public interface RoleService {

    /**
     * 获取用户角色
     */
    List<RoleDto> findByUserId(Long userId);

    /**
     * 获取默认用户角色
     */
    RoleDto getDefaultRole();

    /**
     * 给用户分配角色
     */
    void assignRoles(Long userId, List<Long> roleIdList);

    /**
     * 查询用户拥有的角色ID
     */
    List<Long> findRoleIdListByUserId(Long userId);

}
