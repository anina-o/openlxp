package cn.elvea.lxp.xapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AgentProfileServiceImpl
 *
 * @author elvea
 */
@Service
@Slf4j
public class AgentProfileServiceImpl implements AgentProfileService {

    @Override
    public String getAgentProfile(String activityId, String profileId) {
        return null;
    }

    @Override
    public List<String> getAgentProfileIdList(String activityId, String profileId) {
        return null;
    }

    @Override
    public void putAgentProfile(String activityId, String profileId, String document) {

    }

    @Override
    public void postAgentProfile(String activityId, String profileId, String document) {

    }

    @Override
    public void deleteAgentProfile(String activityId, String profileId) {

    }

    @Override
    public void deleteAgentProfiles(String activityId, String since) {

    }
}
