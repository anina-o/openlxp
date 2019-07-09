package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.UserRoleRelationEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRoleRelationRepository
 *
 * @author elvea
 */
@Repository
public interface UserRoleRelationRepository extends PagingAndSortingRepository<UserRoleRelationEntity, Long> {

    /**
     * 查找用户所有角色关联
     */
    List<UserRoleRelationEntity> findByUserId(@Param("userId") Long userId);

    /**
     * 删除用户所有角色关联
     */
    void deleteByUserId(@Param("userId") Long userId);

}
