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

}
