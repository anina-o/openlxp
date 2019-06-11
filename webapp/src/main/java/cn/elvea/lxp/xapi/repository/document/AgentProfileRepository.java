package cn.elvea.lxp.xapi.repository.document;

import cn.elvea.lxp.xapi.entity.document.AgentProfileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * AgentProfileRepository
 *
 * @author elvea
 */
public interface AgentProfileRepository extends MongoRepository<AgentProfileEntity, String> {
}
