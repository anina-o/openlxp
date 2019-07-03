package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.UserTokenEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * UserTokenRepository
 *
 * @author elvea
 */
@Repository
public interface UserTokenRepository extends PagingAndSortingRepository<UserTokenEntity, Long> {
}
