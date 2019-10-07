package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * XApiActivityController
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/activites")
public class XApiActivityController extends XApiAbstractController {

    @GetMapping
    @ResponseBody
    public XAPIResponse getActivities(@RequestParam("activityId") String activityId) {
        return XAPIResponse.success(this.activityService.getActivities(activityId));
    }

}
