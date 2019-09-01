package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.model.Person;
import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * AgentController
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/agents")
public class AgentController extends AbstractController {
    @GetMapping
    @ResponseBody
    public XAPIResponse<Person> getAgents(
            @RequestParam("agent") String agent) {
        return XAPIResponse.success(this.agentService.getAgents(agent));
    }
}
