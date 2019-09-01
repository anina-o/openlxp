package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * AgentProfileController
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/agents/profile")
public class AgentProfileController extends AbstractController {

    @GetMapping
    @ResponseBody
    public XAPIResponse<?> getAgentProfile(@RequestParam("agent") String agent,
                                           @RequestParam(name = "profileId", required = false) String profileId,
                                           @RequestParam(name = "since", required = false) String since) {
        if (StringUtils.isNotEmpty(profileId)) {
            return XAPIResponse.success(this.agentProfileService.getSingleAgentProfile(agent, profileId));
        } else {
            return XAPIResponse.success(this.agentProfileService.getAgentProfileIdList(agent, since));
        }
    }

    @ResponseBody
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public XAPIResponse putAgentProfile(@RequestParam("agent") String agent,
                                        @RequestParam(name = "profileId", required = false, defaultValue = "") String profileId,
                                        @RequestBody String requestBody) {
        this.agentProfileService.saveAgentProfile(agent, profileId, requestBody);
        return XAPIResponse.success();
    }

    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteAgentProfile(@RequestParam(name = "agent") String agent,
                                           @RequestParam(name = "profileId") String profileId) {
        this.agentProfileService.deleteAgentProfile(agent, profileId);
        return XAPIResponse.success();
    }

}
