package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import cn.elvea.lxp.xapi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URISyntaxException;

/**
 * Activity State ResourceEntity
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/activites")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    /**
     * getActivities
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse getActivities(@RequestParam("activityId") String activityId) throws URISyntaxException {
        return XAPIResponse.success(this.activityService.getActivities(activityId));
    }

}
