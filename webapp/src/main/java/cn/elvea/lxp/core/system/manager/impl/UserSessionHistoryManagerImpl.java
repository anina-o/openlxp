package cn.elvea.lxp.core.system.manager.impl;

import cn.elvea.lxp.core.system.entity.UserSessionHistoryEntity;
import cn.elvea.lxp.core.system.manager.UserSessionHistoryManager;
import cn.elvea.lxp.core.system.mapper.UserSessionHistoryMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * UserSessionHistoryManagerImpl
 *
 * @author elvea
 */
@Service
public class UserSessionHistoryManagerImpl extends ServiceImpl<UserSessionHistoryMapper, UserSessionHistoryEntity> implements UserSessionHistoryManager {
}
