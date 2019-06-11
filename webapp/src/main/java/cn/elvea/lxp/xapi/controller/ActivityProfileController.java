package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import cn.elvea.lxp.xapi.service.document.ActivityProfileService;
import cn.elvea.lxp.xapi.service.XAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * Activity Profile Resource
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/activites/profile")
public class ActivityProfileController {

    @Autowired
    XAPIService xapiService;

    @Autowired
    ActivityProfileService activityProfileService;

    /**
     * Get
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse getActivityProfile(@RequestParam("activityId") String activityId,
                                           @RequestParam("profileId") String profileId) throws IOException {
        this.activityProfileService.getActivityProfile(activityId, profileId);
        return XAPIResponse.success();
    }

    /**
     * Put
     */
    @PutMapping
    @ResponseBody
    public XAPIResponse putActivityProfile() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Post
     */
    @PostMapping
    @ResponseBody
    public XAPIResponse postActivityProfile() {
        return XAPIResponse.success(this.xapiService.about());
    }

    /**
     * Delete
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteActivityProfile() {
        return XAPIResponse.success(this.xapiService.about());
    }

}
