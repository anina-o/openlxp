package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.http.XAPIResponse;

import java.io.IOException;

/**
 * AgentProfileService
 *
 * @author elvea
 */
public interface AgentProfileService {

    /**
     * 查询
     */
    XAPIResponse<?> getAgentProfile(String activityId, String agentJson, String profileId);

    /**
     * 保存或者更新
     */
    XAPIResponse<?> saveAgentProfile(String activityId, String profileId, String content) throws IOException;

    /**
     * 删除
     */
    XAPIResponse<?> deleteAgentProfile(String agentJson, String profileId, String since);

}
