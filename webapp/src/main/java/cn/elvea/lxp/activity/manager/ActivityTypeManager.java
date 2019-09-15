package cn.elvea.lxp.activity.manager;

import cn.elvea.lxp.activity.entity.ActivityTypeEntity;

/**
 * ActivityTypeManager
 *
 * @author elvea
 */
public interface ActivityTypeManager {

    ActivityTypeEntity findByType(String type);

    ActivityTypeEntity findById(Long id);

}
