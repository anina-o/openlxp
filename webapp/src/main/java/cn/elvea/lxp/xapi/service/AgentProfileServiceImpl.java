package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.Actor;
import cn.elvea.lxp.xapi.Agent;
import cn.elvea.lxp.xapi.entity.AgentProfileEntity;
import cn.elvea.lxp.xapi.http.XAPIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;

/**
 * AgentProfileServiceImpl
 *
 * @author elvea
 */
@Service
@Slf4j
public class AgentProfileServiceImpl extends AbstractService implements AgentProfileService {

    @Override
    public XAPIResponse<?> getAgentProfile(String activityId, String agentJson, String profileId) {
        return null;
    }

    @Override
    public XAPIResponse<?> saveAgentProfile(String agentJson, String profileId, String content) throws IOException {
        AgentProfileEntity entity = new AgentProfileEntity();
        entity.setAgent((Agent) Actor.fromJson(agentJson));
        entity.setProfileId(profileId);
        entity.setContent(content);
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        entity.setActive(Boolean.TRUE);
        this.agentProfileRepository.save(entity);
        return XAPIResponse.success();
    }

    @Override
    public XAPIResponse<?> deleteAgentProfile(String agentJson, String profileId, String since) {
        return null;
    }
}
