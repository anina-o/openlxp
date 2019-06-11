package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.Activity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.UUID;

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
    public Activity getActivities(String activityId) throws URISyntaxException {
        return new Activity(UUID.randomUUID().toString());
    }

}
