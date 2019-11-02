package cn.elvea.lxp.modules.xapi.controller;

import cn.elvea.lxp.modules.xapi.http.XAPIResponse;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * XApiAgentProfileController
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/agents/profile")
@Api(tags = "XApi Agents Profile Resource")
public class XApiAgentProfileController extends XApiAbstractController {

    @GetMapping
    @ResponseBody
    public XAPIResponse<?> getAgentProfile(@RequestParam("agent") String agent,
                                           @RequestParam(name = "profileId", required = false) String profileId,
                                           @RequestParam(name = "since", required = false) String since) {
        if (StringUtils.isNotEmpty(profileId)) {
            return XAPIResponse.success(this.agentProfileService.getAgentProfile(agent, profileId));
        } else {
            return XAPIResponse.success(this.agentProfileService.getAgentProfileList(agent, since));
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
