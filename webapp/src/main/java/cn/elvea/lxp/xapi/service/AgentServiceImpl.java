package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.Person;
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
    public Person getAgents(String json) {
        return new Person();
    }

}