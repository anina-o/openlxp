package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import cn.elvea.lxp.xapi.service.document.AgentProfileService;
import cn.elvea.lxp.xapi.service.XAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Agent Profile Resource
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/agents/profile")
public class AgentProfileController {

    @Autowired
    XAPIService xapiService;

    @Autowired
    AgentProfileService agentProfileService;

    /**
     * Get
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse getAgentProfile(@RequestParam("agent") String agent,
                                        @RequestParam(name = "profileId", required = false) String profileId) throws Exception {
        agentProfileService.getAgentProfile(agent, profileId);
        return XAPIResponse.success();
    }

    /**
     * Put
     */
    @PutMapping
    @ResponseBody
    public XAPIResponse putAgentProfile(@RequestParam("agent") String agent,
                                        @RequestParam(name = "profileId", required = false) String profileId) throws Exception {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Post
     */
    @PostMapping
    @ResponseBody
    public XAPIResponse postAgentProfile() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Delete
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteAgentProfile() {
        return XAPIResponse.success(this.xapiService.about());
    }

}
