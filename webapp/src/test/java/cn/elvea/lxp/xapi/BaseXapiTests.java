package cn.elvea.lxp.xapi;

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

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    /**
     * Default Activity Id
     */
    protected String activityId = "http://elvea.cn/activities/1";
    /**
     * Default State Id
     */
    protected String stateId = "http://elvea.cn/states/1";
    /**
     * Default Profile Id
     */
    protected String profileId = "http://elvea.cn/profiles/1";

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
