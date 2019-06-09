package cn.elvea.openlrs.xapi.repository;

import cn.elvea.openlrs.xapi.entity.GroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * GroupRepository
 *
 * @author elvea
 */
@Repository
public interface GroupRepository extends MongoRepository<GroupEntity, String> {
}
