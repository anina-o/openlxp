package cn.elvea.openlrs.xapi.repository;

import cn.elvea.openlrs.BaseTests;
import cn.elvea.openlrs.xapi.Activity;
import cn.elvea.openlrs.xapi.entity.ActivityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * AgentRepositoryTests
 *
 * @author elvea
 */
public class ActivityRepositoryTests extends BaseTests {

    @Autowired
    ActivityRepository activityRepository;

    @Test
    public void testCurd() {
        Activity activity = new Activity(UUID.randomUUID().toString());
        ActivityEntity activityEntity = new ActivityEntity();
        BeanUtils.copyProperties(activity, activityEntity);
        this.activityRepository.save(activityEntity);
    }

}
