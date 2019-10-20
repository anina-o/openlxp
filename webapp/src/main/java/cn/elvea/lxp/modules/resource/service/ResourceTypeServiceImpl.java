package cn.elvea.lxp.modules.resource.service;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.modules.resource.dto.ResourceTypeDto;
import cn.elvea.lxp.modules.resource.entity.ResourceTypeEntity;
import cn.elvea.lxp.modules.resource.mapper.ResourceTypeMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ResourceTypeServiceImpl
 *
 * @author elvea
 */
@Service
public class ResourceTypeServiceImpl implements ResourceTypeService {

    @Autowired
    ResourceTypeMapper resourceTypeRepository;

    /**
     * @see ResourceTypeService#getResourceType(String)
     */
    @Override
    public ResourceTypeDto getResourceType(String type) {
        Optional<ResourceTypeEntity> entity = this.resourceTypeRepository.findByType(type);
        return entity.map(this::getResourceType).orElse(null);
    }

    private ResourceTypeDto getResourceType(@NotNull ResourceTypeEntity entity) {
        return ConvertUtils.sourceToTarget(entity, ResourceTypeDto.class);
    }

}
