package cn.elvea.lxp.modules.activity.manager;

import cn.elvea.lxp.modules.activity.entity.ActivityTypeEntity;

/**
 * ActivityTypeManager
 *
 * @author elvea
 */
public interface ActivityTypeManager {

    ActivityTypeEntity findByType(String type);

    ActivityTypeEntity findById(Long id);

}
