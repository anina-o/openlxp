package cn.elvea.lxp.xapi.repository;

import cn.elvea.lxp.xapi.entity.GroupEntity;
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
