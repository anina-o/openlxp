package cn.elvea.lxp.core.repository;

import cn.elvea.lxp.core.entity.TenantEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * TenantRepository
 *
 * @author elvea
 */
@Repository
public interface TenantRepository extends PagingAndSortingRepository<TenantEntity, Long> {
}
