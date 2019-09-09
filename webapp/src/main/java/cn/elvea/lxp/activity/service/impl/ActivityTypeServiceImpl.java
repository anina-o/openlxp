package cn.elvea.lxp.activity.service.impl;

import cn.elvea.lxp.activity.dto.ActivityTypeDto;
import cn.elvea.lxp.activity.entity.ActivityTypeEntity;
import cn.elvea.lxp.activity.repository.ActivityTypeRepository;
import cn.elvea.lxp.activity.service.ActivityTypeService;
import cn.elvea.lxp.common.utils.ConvertUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 活动类型服务实现类
 *
 * @author elvea
 */
@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    @Autowired
    ActivityTypeRepository activityTypeRepository;

    /**
     * @see ActivityTypeService#getActivityType(String)
     */
    @Override
    public ActivityTypeDto getActivityType(String type) {
        Optional<ActivityTypeEntity> entity = this.activityTypeRepository.findByType(type);
        return entity.map(this::getActivityType).orElse(null);
    }

    private ActivityTypeDto getActivityType(@NotNull ActivityTypeEntity entity) {
        return ConvertUtils.sourceToTarget(entity, ActivityTypeDto.class);
    }

}
