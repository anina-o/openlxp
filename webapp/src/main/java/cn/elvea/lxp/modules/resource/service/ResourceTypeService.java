package cn.elvea.lxp.modules.resource.service;

import cn.elvea.lxp.modules.resource.dto.ResourceTypeDto;

/**
 * ResourceTypeService
 *
 * @author elvea
 */
public interface ResourceTypeService {

    /**
     * 获取资源类型
     */
    ResourceTypeDto getResourceType(String type);

}
