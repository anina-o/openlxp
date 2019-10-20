package cn.elvea.lxp.core.system.manager.impl;

import cn.elvea.lxp.core.system.entity.RoleEntity;
import cn.elvea.lxp.core.system.manager.RoleManager;
import cn.elvea.lxp.core.system.mapper.RoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static cn.elvea.lxp.core.system.CoreConstants.CACHE_ROLE_KEY;

/**
 * RoleManagerImpl
 *
 * @author elvea
 */
@Service
public class RoleManagerImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleManager {

    /**
     * @see RoleManager#findRoleByCode(String)
     */
    @Override
    @Cacheable(value = CACHE_ROLE_KEY, key = "#code", condition = "#result != null")
    public RoleEntity findRoleByCode(String code) {
        RoleEntity condition = new RoleEntity();
        condition.setCode(code);
        return this.baseMapper.selectOne(new QueryWrapper<>(condition));
    }

    /**
     * @see RoleManager#findRoleById(Long)
     */
    @Override
    @Cacheable(value = CACHE_ROLE_KEY, key = "#id", condition = "#result != null")
    public RoleEntity findRoleById(Long id) {
        return this.baseMapper.selectById(id);
    }

}
