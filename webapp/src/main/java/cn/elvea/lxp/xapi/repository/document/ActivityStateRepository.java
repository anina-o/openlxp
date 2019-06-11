package cn.elvea.lxp.xapi.repository.document;

import cn.elvea.lxp.xapi.entity.document.ActivityStateEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ActivityStateRepository
 *
 * @author elvea
 */
public interface ActivityStateRepository extends MongoRepository<ActivityStateEntity, String> {
}
