package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Activity Profile ResourceEntity
 *
 * @author elvea
 */
@Controller
@RequestMapping("/xAPI/activites/profile")
public class ActivityProfileController extends AbstractController {

    /**
     * Get
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse<?> getActivityProfile(@RequestParam("activityId") String activityId,
                                              @RequestParam(name = "profileId", required = false) String profileId,
                                              @RequestParam(name = "since", required = false) String since) {
        if (StringUtils.isNotEmpty(profileId)) {
            return XAPIResponse.success(this.activityProfileService.getSingleActivityProfile(activityId, profileId));
        } else {
            return XAPIResponse.success(this.activityProfileService.getActivityProfileIdList(activityId, since));
        }
    }

    /**
     * 新增或者更新
     */
    @ResponseBody
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public XAPIResponse putActivityProfile(@RequestParam("activityId") String activityId,
                                           @RequestParam("profileId") String profileId,
                                           @RequestBody String requestBody) {
        this.activityProfileService.saveActivityProfile(activityId, profileId, requestBody);
        return XAPIResponse.success();
    }

    /**
     * Delete
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteActivityProfile(@RequestParam("activityId") String activityId,
                                              @RequestParam(name = "profileId") String profileId) {
        this.activityProfileService.deleteActivityProfile(activityId, profileId);
        return XAPIResponse.success();
    }

}
