package cn.elvea.lxp.modules.resource.service;

import cn.elvea.lxp.BaseTests;
import cn.elvea.lxp.modules.resource.dto.ResourceTypeDto;
import cn.elvea.lxp.modules.resource.type.ResourceTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ResourceTypeServiceTests
 *
 * @author elvea
 */
public class ResourceTypeServiceTests extends BaseTests {

    @Autowired
    ResourceTypeService resourceTypeService;

    @Test
    void findTest() {
        this.resourceTypeService.getResourceType(ResourceTypeEnum.AUDIO.getCode());
        ResourceTypeDto resourceType = this.resourceTypeService.getResourceType(ResourceTypeEnum.AUDIO.getCode());
        Assertions.assertNotNull(resourceType);
        this.resourceTypeService.getResourceType(ResourceTypeEnum.AUDIO.getCode());
    }

}
