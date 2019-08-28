package cn.elvea.lxp.xapi.repository;

import cn.elvea.lxp.xapi.entity.ActivityProfileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * ActivityProfileRepository
 *
 * @author elvea
 */
@Repository
public interface ActivityProfileRepository extends MongoRepository<ActivityProfileEntity, String> {
}
