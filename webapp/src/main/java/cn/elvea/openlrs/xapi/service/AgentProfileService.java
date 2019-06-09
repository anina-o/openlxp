package cn.elvea.openlrs.xapi.service;

/**
 * AgentProfileService
 *
 * @author elvea
 */
public interface AgentProfileService {

    /**
     * getAgentProfile
     *
     * @param agent     String
     * @param profileId String
     */
    void getAgentProfile(String agent, String profileId) throws Exception;

}
