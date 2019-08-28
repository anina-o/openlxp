package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.http.XAPIResponse;

/**
 * AgentService
 *
 * @author elvea
 */
public interface AgentService {

    /**
     * Get
     */
    XAPIResponse<?> getAgents(String json);

}
