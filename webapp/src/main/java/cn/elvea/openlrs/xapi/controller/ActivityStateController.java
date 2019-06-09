package cn.elvea.openlrs.xapi.controller;

import cn.elvea.openlrs.xapi.http.XAPIResponse;
import cn.elvea.openlrs.xapi.service.ActivityStateService;
import cn.elvea.openlrs.xapi.service.XAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Activity State Resource
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/activites/state")
public class ActivityStateController {

    @Autowired
    XAPIService xapiService;

    @Autowired
    ActivityStateService activityStateService;

    /**
     * Get
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse getActivityState(@RequestParam(name = "activityId") String activityId,
                                         @RequestParam(name = "agent") String agent,
                                         @RequestParam(name = "registration", required = false) String registration,
                                         @RequestParam(name = "stateId") String stateId,
                                         @RequestParam(name = "since", required = false) String since) {
        this.activityStateService.getActivityState(activityId, agent, registration, stateId, since);
        return XAPIResponse.success();
    }

    /**
     * Put
     */
    @PutMapping
    @ResponseBody
    public XAPIResponse putActivityState() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Post
     */
    @PostMapping
    @ResponseBody
    public XAPIResponse postActivityState() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Delete
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteActivityState() {
        return XAPIResponse.success(this.xapiService.about());
    }

}
