package cn.elvea.openlrs.xapi.repository;

import cn.elvea.openlrs.xapi.entity.ActivityEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * ActivityRepository
 *
 * @author elvea
 */
@Repository
public interface ActivityRepository extends MongoRepository<ActivityEntity, String> {
}
