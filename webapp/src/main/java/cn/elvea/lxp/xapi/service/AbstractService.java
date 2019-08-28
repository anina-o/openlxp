package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.repository.ActivityProfileRepository;
import cn.elvea.lxp.xapi.repository.ActivityStateRepository;
import cn.elvea.lxp.xapi.repository.AgentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * AbstractService
 *
 * @author elvea
 */
public abstract class AbstractService {
    /**
     * ActivityStateRepository
     */
    @Autowired
    protected ActivityStateRepository activityStateRepository;

    /**
     * ActivityStateRepository
     */
    @Autowired
    protected AgentProfileRepository agentProfileRepository;

    /**
     * ActivityProfileRepository
     */
    @Autowired
    protected ActivityProfileRepository activityProfileRepository;

    /**
     * MongoTemplate
     */
    @Autowired
    protected MongoTemplate mongoTemplate;
}
