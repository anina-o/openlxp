package cn.elvea.lxp.core.system.service.impl;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.core.system.dto.UserLoginHistoryDto;
import cn.elvea.lxp.core.system.dto.UserSessionDto;
import cn.elvea.lxp.core.system.entity.UserLoginHistoryEntity;
import cn.elvea.lxp.core.system.entity.UserSessionEntity;
import cn.elvea.lxp.core.system.manager.UserLoginHistoryManager;
import cn.elvea.lxp.core.system.manager.UserSessionManager;
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
        } else if (userSessionDto.isUpdate()) {
            UserSessionEntity entity = this.userSessionManager.getUserSession(userSessionDto.getSessionId());
            entity.setLastAccessDatetime(userSessionDto.getLastAccessDatetime());
            this.userSessionManager.saveUserSession(entity);
        } else if (userSessionDto.isDelete()) {
            UserSessionEntity entity = this.userSessionManager.getUserSession(userSessionDto.getSessionId());
            entity.setLastAccessDatetime(userSessionDto.getLastAccessDatetime());
            entity.setEndDatetime(userSessionDto.getEndDatetime());
            this.userSessionManager.removeUserSession(entity);
        }
    }

    /**
     * @see UserSessionService#saveUserLoginHistory(UserLoginHistoryDto)
     */
    @Override
    public void saveUserLoginHistory(UserLoginHistoryDto userLoginHistoryDto) {
        UserLoginHistoryEntity userLoginHistoryEntity = ConvertUtils.sourceToTarget(userLoginHistoryDto, UserLoginHistoryEntity.class);
        userLoginHistoryManager.saveUserLoginHistory(userLoginHistoryEntity);
    }

}
