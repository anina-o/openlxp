package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
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
    public XAPIResponse getAgentProfile(@RequestParam("agent") String agentJson,
                                        @RequestParam(name = "profileId", required = false) String profileId,
                                        @RequestParam(name = "since", required = false) String since) {
        return agentProfileService.getAgentProfile(agentJson, profileId, since);
    }

    /**
     * Put or Post
     */
    @PutMapping
    @PostMapping
    @ResponseBody
    public XAPIResponse putAgentProfile(@RequestParam("agent") String agentJson,
                                        @RequestParam(name = "profileId", required = false, defaultValue = "") String profileId,
                                        @RequestBody String bodyJson) throws Exception {
        return XAPIResponse.success(agentProfileService.saveAgentProfile(agentJson, profileId, bodyJson));
    }

    /**
     * Delete
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteAgentProfile(@RequestParam("agent") String agentJson,
                                           @RequestParam(name = "profileId", required = false) String profileId,
                                           @RequestParam(name = "since", required = false) String since) {
        return this.agentProfileService.deleteAgentProfile(agentJson, profileId, since);
    }

}
