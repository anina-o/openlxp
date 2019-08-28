package cn.elvea.lxp.xapi.repository;

import cn.elvea.lxp.xapi.entity.ActivityStateEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ActivityStateRepository
 *
 * @author elvea
 */
public interface ActivityStateRepository extends MongoRepository<ActivityStateEntity, String> {
}
