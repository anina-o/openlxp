package cn.elvea.lxp.modules.xapi.controller;

import cn.elvea.lxp.modules.xapi.http.XAPIResponse;
import io.swagger.annotations.Api;
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
@Api(tags = "XApi Activites Resource")
public class XApiActivityController extends XApiAbstractController {

    @GetMapping
    @ResponseBody
    public XAPIResponse getActivities(@RequestParam("activityId") String activityId) {
        return XAPIResponse.success(this.activityService.getActivities(activityId));
    }

}
