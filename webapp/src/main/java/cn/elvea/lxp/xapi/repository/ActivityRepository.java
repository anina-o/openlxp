package cn.elvea.lxp.xapi.repository;

import cn.elvea.lxp.xapi.entity.ActivityEntity;
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
