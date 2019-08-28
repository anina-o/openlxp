package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.Actor;
import cn.elvea.lxp.xapi.Agent;
import cn.elvea.lxp.xapi.entity.ActivityStateEntity;
import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ActivityStateServiceImpl
 *
 * @author elvea
 */
@Service
public class ActivityStateServiceImpl extends AbstractService implements ActivityStateService {

    /**
     * @see ActivityStateService#getActivityState(String, String, String, String, String)
     */
    @Override
    public XAPIResponse getActivityState(String activityId, String agentJson, String registration, String stateId, String since) {
        if (StringUtils.isNotEmpty(stateId)) {
            Criteria criteria = new Criteria();
            criteria.andOperator(Criteria.where("activityId").is(activityId));
            criteria.andOperator(Criteria.where("stateId").is(stateId));
            Query query = new Query(criteria);
            ActivityStateEntity entity = this.mongoTemplate.findOne(query, ActivityStateEntity.class);
            return XAPIResponse.success(entity != null ? entity.getContent() : "");
        } else {
            ActivityStateEntity entity = new ActivityStateEntity();
            entity.setActivityId(activityId);
            Example<ActivityStateEntity> example = Example.of(entity);
            List<ActivityStateEntity> entityList = this.activityStateRepository.findAll(example);
            return XAPIResponse.success(entityList.stream().map(ActivityStateEntity::getStateId).collect(Collectors.toList()));
        }
    }

    @Override
    public XAPIResponse saveActivityState(String activityId, String agentJson, String registration, String stateId, String content) throws IOException {
        ActivityStateEntity entity = new ActivityStateEntity();
        entity.setStateId(stateId);
        entity.setActivityId(activityId);
        entity.setAgent((Agent) Actor.fromJson(agentJson));
        entity.setRegistration(registration);
        entity.setContent(content);
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        entity.setActive(Boolean.TRUE);
        this.activityStateRepository.save(entity);
        return XAPIResponse.success();
    }

    @Override
    public XAPIResponse deleteActivityState(String activityId, String agentJson, String stateId, String registration, String since) {
        return null;
    }

}
