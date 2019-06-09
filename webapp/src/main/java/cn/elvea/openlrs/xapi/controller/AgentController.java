package cn.elvea.openlrs.xapi.controller;

import cn.elvea.openlrs.xapi.http.XAPIResponse;
import cn.elvea.openlrs.xapi.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Agents Resource
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/agents")
public class AgentController {

    @Autowired
    AgentService agentService;

    /**
     * Get
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse getAgents(@RequestParam("agent") String json) {
        return XAPIResponse.success(this.agentService.getAgents(json));
    }

}
