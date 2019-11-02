package cn.elvea.lxp.modules.xapi.repository;

import cn.elvea.lxp.modules.xapi.entity.AgentProfileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * AgentProfileRepository
 *
 * @author elvea
 */
public interface AgentProfileRepository extends MongoRepository<AgentProfileEntity, String> {
}
