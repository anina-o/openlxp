package cn.elvea.lxp.xapi.service.document;

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
