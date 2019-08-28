package cn.elvea.lxp.xapi.service;

import java.util.List;

/**
 * ActivityProfileService
 *
 * @author elvea
 */
public interface ActivityProfileService {

    /**
     * getActivityProfile
     *
     * @param activityId String
     * @param profileId  String
     */
    String getActivityProfile(String activityId, String profileId);

    /**
     * getActivityProfile
     *
     * @param activityId String
     * @param since      String
     */
    List<String> getActivityProfileIdList(String activityId, String since);

    /**
     * getActivityProfile
     *
     * @param activityId String
     * @param profileId  String
     */
    void putActivityProfile(String activityId, String profileId, String document);

    /**
     * getActivityProfile
     *
     * @param activityId String
     * @param profileId  String
     */
    void postActivityProfile(String activityId, String profileId, String document);

    /**
     * getActivityProfile
     *
     * @param activityId String
     * @param profileId  String
     */
    void deleteActivityProfile(String activityId, String profileId);

    /**
     * getActivityProfile
     *
     * @param activityId String
     * @param since      String
     */
    void deleteActivityProfiles(String activityId, String since);

}
