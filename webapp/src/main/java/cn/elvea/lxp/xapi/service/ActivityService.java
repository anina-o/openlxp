package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.http.XAPIResponse;

/**
 * ActivityService
 *
 * @author elvea
 */
public interface ActivityService {

    /**
     * Get
     */
    XAPIResponse<?> getActivities(String activityId);

}
