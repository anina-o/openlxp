package cn.elvea.lxp.xapi.service.impl;

import cn.elvea.lxp.xapi.model.Person;
import cn.elvea.lxp.xapi.exception.XAPIException;
import cn.elvea.lxp.xapi.service.AgentService;
import org.springframework.stereotype.Service;

/**
 * AgentServiceImpl
 *
 * @author elvea
 */
@Service
public class AgentServiceImpl implements AgentService {

    /**
     * @see AgentService#getAgents(String)
     */
    @Override
    public Person getAgents(String agent) throws XAPIException {
        return new Person(agent);
    }

}
