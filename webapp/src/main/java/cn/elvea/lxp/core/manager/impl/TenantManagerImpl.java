package cn.elvea.lxp.core.manager.impl;

import cn.elvea.lxp.common.service.AbstractEntityManager;
import cn.elvea.lxp.core.entity.TenantEntity;
import cn.elvea.lxp.core.manager.TenantManager;
import cn.elvea.lxp.core.repository.TenantRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.PagingAndSortingRepository;

import static cn.elvea.lxp.core.CoreConstants.CACHE_TENANT_KEY;

/**
 * TenantManagerImpl
 *
 * @author elvea
 */
public class TenantManagerImpl extends AbstractEntityManager<TenantEntity, Long> implements TenantManager {

    @Autowired
    private TenantRepository tenantRepository;

    @Override
    protected PagingAndSortingRepository<TenantEntity, Long> getRepository() {
        return this.tenantRepository;
    }

    @Cacheable(value = CACHE_TENANT_KEY, key = "#p0")
    public TenantEntity findById(@NotNull Long id) {
        return super.findById(id);
    }

}
