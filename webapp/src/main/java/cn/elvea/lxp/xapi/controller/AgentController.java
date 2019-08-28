package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Agents ResourceEntity
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/agents")
public class AgentController extends AbstractController {

    /**
     * Get
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse getAgents(@RequestParam("agent") String agentJson) {
        return this.agentService.getAgents(agentJson);
    }

}
