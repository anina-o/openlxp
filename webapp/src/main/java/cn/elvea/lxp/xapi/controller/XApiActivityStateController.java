package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * XApiActivityStateController
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/activites/state")
public class XApiActivityStateController extends XApiAbstractController {

    /**
     * Get
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse getActivityState(@RequestParam(name = "activityId") String activityId,
                                         @RequestParam(name = "agent") String agent,
                                         @RequestParam(name = "stateId", required = false) String stateId,
                                         @RequestParam(name = "registration", required = false) String registration,
                                         @RequestParam(name = "since", required = false) String since) {
        if (StringUtils.isNotEmpty(stateId)) {
            return XAPIResponse.success(this.activityStateService.getActivityState(activityId, agent, registration, stateId));
        } else {
            return XAPIResponse.success(this.activityStateService.getActivityStateList(activityId, agent, registration, since));
        }
    }

    /**
     * Put or Post
     */
    @ResponseBody
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public XAPIResponse saveActivityState(@RequestParam(name = "activityId") String activityId,
                                          @RequestParam(name = "agent") String agentJson,
                                          @RequestParam(name = "registration", required = false) String registration,
                                          @RequestParam(name = "stateId") String stateId,
                                          @RequestBody String bodyJson) {
        this.activityStateService.saveActivityState(activityId, agentJson, registration, stateId, bodyJson);
        return XAPIResponse.success();
    }

    /**
     * Delete
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteActivityState(@RequestParam(name = "activityId") String activityId,
                                            @RequestParam(name = "agent") String agentJson,
                                            @RequestParam(name = "stateId", required = false) String stateId,
                                            @RequestParam(name = "registration", required = false) String registration,
                                            @RequestParam(name = "since", required = false) String since) {
        if (StringUtils.isNotEmpty(stateId)) {
            this.activityStateService.deleteActivityState(activityId, agentJson, stateId, registration);
        } else {
            this.activityStateService.deleteActivityStateList(activityId, agentJson, registration, since);
        }
        return XAPIResponse.success();
    }

}
