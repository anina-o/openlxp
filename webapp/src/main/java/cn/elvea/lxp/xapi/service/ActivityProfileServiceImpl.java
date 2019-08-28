package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.common.utils.UUIDUtils;
import cn.elvea.lxp.xapi.entity.ActivityProfileEntity;
import cn.elvea.lxp.xapi.repository.ActivityProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
     * @see ActivityProfileService#getActivityProfile(String, String)
     */
    @Override
    public String getActivityProfile(String activityId, String profileId) {
        ActivityProfileEntity condition = new ActivityProfileEntity();
        condition.setActivityId(activityId);
        condition.setProfileId(profileId);
        Example<ActivityProfileEntity> example = Example.of(condition);

        ActivityProfileEntity entity = this.activityProfileRepository.findOne(example).orElse(null);
        if (entity != null) {
            return entity.getContent();
        } else {
            return "";
        }
    }

    /**
     * @see ActivityProfileService#getActivityProfileIdList(String, String)
     */
    @Override
    public List<String> getActivityProfileIdList(String activityId, String since) {
        ActivityProfileEntity entity = new ActivityProfileEntity();
        entity.setActivityId(activityId);
        Example<ActivityProfileEntity> example = Example.of(entity);
        List<ActivityProfileEntity> entityList = this.activityProfileRepository.findAll(example);
        return entityList.stream().map(ActivityProfileEntity::getId).collect(Collectors.toList());
    }

    /**
     * @see ActivityProfileService#putActivityProfile(String, String, String)
     */
    @Override
    public void putActivityProfile(String activityId, String profileId, String content) {
        ActivityProfileEntity entity = new ActivityProfileEntity();
        entity.setId(UUIDUtils.randomUUID());
        entity.setActivityId(activityId);
        entity.setProfileId(profileId);
        entity.setContent(content);
        entity.setCreatedAt(new Date());
        entity.setUpdatedAt(new Date());
        entity.setActive(Boolean.TRUE);
        this.activityProfileRepository.save(entity);
    }

    /**
     * @see ActivityProfileService#postActivityProfile(String, String, String)
     */
    @Override
    public void postActivityProfile(String activityId, String profileId, String content) {
    }

    /**
     * @see ActivityProfileService#postActivityProfile(String, String, String)
     */
    @Override
    public void deleteActivityProfile(String activityId, String profileId) {
    }

    /**
     * @see ActivityProfileService#postActivityProfile(String, String, String)
     */
    @Override
    public void deleteActivityProfiles(String activityId, String since) {
    }

    @Autowired
    public void setActivityProfileRepository(ActivityProfileRepository activityProfileRepository) {
        this.activityProfileRepository = activityProfileRepository;
    }

}

