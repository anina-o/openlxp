package cn.elvea.lxp.xapi.service;

import java.util.List;

/**
 * AgentProfileService
 *
 * @author elvea
 */
public interface AgentProfileService {

    /**
     * getAgentProfile
     *
     * @param activityId String
     * @param profileId  String
     */
    String getAgentProfile(String activityId, String profileId);

    /**
     * getAgentProfile
     *
     * @param activityId String
     * @param profileId  String
     */
    List<String> getAgentProfileIdList(String activityId, String profileId);

    /**
     * getAgentProfile
     *
     * @param activityId String
     * @param profileId  String
     */
    void putAgentProfile(String activityId, String profileId, String document);

    /**
     * getAgentProfile
     *
     * @param activityId String
     * @param profileId  String
     */
    void postAgentProfile(String activityId, String profileId, String document);

    /**
     * getAgentProfile
     *
     * @param activityId String
     * @param profileId  String
     */
    void deleteAgentProfile(String activityId, String profileId);

    /**
     * getAgentProfile
     *
     * @param activityId String
     * @param since      String
     */
    void deleteAgentProfiles(String activityId, String since);

}
