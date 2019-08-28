package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.http.XAPIResponse;

import java.io.IOException;

/**
 * ActivityStateService
 *
 * @author elvea
 */
public interface ActivityStateService {

    /**
     * Get
     */
    XAPIResponse getActivityState(String activityId, String agentJson, String registration, String stateId, String since);

    /**
     * Put or Post
     */
    XAPIResponse saveActivityState(String activityId, String agentJson, String registration, String stateId, String document) throws IOException;

    /**
     * Delete
     */
    XAPIResponse deleteActivityState(String activityId, String agentJson, String stateId, String registration, String since);

}
