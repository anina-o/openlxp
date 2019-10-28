package cn.elvea.lxp.core.system.manager.impl;

import cn.elvea.lxp.core.system.entity.UserLoginHistoryEntity;
import cn.elvea.lxp.core.system.manager.UserLoginHistoryManager;
import cn.elvea.lxp.core.system.mapper.UserLoginHistoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * UserLoginHistoryManagerImpl
 *
 * @author elvea
 */
@Service
public class UserLoginHistoryManagerImpl extends ServiceImpl<UserLoginHistoryMapper, UserLoginHistoryEntity> implements UserLoginHistoryManager {

    /**
     * @see UserLoginHistoryManager#saveUserLoginHistory(UserLoginHistoryEntity)
     */
    @Override
    public void saveUserLoginHistory(UserLoginHistoryEntity entity) {
        this.save(entity);
    }

}
