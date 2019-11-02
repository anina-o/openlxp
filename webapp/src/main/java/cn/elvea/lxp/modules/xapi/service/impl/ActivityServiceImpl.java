package cn.elvea.lxp.modules.xapi.service.impl;

import cn.elvea.lxp.modules.xapi.model.Activity;
import cn.elvea.lxp.modules.xapi.service.ActivityService;
import org.springframework.stereotype.Service;

/**
 * ActivityServiceImpl
 *
 * @author elvea
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    /**
     * @see ActivityService#getActivities(String)
     */
    @Override
    public Activity getActivities(String activityId) {
        return new Activity(activityId);
    }

}
