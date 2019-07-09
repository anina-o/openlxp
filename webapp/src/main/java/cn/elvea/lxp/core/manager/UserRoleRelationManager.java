package cn.elvea.lxp.core.manager;

import java.util.List;

/**
 * UserRoleRelationManager
 *
 * @author elvea
 */
public interface UserRoleRelationManager {

    /**
     * 给用户分配角色
     */
    void assignRoles(Long userId, List<Long> roleIdList);

    /**
     * 给用户分配角色
     */
    List<Long> findRoleIdListByUserId(Long userId);

}
