package cn.elvea.lxp.xapi.service;

/**
 * ActivityStateService
 *
 * @author elvea
 */
public interface ActivityStateService {

    /**
     * getActivityState
     *
     * @param activityId   String
     * @param agent        String
     * @param registration String
     * @param stateId      String
     * @param since        String
     */
    void getActivityState(String activityId, String agent, String registration, String stateId, String since);

}
