package cn.elvea.lxp.resource.service;

import cn.elvea.lxp.resource.dto.ResourceTypeDto;

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
