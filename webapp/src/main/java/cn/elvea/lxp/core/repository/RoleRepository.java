package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.RoleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository
 *
 * @author elvea
 */
@Repository
public interface RoleRepository extends PagingAndSortingRepository<RoleEntity, Long> {
}
