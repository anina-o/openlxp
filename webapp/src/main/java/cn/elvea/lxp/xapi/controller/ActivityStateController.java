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
                                         @RequestParam(name = "stateId", required = false) String stateId,
                                         @RequestParam(name = "since", required = false) String since) {
        return this.activityStateService.getActivityState(activityId, agentJson, registration, stateId, since);
    }

    /**
     * Put or Post
     */
    @PutMapping
    @PostMapping
    @ResponseBody
    public XAPIResponse putActivityState(@RequestParam(name = "activityId") String activityId,
                                         @RequestParam(name = "agent") String agentJson,
                                         @RequestParam(name = "registration", required = false) String registration,
                                         @RequestParam(name = "stateId") String stateId,
                                         @RequestBody String bodyJson) throws Exception {
        return this.activityStateService.saveActivityState(activityId, agentJson, registration, stateId, bodyJson);
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
        return activityStateService.deleteActivityState(activityId, agentJson, stateId, registration, since);
    }

}
