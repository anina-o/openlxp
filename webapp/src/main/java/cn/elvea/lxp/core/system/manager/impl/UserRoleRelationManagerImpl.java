package cn.elvea.lxp.core.system.manager.impl;

import cn.elvea.lxp.core.system.entity.UserRoleRelationEntity;
import cn.elvea.lxp.core.system.manager.UserRoleRelationManager;
import cn.elvea.lxp.core.system.mapper.UserRoleRelationMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.compress.utils.Lists;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static cn.elvea.lxp.core.system.CoreConstants.CACHE_USER_KEY;
import static cn.elvea.lxp.core.system.CoreConstants.CACHE_USER_ROLE_KEY;

/**
 * UserRoleRelationManagerImpl
 *
 * @author elvea
 */
@Service
public class UserRoleRelationManagerImpl extends ServiceImpl<UserRoleRelationMapper, UserRoleRelationEntity> implements UserRoleRelationManager {

    /**
     * @see UserRoleRelationManager#findByUserId(Long)
     */
    @Override
    @Cacheable(value = CACHE_USER_ROLE_KEY, key = "#userId")
    public List<Long> findByUserId(Long userId) {
        UserRoleRelationEntity condition = new UserRoleRelationEntity();
        condition.setUserId(userId);
        //
        return this.getBaseMapper()
                .selectList(new QueryWrapper<>(condition))
                .stream()
                .map(UserRoleRelationEntity::getRoleId)
                .collect(Collectors.toList());
    }

    /**
     * @see UserRoleRelationManager#deleteByUserId(Long)
     */
    @Override
    @CacheEvict(value = CACHE_USER_ROLE_KEY, key = "#userId")
    public void deleteByUserId(Long userId) {
        UserRoleRelationEntity condition = new UserRoleRelationEntity();
        condition.setUserId(userId);
        //
        this.getBaseMapper().delete(new UpdateWrapper<>(condition));
    }

    /**
     * @see UserRoleRelationManager#saveByUserId(Long, List)
     */
    @Override
    @CachePut(value = CACHE_USER_KEY, key = "#userId")
    public List<Long> saveByUserId(Long userId, List<Long> roleIdList) {
        List<UserRoleRelationEntity> entityList = Lists.newArrayList();
        for (Long roleId : roleIdList) {
            UserRoleRelationEntity entity = new UserRoleRelationEntity();
            entity.setUserId(userId);
            entity.setRoleId(roleId);
            entity.setCreatedAt(new Date());
            entity.setCreatedBy(userId);
            //
            entityList.add(entity);
        }
        // 批量保存关联
        saveBatch(entityList);
        // 重新查询数据库返回用户所有角色ID集合并刷新缓存
        return this.findByUserId(userId);
    }

}
