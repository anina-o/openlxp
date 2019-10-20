package cn.elvea.lxp.core.system.manager;

import cn.elvea.lxp.core.system.entity.RoleEntity;

/**
 * RoleManager
 *
 * @author elvea
 */
public interface RoleManager {

    /**
     * 根据ID查询角色
     */
    RoleEntity findRoleById(Long id);

    /**
     * 根据编号查询角色
     */
    RoleEntity findRoleByCode(String code);

}
