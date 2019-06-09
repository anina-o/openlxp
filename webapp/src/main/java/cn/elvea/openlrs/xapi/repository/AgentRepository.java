package cn.elvea.openlrs.xapi.repository;

import cn.elvea.openlrs.xapi.entity.AgentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * AgentRepository
 *
 * @author elvea
 */
@Repository
public interface AgentRepository extends MongoRepository<AgentEntity, String> {
}
