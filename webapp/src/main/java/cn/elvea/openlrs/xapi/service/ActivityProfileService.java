package cn.elvea.openlrs.xapi.service;

import java.io.IOException;

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
    void getActivityProfile(String activityId, String profileId) throws IOException;

}
