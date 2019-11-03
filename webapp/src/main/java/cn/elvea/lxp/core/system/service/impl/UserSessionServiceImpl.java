package cn.elvea.lxp.core.system.service.impl;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.system.dto.UserLoginHistoryDto;
import cn.elvea.lxp.core.system.dto.UserSessionDto;
import cn.elvea.lxp.core.system.dto.UserSessionHistoryDto;
import cn.elvea.lxp.core.system.entity.UserLoginHistoryEntity;
import cn.elvea.lxp.core.system.entity.UserSessionEntity;
import cn.elvea.lxp.core.system.entity.UserSessionHistoryEntity;
import cn.elvea.lxp.core.system.manager.UserLoginHistoryManager;
import cn.elvea.lxp.core.system.manager.UserSessionHistoryManager;
import cn.elvea.lxp.core.system.manager.UserSessionManager;
import cn.elvea.lxp.core.system.manager.UserSessionStatisticsManager;
import cn.elvea.lxp.core.system.service.UserSessionAmqpService;
import cn.elvea.lxp.core.system.service.UserSessionService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * UserSessionServiceImpl
 *
 * @author elvea
 */
@Service
public class UserSessionServiceImpl implements UserSessionService {

    @Autowired
    private UserSessionAmqpService userSessionAmqpService;

    @Autowired
    private UserLoginHistoryManager userLoginHistoryManager;

    @Autowired
    private UserSessionManager userSessionManager;

    @Autowired
    private UserSessionStatisticsManager userSessionStatisticsManager;

    @Autowired
    private UserSessionHistoryManager userSessionHistoryManager;

    /**
     * @see UserSessionService#getSession(String)
     */
    @Override
    public UserSessionDto getSession(String sessionId) {
        return null;
    }

    /**
     * @see UserSessionService#createSession(UserSessionDto)
     */
    @Override
    public void createSession(UserSessionDto sessionDto) {
        Date curDate = new Date();
        DateTime curDateTime = new DateTime(curDate);
        //
        sessionDto.setStartDatetime(curDate);
        sessionDto.setLastAccessDatetime(curDate);
        sessionDto.setYear(curDateTime.getYear());
        sessionDto.setMonth(curDateTime.getMonthOfYear());
        sessionDto.setDay(curDateTime.getDayOfMonth());
        sessionDto.setHour(curDateTime.getHourOfDay());
        sessionDto.setMinute(curDateTime.getMinuteOfHour());
        //
        sessionDto.setAction("create");
        this.userSessionAmqpService.saveUserSession(sessionDto);
    }

    /**
     * @see UserSessionService#updateSession(String)
     */
    @Override
    public void updateSession(String sessionId) {
        Date curDate = new Date();
        //
        UserSessionDto sessionDto = new UserSessionDto();
        sessionDto.setSessionId(sessionId);
        sessionDto.setLastAccessDatetime(curDate);
        //
        sessionDto.setAction("update");
        this.userSessionAmqpService.saveUserSession(sessionDto);
    }

    /**
     * @see UserSessionService#removeSession(String)
     */
    @Override
    public void removeSession(String sessionId) {
        Date curDate = new Date();
        //
        UserSessionDto sessionDto = new UserSessionDto();
        sessionDto.setSessionId(sessionId);
        sessionDto.setLastAccessDatetime(curDate);
        sessionDto.setEndDatetime(curDate);
        //
        sessionDto.setAction("delete");
        this.userSessionAmqpService.saveUserSession(sessionDto);
    }

    /**
     * @see UserSessionService#saveUserSession(UserSessionDto)
     */
    @Override
    public void saveUserSession(UserSessionDto userSessionDto) {
        if (userSessionDto.isCreate()) {
            UserSessionEntity entity = ConvertUtils.sourceToTarget(userSessionDto, UserSessionEntity.class);
            this.userSessionManager.saveUserSession(entity);
        } else if (userSessionDto.isUpdate() || userSessionDto.isDelete()) {
            UserSessionEntity entity = this.userSessionManager.getUserSession(userSessionDto.getSessionId());
            if (entity != null) {
                // 计算会话时长
                long time = calcCurTotalTime(entity, userSessionDto);
                entity.setTotalTime((entity.getTotalTime() == null ? 0L : entity.getTotalTime()) + time);
                // 更新会话记录
                entity.setLastAccessDatetime(userSessionDto.getLastAccessDatetime());
                if (userSessionDto.isDelete()) {
                    entity.setEndDatetime(userSessionDto.getEndDatetime());
                    this.userSessionManager.removeUserSession(entity);
                } else {
                    this.userSessionManager.saveUserSession(entity);
                }
                // 更新用户在线时长统计信息
                userSessionStatisticsManager.saveUserSessionStatistics(entity, time);
            }
        }
    }

    /**
     * @see UserSessionService#saveUserSessionHistory(UserSessionHistoryDto)
     */
    @Override
    public void saveUserSessionHistory(UserSessionHistoryDto userSessionHistoryDto) {
        UserSessionHistoryEntity entity = ConvertUtils.sourceToTarget(userSessionHistoryDto, UserSessionHistoryEntity.class);
        this.userSessionHistoryManager.saveUserSessionHistory(entity);
    }

    /**
     * @see UserSessionService#saveUserLoginHistory(UserLoginHistoryDto)
     */
    @Override
    public void saveUserLoginHistory(UserLoginHistoryDto userLoginHistoryDto) {
        UserLoginHistoryEntity userLoginHistoryEntity = ConvertUtils.sourceToTarget(userLoginHistoryDto, UserLoginHistoryEntity.class);
        userLoginHistoryManager.saveUserLoginHistory(userLoginHistoryEntity);
    }

    /**
     * 计算当前操作的在线时长
     */
    private long calcCurTotalTime(UserSessionEntity entity, UserSessionDto userSessionDto) {
        long time = 0;
        if (entity.getLastAccessDatetime() != null && userSessionDto.getLastAccessDatetime() != null) {
            time = userSessionDto.getLastAccessDatetime().getTime() - entity.getLastAccessDatetime().getTime();
            // 如果前后时间计算超过1个小时，那判定当前会话在这时间点内无活动，不统计时长
            time = (time > (3600 * 1000)) ? 0 : time;
        }
        time = (time >= 0) ? time : 0;
        return time;
    }
}
