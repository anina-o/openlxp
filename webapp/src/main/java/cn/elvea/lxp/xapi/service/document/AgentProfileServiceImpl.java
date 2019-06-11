package cn.elvea.lxp.xapi.service.document;

import cn.elvea.lxp.xapi.Agent;
import cn.elvea.lxp.xapi.XApiUtils;
import cn.elvea.lxp.xapi.exception.XAPIException;
import cn.elvea.lxp.xapi.repository.AgentRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AgentProfileServiceImpl
 *
 * @author elvea
 */
@Service
@Slf4j
public class AgentProfileServiceImpl implements AgentProfileService {

    @Autowired
    AgentRepository agentRepository;

    /**
     * @see AgentProfileService#getAgentProfile(String, String)
     */
    @Override
    public void getAgentProfile(String agentJson, String profileId) throws XAPIException {
        if (Strings.isNotEmpty(profileId)) {

        }
        Agent agent = XApiUtils.extractAgentObject(agentJson);
        String uniqueIdentifier = XApiUtils.extractAgentUniqueIdentifier(agent);
    }

    /**
     * @see AgentProfileService#putAgentProfile(String, String)
     */
    @Override
    public void putAgentProfile(String agent, String profileId) throws Exception {

    }

    /**
     * @see AgentProfileService#postAgentProfile(String, String)
     */
    @Override
    public void postAgentProfile(String agent, String profileId) throws Exception {

    }

    /**
     * @see AgentProfileService#deleteAgentProfile(String, String)
     */
    @Override
    public void deleteAgentProfile(String agent, String profileId) throws Exception {

    }

}
