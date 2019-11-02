package cn.elvea.lxp.modules.xapi.controller;

import cn.elvea.lxp.modules.xapi.http.XAPIResponse;
import cn.elvea.lxp.modules.xapi.model.Person;
import io.swagger.annotations.Api;
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
@Api(tags = "XApi Agents Resource")
public class XApiAgentController extends XApiAbstractController {

    @GetMapping
    @ResponseBody
    public XAPIResponse<Person> getAgents(
            @RequestParam("agent") String agent) {
        return XAPIResponse.success(new Person(agent));
    }

}
