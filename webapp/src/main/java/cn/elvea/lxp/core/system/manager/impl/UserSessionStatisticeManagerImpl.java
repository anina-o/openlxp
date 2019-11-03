package cn.elvea.lxp.core.system.manager.impl;

import cn.elvea.lxp.core.system.entity.UserSessionEntity;
import cn.elvea.lxp.core.system.entity.UserSessionStatisticsEntity;
import cn.elvea.lxp.core.system.manager.UserSessionStatisticsManager;
import cn.elvea.lxp.core.system.mapper.UserSessionStatisticsMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * UserSessionStatisticeManagerImpl
 *
 * @author elvea
 */
@Service
public class UserSessionStatisticeManagerImpl extends ServiceImpl<UserSessionStatisticsMapper, UserSessionStatisticsEntity> implements UserSessionStatisticsManager {

    /**
     * @see UserSessionStatisticsManager#saveUserSessionStatistics(UserSessionEntity, long)
     */
    @Override
    public void saveUserSessionStatistics(UserSessionEntity session, long totalTime) {
        UserSessionStatisticsEntity condition = new UserSessionStatisticsEntity();
        condition.setUserId(session.getUserId());
        condition.setYear(session.getYear());
        condition.setMonth(session.getMonth());
        condition.setDay(session.getDay());

        UserSessionStatisticsEntity entity = getOne(new QueryWrapper<>(condition));
        if (entity == null) {
            entity = new UserSessionStatisticsEntity();
            entity.setUserId(session.getUserId());
            entity.setYear(session.getYear());
            entity.setMonth(session.getMonth());
            entity.setDay(session.getDay());
            entity.setFirstAccessDatetime(session.getLastAccessDatetime());
            entity.setLastAccessDatetime(session.getLastAccessDatetime());
            entity.setTotalTime(totalTime);
            entity.setCreatedAt(new Date());
            entity.setCreatedBy(session.getUserId());
            entity.setModifiedAt(new Date());
            entity.setModifiedBy(session.getUserId());

            this.save(entity);
        } else {
            entity.setTotalTime(entity.getTotalTime() + totalTime);
            entity.setLastAccessDatetime(session.getLastAccessDatetime());
            entity.setModifiedAt(new Date());
            entity.setModifiedBy(session.getUserId());

            this.updateById(entity);
        }

    }
}
