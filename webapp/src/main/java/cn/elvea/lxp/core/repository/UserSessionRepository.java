package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.UserSessionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * UserSessionRepository
 *
 * @author elvea
 */
@Repository
public interface UserSessionRepository extends PagingAndSortingRepository<UserSessionEntity, Long> {
}
