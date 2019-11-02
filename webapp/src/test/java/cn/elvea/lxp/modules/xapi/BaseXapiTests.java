package cn.elvea.lxp.modules.xapi;

import cn.elvea.lxp.common.utils.IdWorker;
import cn.elvea.lxp.modules.xapi.model.Account;
import cn.elvea.lxp.modules.xapi.model.Agent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

/**
 * BaseXapiTests
 *
 * @author elvea
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseXapiTests {

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext context;

    @Autowired
    protected IdWorker idWorker;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    /**
     * Default Activity Id
     */
    protected String defaultActivityId = "http://elvea.cn/activities/1";
    protected String testActivityId = "http://elvea.cn/activities/2";
    /**
     * Default State Id
     */
    protected String defaultStateId = "http://elvea.cn/states/1";
    protected String testStateId = "http://elvea.cn/states/2";
    /**
     * Default Profile Id
     */
    protected String defaultProfileId = "http://elvea.cn/profiles/1";
    protected String testProfileId = "http://elvea.cn/profiles/2";

    /**
     * Default Agent with account
     */
    protected Agent getDefaultAgent() {
        Agent agent = new Agent();
        agent.setName("Elvea Huang");
        agent.setAccount(new Account("http://elvea.cn/users/1", "elvea"));
        return agent;
    }

    /**
     * Agent with mbox
     */
    protected Agent getMboxAgent() {
        Agent agent = new Agent();
        agent.setName("Elvea Huang");
        agent.setMbox("mailto:elvea.huang@gmail.com");
        return agent;
    }

    /**
     * Agent with mbox_sha1sum
     */
    protected Agent getMboxSha1Agent() {
        Agent agent = new Agent();
        agent.setName("Elvea Huang");
        agent.setMboxSHA1Sum("mbox_sha1sum");
        return agent;
    }

    /**
     * Agent with open id
     */
    protected Agent getOpenIdAgent() {
        Agent agent = new Agent();
        agent.setName("Elvea Huang");
        agent.setOpenID("openid");
        return agent;
    }

}
