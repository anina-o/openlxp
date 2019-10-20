package cn.elvea.lxp.modules.activity.service;

import cn.elvea.lxp.modules.activity.dto.ActivityTypeDto;

/**
 * 活动类型服务
 *
 * @author elvea
 */
public interface ActivityTypeService {

    /**
     * 获取活动类型
     */
    ActivityTypeDto getActivityType(String type);

}
