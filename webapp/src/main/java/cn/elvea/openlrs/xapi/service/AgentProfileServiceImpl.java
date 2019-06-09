package cn.elvea.openlrs.xapi.service;

import cn.elvea.openlrs.xapi.Agent;
import cn.elvea.openlrs.xapi.XApiUtils;
import cn.elvea.openlrs.xapi.exception.XAPIException;
import cn.elvea.openlrs.xapi.repository.AgentRepository;
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

}
