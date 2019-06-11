package cn.elvea.lxp.xapi.repository.document;

import cn.elvea.lxp.xapi.entity.document.ActivityProfileEntity;
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
