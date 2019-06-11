package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.Activity;

import java.net.URISyntaxException;

/**
 * ActivityService
 *
 * @author elvea
 */
public interface ActivityService {

    /**
     * getActivities
     *
     * @param activityId ID
     * @return {@link Activity}
     */
    Activity getActivities(String activityId) throws URISyntaxException;

}
