package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.model.Activity;
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
