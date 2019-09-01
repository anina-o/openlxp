package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 基础控制器
 *
 * @author elvea
 */
public abstract class AbstractController {
    /**
     * ObjectMapper
     */
    ObjectMapper objectMapper;

    /**
     * XAPIService
     */
    AboutService xapiService;

    /**
     * AgentService
     */
    AgentService agentService;

    /**
     * AgentProfileService
     */
    AgentProfileService agentProfileService;

    /**
     * ActivityService
     */
    ActivityService activityService;

    /**
     * ActivityProfileService
     */
    ActivityProfileService activityProfileService;

    /**
     * ActivityStateService
     */
    ActivityStateService activityStateService;

    /**
     * StatementService
     */
    StatementService statementService;

    @Autowired
    public void setXapiService(AboutService xapiService) {
        this.xapiService = xapiService;
    }

    @Autowired
    public void setAgentService(AgentService agentService) {
        this.agentService = agentService;
    }

    @Autowired
    public void setAgentProfileService(AgentProfileService agentProfileService) {
        this.agentProfileService = agentProfileService;
    }

    @Autowired
    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Autowired
    public void setActivityProfileService(ActivityProfileService activityProfileService) {
        this.activityProfileService = activityProfileService;
    }

    @Autowired
    public void setActivityStateService(ActivityStateService activityStateService) {
        this.activityStateService = activityStateService;
    }

    @Autowired
    public void setStatementService(StatementService statementService) {
        this.statementService = statementService;
    }

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

}
