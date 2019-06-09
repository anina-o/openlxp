package cn.elvea.openlrs.xapi.repository;

import cn.elvea.openlrs.BaseTests;
import cn.elvea.openlrs.xapi.Agent;
import cn.elvea.openlrs.xapi.Group;
import cn.elvea.openlrs.xapi.entity.AgentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * AgentRepositoryTests
 *
 * @author elvea
 */
public class AgentRepositoryTests extends BaseTests {

    @Autowired
    AgentRepository agentRepository;

    @Test
    public void testCurd() {
        Agent agent = new Agent();
        agent.setName("Test Agent");
        AgentEntity agentEntity = new AgentEntity();
        BeanUtils.copyProperties(agent, agentEntity);
        this.agentRepository.save(agentEntity);
    }

    @Test
    public void testGroupCurd() {
        Group group = new Group();
        group.setName("Test Group");
        AgentEntity agentEntity = new AgentEntity();
        BeanUtils.copyProperties(group, agentEntity);
        this.agentRepository.save(agentEntity);
    }

}
