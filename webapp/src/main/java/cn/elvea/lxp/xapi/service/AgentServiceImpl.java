package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.Person;
import cn.elvea.lxp.xapi.http.XAPIResponse;
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
    public XAPIResponse<?> getAgents(String json) {
        return XAPIResponse.success(new Person());
    }

}
