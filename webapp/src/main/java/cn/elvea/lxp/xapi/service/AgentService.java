package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.Person;

/**
 * AgentService
 *
 * @author elvea
 */
public interface AgentService {

    /**
     * getAgents
     *
     * @param json 参数
     * @return {@link Person}
     */
    Person getAgents(String json);

}
