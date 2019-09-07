package cn.elvea.lxp.resource.service;

import cn.elvea.lxp.common.utils.ConvertUtils;
import cn.elvea.lxp.resource.dto.ResourceTypeDto;
import cn.elvea.lxp.resource.entity.ResourceTypeEntity;
import cn.elvea.lxp.resource.repository.ResourceTypeRepository;
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
    ResourceTypeRepository resourceTypeRepository;

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
