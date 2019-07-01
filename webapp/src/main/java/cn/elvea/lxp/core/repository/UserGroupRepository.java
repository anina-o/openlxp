package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.UserGroupEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * UserGroupRepository
 *
 * @author elvea
 */
@Repository
public interface UserGroupRepository extends PagingAndSortingRepository<UserGroupEntity, Long> {
}
