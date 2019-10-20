package cn.elvea.lxp.core.system.manager.impl;

import cn.elvea.lxp.core.system.entity.UserSessionEntity;
import cn.elvea.lxp.core.system.manager.UserSessionManager;
import cn.elvea.lxp.core.system.mapper.UserSessionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * UserSessionManagerImpl
 *
 * @author elvea
 */
@Service
public class UserSessionManagerImpl extends ServiceImpl<UserSessionMapper, UserSessionEntity> implements UserSessionManager {

}
