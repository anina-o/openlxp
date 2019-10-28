package cn.elvea.lxp.core.system.manager.impl;

import cn.elvea.lxp.core.system.entity.UserSessionEntity;
import cn.elvea.lxp.core.system.manager.UserSessionManager;
import cn.elvea.lxp.core.system.mapper.UserSessionMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

import static cn.elvea.lxp.core.system.CoreConstants.CACHE_USER_SESSION_KEY;

/**
 * UserSessionManagerImpl
 *
 * @author elvea
 */
@Service
public class UserSessionManagerImpl extends ServiceImpl<UserSessionMapper, UserSessionEntity> implements UserSessionManager {

    /**
     * @see UserSessionManager#getUserSession(String)
     */
    @Override
    @Cacheable(value = CACHE_USER_SESSION_KEY, key = "#sessionId", condition = "#result != null")
    public UserSessionEntity getUserSession(String sessionId) {
        UserSessionEntity condition = new UserSessionEntity();
        condition.setSessionId(sessionId);
        List<UserSessionEntity> entityList = this.baseMapper.selectList(new QueryWrapper<>(condition));
        if (CollectionUtils.isNotEmpty(entityList)) {
            return entityList.get(0);
        }
        return null;
    }

    /**
     * @see UserSessionManager#saveUserSession(UserSessionEntity)
     */
    @Override
    @CachePut(value = CACHE_USER_SESSION_KEY, key = "#entity.sessionId")
    public UserSessionEntity saveUserSession(UserSessionEntity entity) {
        if (entity.getId() == null) {
            this.save(entity);
        } else {
            this.updateById(entity);
        }
        return entity;
    }

    /**
     * @see UserSessionManager#removeUserSession(UserSessionEntity)
     */
    @Override
    @CacheEvict(value = CACHE_USER_SESSION_KEY, key = "#entity.sessionId", beforeInvocation = true)
    public void removeUserSession(UserSessionEntity entity) {
        this.updateById(entity);
    }

}
