package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import cn.elvea.lxp.xapi.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * XApiAgentController
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/agents")
public class XApiAgentController extends XApiAbstractController {

    @GetMapping
    @ResponseBody
    public XAPIResponse<Person> getAgents(
            @RequestParam("agent") String agent) {
        return XAPIResponse.success(new Person(agent));
    }

}
