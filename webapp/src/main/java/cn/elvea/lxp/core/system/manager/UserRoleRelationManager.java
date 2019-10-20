package cn.elvea.lxp.core.system.manager;

import java.util.List;

/**
 * UserRoleRelationManager
 *
 * @author elvea
 */
public interface UserRoleRelationManager {

    /**
     * 根据用户ID获取用户所有角色ID
     */
    List<Long> findByUserId(Long userId);

    /**
     * 根据用户ID删除用户所有角色关联
     */
    void deleteByUserId(Long userId);

    /**
     * 保存用户所有角色关联
     */
    List<Long> saveByUserId(Long userId, List<Long> roleIdList);

}
