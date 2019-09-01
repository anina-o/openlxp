package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.entity.AgentProfileEntity;
import cn.elvea.lxp.xapi.exception.InvalidRequestException;
import cn.elvea.lxp.xapi.model.Agent;
import cn.elvea.lxp.xapi.utils.XApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * AgentProfileServiceImpl
 *
 * @author elvea
 */
@Slf4j
@Service
public class AgentProfileServiceImpl extends AbstractService implements AgentProfileService {

    /**
     * @see AgentProfileService#getSingleAgentProfile(String, String)
     */
    @Override
    public String getSingleAgentProfile(String agent, String profileId) {
        //
        Agent agentObject = XApiUtils.extractAgentObject(agent);
        //
        Criteria criteria = Criteria.where("profileId").is(profileId).and("agent").is(agentObject);
        Query query = new Query(criteria);
        //
        AgentProfileEntity entity = this.mongoTemplate.findOne(query, AgentProfileEntity.class);
        return entity != null ? entity.getContent() : "";
    }

    /**
     * @see AgentProfileService#getAgentProfileIdList(String, String)
     */
    @Override
    public List<String> getAgentProfileIdList(String agent, String since) throws InvalidRequestException {
        //
        Agent agentObject = XApiUtils.extractAgentObject(agent);
        //
        Criteria criteria = Criteria.where("agent").is(agentObject);
        if (StringUtils.isNotEmpty(since)) {
            Date sinceDateObject = XApiUtils.parseTimestamp(since);
            if (sinceDateObject != null) {
                criteria.and("createdAt").gt(sinceDateObject);
            }
        }
        Query query = new Query(criteria);
        //
        List<AgentProfileEntity> entityList = this.mongoTemplate.find(query, AgentProfileEntity.class);
        return entityList.stream().map(AgentProfileEntity::getProfileId).collect(Collectors.toList());
    }

    /**
     * @see AgentProfileService#saveAgentProfile(String, String, String)
     */
    @Override
    public void saveAgentProfile(String agent, String profileId, String content) {
        //
        Agent agentObject = XApiUtils.extractAgentObject(agent);
        //
        Criteria criteria = Criteria.where("profileId").is(profileId)
                .and("agent").is(agentObject);
        Query query = new Query();
        query.addCriteria(criteria);
        //
        AgentProfileEntity entity = this.mongoTemplate.findOne(query, AgentProfileEntity.class);
        if (entity != null) { // Update
            entity.setContent(content);
            entity.setActive(Boolean.TRUE);
        } else { // Create
            entity = new AgentProfileEntity();
            entity.setProfileId(profileId);
            entity.setAgent(agentObject);
            entity.setContent(content);
            entity.setActive(Boolean.TRUE);
        }
        this.agentProfileRepository.save(entity);
    }

    /**
     * @see AgentProfileService#deleteAgentProfile(String, String)
     */
    @Override
    public void deleteAgentProfile(String agent, String profileId) {
        //
        Agent agentObject = XApiUtils.extractAgentObject(agent);
        //
        Criteria criteria = Criteria.where("profileId").is(profileId).and("agent").is(agentObject);
        Query query = new Query(criteria);
        //
        List<AgentProfileEntity> entityList = this.mongoTemplate.find(query, AgentProfileEntity.class);
        if (CollectionUtils.isNotEmpty(entityList)) {
            this.agentProfileRepository.deleteAll(entityList);
        }
    }

}
