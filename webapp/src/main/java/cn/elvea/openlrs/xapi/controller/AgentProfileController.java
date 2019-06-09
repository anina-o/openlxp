package cn.elvea.openlrs.xapi.controller;

import cn.elvea.openlrs.xapi.http.XAPIResponse;
import cn.elvea.openlrs.xapi.service.AgentProfileService;
import cn.elvea.openlrs.xapi.service.XAPIService;
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
                                        @RequestParam(name = "profileId", required = false) String profileId) {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Put
     */
    @PutMapping
    @ResponseBody
    public XAPIResponse putAgentProfile() {
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
