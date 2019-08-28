package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Activity State ResourceEntity
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/activites/state")
public class ActivityStateController extends AbstractController {

    /**
     * Get
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse getActivityState(@RequestParam(name = "activityId") String activityId,
                                         @RequestParam(name = "agent") String agentJson,
                                         @RequestParam(name = "registration", required = false) String registration,
                                         @RequestParam(name = "stateId") String stateId,
                                         @RequestParam(name = "since", required = false) String since) {
        this.activityStateService.getActivityState(activityId, agentJson, registration, stateId, since);
        return XAPIResponse.success();
    }

    /**
     * Put
     */
    @PutMapping
    @ResponseBody
    public XAPIResponse putActivityState(@RequestParam(name = "activityId") String activityId,
                                         @RequestParam(name = "agent") String agentJson,
                                         @RequestParam(name = "registration", required = false) String registration,
                                         @RequestParam(name = "stateId") String stateId) {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Post
     */
    @PostMapping
    @ResponseBody
    public XAPIResponse postActivityState(@RequestParam(name = "activityId") String activityId,
                                          @RequestParam(name = "agent") String agentJson,
                                          @RequestParam(name = "registration", required = false) String registration,
                                          @RequestParam(name = "stateId") String stateId) {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Delete
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteActivityState(
            @RequestParam(name = "activityId") String activityId,
            @RequestParam(name = "agent") String agentJson,
            @RequestParam(name = "registration", required = false) String registration
    ) {
        return XAPIResponse.success(this.xapiService.about());
    }

}
