package cn.elvea.openlrs.xapi.service;

import cn.elvea.openlrs.xapi.Activity;

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
