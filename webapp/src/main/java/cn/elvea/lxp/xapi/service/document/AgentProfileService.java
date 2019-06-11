package cn.elvea.lxp.xapi.service.document;

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

    /**
     * putAgentProfile
     *
     * @param agent     String
     * @param profileId String
     */
    void putAgentProfile(String agent, String profileId) throws Exception;

    /**
     * postAgentProfile
     *
     * @param agent     String
     * @param profileId String
     */
    void postAgentProfile(String agent, String profileId) throws Exception;

    /**
     * deleteAgentProfile
     *
     * @param agent     String
     * @param profileId String
     */
    void deleteAgentProfile(String agent, String profileId) throws Exception;

}
