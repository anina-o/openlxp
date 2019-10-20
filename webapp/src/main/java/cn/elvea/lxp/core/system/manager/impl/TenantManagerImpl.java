package cn.elvea.lxp.core.system.manager.impl;

import cn.elvea.lxp.common.service.AbstractEntityManager;
import cn.elvea.lxp.core.system.entity.TenantEntity;
import cn.elvea.lxp.core.system.manager.TenantManager;
import cn.elvea.lxp.core.system.mapper.TenantMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.Cacheable;

import static cn.elvea.lxp.core.system.CoreConstants.CACHE_TENANT_KEY;

/**
 * TenantManagerImpl
 *
 * @author elvea
 */
public class TenantManagerImpl extends AbstractEntityManager<TenantMapper, TenantEntity, Long> implements TenantManager {

    @Cacheable(value = CACHE_TENANT_KEY, key = "#p0")
    public TenantEntity findById(@NotNull Long id) {
        return super.findById(id);
    }

}
