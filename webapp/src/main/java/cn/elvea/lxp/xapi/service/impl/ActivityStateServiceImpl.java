package cn.elvea.lxp.xapi.service.impl;

import cn.elvea.lxp.xapi.entity.ActivityStateEntity;
import cn.elvea.lxp.xapi.model.Actor;
import cn.elvea.lxp.xapi.model.Agent;
import cn.elvea.lxp.xapi.service.ActivityStateService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ActivityStateServiceImpl
 *
 * @author elvea
 * @see ActivityStateService
 */
@Service
public class ActivityStateServiceImpl extends AbstractXApiService implements ActivityStateService {

    /**
     * @see ActivityStateService#getActivityState(String, String, String, String)
     */
    @Override
    public String getActivityState(String activityId, String agentJson, String registration, String stateId) {
        Criteria criteria = new Criteria().and("activityId").is(activityId).and("stateId").is(stateId);
        //
        processAgentCriteria(criteria, agentJson);
        //
        if (StringUtils.isNotEmpty(registration)) {
            criteria.and("registration").is(registration);
        }
        Query query = new Query(criteria);
        ActivityStateEntity entity = this.mongoTemplate.findOne(query, ActivityStateEntity.class);
        return entity != null ? entity.getContent() : "";
    }

    /**
     * @see ActivityStateService#getActivityStateList(String, String, String, String)
     */
    @Override
    public List<String> getActivityStateList(String activityId, String agentJson, String registration, String since) {
        Criteria criteria = new Criteria().and("activityId").is(activityId);
        //
        processAgentCriteria(criteria, agentJson);
        //
        if (StringUtils.isNotEmpty(registration)) {
            criteria.and("registration").is(registration);
        }
        //
        Query query = new Query(criteria);
        List<ActivityStateEntity> entityList = this.mongoTemplate.find(query, ActivityStateEntity.class);
        return entityList.stream().map(ActivityStateEntity::getStateId).collect(Collectors.toList());
    }

    /**
     * @see ActivityStateService#saveActivityState(String, String, String, String, String)
     */
    @Override
    public void saveActivityState(String activityId, String agentJson, String registration, String stateId, String content) {
        Criteria criteria = new Criteria().and("activityId").is(activityId).and("stateId").is(stateId);
        //
        processAgentCriteria(criteria, agentJson);
        //
        if (StringUtils.isNotEmpty(registration)) {
            criteria.and("registration").is(registration);
        }
        Query query = new Query();
        query.addCriteria(criteria);
        ActivityStateEntity entity = this.mongoTemplate.findOne(query, ActivityStateEntity.class);
        if (entity != null) {
            entity.setContent(content);
            entity.setUpdatedAt(new Date());
            entity.setActive(Boolean.TRUE);
        } else {
            entity = new ActivityStateEntity();
            entity.setStateId(stateId);
            entity.setActivityId(activityId);
            entity.setAgent((Agent) Actor.fromJson(agentJson));
            entity.setRegistration(registration);
            entity.setContent(content);
            entity.setCreatedAt(new Date());
            entity.setUpdatedAt(new Date());
            entity.setActive(Boolean.TRUE);
        }
        this.activityStateRepository.save(entity);
    }

    @Override
    public void deleteActivityState(String activityId, String agentJson, String stateId, String registration) {
        Criteria criteria = Criteria.where("activityId").is(activityId).and("stateId").is(stateId);
        //
        processAgentCriteria(criteria, agentJson);
        //
        if (StringUtils.isNotEmpty(registration)) {
            criteria.and("registration").is(registration);
        }

        Query query = new Query(criteria);
        ActivityStateEntity entity = this.mongoTemplate.findOne(query, ActivityStateEntity.class);
        if (entity != null) {
            this.activityStateRepository.delete(entity);
        }
    }

    @Override
    public void deleteActivityStateList(String activityId, String agentJson, String registration, String since) {
        Criteria criteria = Criteria.where("activityId").is(activityId);
        //
        processAgentCriteria(criteria, agentJson);
        //
        if (StringUtils.isNotEmpty(registration)) {
            criteria.and("registration").is(registration);
        }

        Query query = new Query(criteria);
        List<ActivityStateEntity> entityList = this.mongoTemplate.find(query, ActivityStateEntity.class);
        if (CollectionUtils.isNotEmpty(entityList)) {
            this.activityStateRepository.deleteAll(entityList);
        }
    }

}