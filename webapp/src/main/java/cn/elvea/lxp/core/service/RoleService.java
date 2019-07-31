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
     * 根据用户ID查询用户
     */
    RoleDto findById(Long id);

    /**
     * 获取默认用户角色
     */
    RoleDto getDefaultRole();

    /**
     * 获取用户角色
     */
    List<RoleDto> findByUserId(Long userId);

    /**
     * 给用户分配角色
     */
    List<RoleDto> assignRoles(Long userId, List<Long> roleIdList);

}
