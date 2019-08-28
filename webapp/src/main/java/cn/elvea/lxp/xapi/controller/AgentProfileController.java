package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Agent Profile ResourceEntity
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/agents/profile")
public class AgentProfileController extends AbstractController {

    /**
     * Get
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse getAgentProfile(
            @RequestParam("agent") String agentJson,
            @RequestParam(name = "profileId", required = false) String profileId,
            @RequestParam(name = "since", required = false) String since
    ) throws Exception {
        agentProfileService.getAgentProfile(agentJson, profileId);
        return XAPIResponse.success();
    }

    /**
     * Put
     */
    @PutMapping
    @ResponseBody
    public XAPIResponse putAgentProfile(
            @RequestParam("agent") String agent,
            @RequestParam(name = "profileId", required = false, defaultValue = "") String profileId,
            @RequestBody String bodyJson
    ) throws Exception {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Post
     */
    @PostMapping
    @ResponseBody
    public XAPIResponse postAgentProfile(
            @RequestParam("agent") String agent,
            @RequestParam(name = "profileId", required = false, defaultValue = "") String profileId,
            @RequestBody String bodyJson
    ) {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Delete
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteAgentProfile(
            @RequestParam("agent") String agentJson,
            @RequestParam(name = "profileId", required = false) String profileId,
            @RequestParam(name = "since", required = false) String since
    ) {
        if (StringUtils.isNotEmpty(profileId)) {
            // 当同时指定activityId和profileId时，删除唯一文档定义
            this.agentProfileService.deleteAgentProfile(agentJson, profileId);
        } else {
            // 当未指定profileId时，删除所有文档定义的ID集合
            // 当since不为空时，只删除since后面的所有文档定义的ID集合
            this.agentProfileService.deleteAgentProfiles(agentJson, profileId);
        }
        return XAPIResponse.success();
    }

}
