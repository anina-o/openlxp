package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.entity.ActivityProfileEntity;
import cn.elvea.lxp.xapi.http.XAPIResponse;
import cn.elvea.lxp.xapi.repository.ActivityProfileRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ActivityProfileServiceImpl
 *
 * @author elvea
 */
@Service
public class ActivityProfileServiceImpl implements ActivityProfileService {

    /**
     * @see ActivityProfileRepository
     */
    private ActivityProfileRepository activityProfileRepository;

    /**
     * MongoTemplate
     */
    private MongoTemplate mongoTemplate;

    /**
     * @see ActivityProfileService#getActivityProfile(String, String, String)
     */
    @Override
    public XAPIResponse<?> getActivityProfile(String activityId, String profileId, String since) {
        if (StringUtils.isNotEmpty(profileId)) {
            ActivityProfileEntity condition = new ActivityProfileEntity();
            condition.setActivityId(activityId);
            condition.setProfileId(profileId);
            Example<ActivityProfileEntity> example = Example.of(condition);
            ActivityProfileEntity entity = this.activityProfileRepository.findOne(example).orElse(null);
            return XAPIResponse.success(entity != null ? entity.getContent() : "");
        } else {
            ActivityProfileEntity entity = new ActivityProfileEntity();
            entity.setActivityId(activityId);
            Example<ActivityProfileEntity> example = Example.of(entity);
            List<ActivityProfileEntity> entityList = this.activityProfileRepository.findAll(example);
            return XAPIResponse.success(entityList.stream().map(ActivityProfileEntity::getProfileId).collect(Collectors.toList()));
        }
    }

    /**
     * @see ActivityProfileService#saveActivityProfile(String, String, String)
     */
    @Override
    public XAPIResponse<?> saveActivityProfile(String activityId, String profileId, String content) {
        ActivityProfileEntity entity = new ActivityProfileEntity();
        entity.setActivityId(activityId);
        entity.setProfileId(profileId);
        entity.setContent(content);
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        entity.setActive(Boolean.TRUE);
        this.activityProfileRepository.save(entity);
        return XAPIResponse.success();
    }

    /**
     * @see ActivityProfileService#deleteActivityProfile(String, String, String)
     */
    @Override
    public XAPIResponse<?> deleteActivityProfile(String activityId, String profileId, String since) {
        return XAPIResponse.success();
    }

    @Autowired
    public void setActivityProfileRepository(ActivityProfileRepository activityProfileRepository) {
        this.activityProfileRepository = activityProfileRepository;
    }

}

