package cn.elvea.lxp.core.system.manager.impl;

import cn.elvea.lxp.core.system.entity.UserSessionStatisticsEntity;
import cn.elvea.lxp.core.system.manager.UserSessionStatisticsManager;
import cn.elvea.lxp.core.system.mapper.UserSessionStatisticsMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * UserSessionStatisticeManagerImpl
 *
 * @author elvea
 */
@Service
public class UserSessionStatisticeManagerImpl extends ServiceImpl<UserSessionStatisticsMapper, UserSessionStatisticsEntity> implements UserSessionStatisticsManager {
}
