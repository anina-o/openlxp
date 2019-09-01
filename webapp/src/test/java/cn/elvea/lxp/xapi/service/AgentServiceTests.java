package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.model.Agent;
import cn.elvea.lxp.xapi.BaseXapiTests;
import cn.elvea.lxp.xapi.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AgentServiceTests
 *
 * @author elvea
 */
public class AgentServiceTests extends BaseXapiTests {

    @Autowired
    private AgentService agentService;

    @Test
    public void agentTests() {
        Agent agent = getMboxAgent();
        Person person = this.agentService.getAgents(agent.toJson());
        Assertions.assertTrue(person.getName().contains(agent.getName()));
    }

}
