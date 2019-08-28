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
    public XAPIResponse getActivityProfile(
            @RequestParam("activityId") String activityId,
            @RequestParam(name = "profileId", required = false, defaultValue = "") String profileId,
            @RequestParam(name = "since", required = false, defaultValue = "") String since
    ) {
        if (StringUtils.isNotEmpty(profileId)) {
            // 当同时指定activityId和profileId时，获取唯一文档定义
            return XAPIResponse.success(this.activityProfileService.getActivityProfile(activityId, profileId));
        } else {
            // 当未指定profileId时，获取所有文档定义的ID集合
            // 当since不为空时，只包含since后面的所有文档定义的ID集合
            return XAPIResponse.success(this.activityProfileService.getActivityProfileIdList(activityId, since));
        }
    }

    /**
     * Put
     */
    @PutMapping
    @ResponseBody
    public XAPIResponse putActivityProfile(
            @RequestParam("activityId") String activityId,
            @RequestParam("profileId") String profileId,
            @RequestBody String document
    ) {
        this.activityProfileService.putActivityProfile(activityId, profileId, document);
        return XAPIResponse.success();
    }

    /**
     * Post
     */
    @PostMapping
    @ResponseBody
    public XAPIResponse postActivityProfile(
            @RequestParam("activityId") String activityId,
            @RequestParam(name = "profileId", required = false, defaultValue = "") String profileId,
            @RequestBody String document
    ) {
        this.activityProfileService.postActivityProfile(activityId, profileId, document);
        return XAPIResponse.success();
    }

    /**
     * Delete
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse deleteActivityProfile(
            @RequestParam("activityId") String activityId,
            @RequestParam(name = "profileId", required = false, defaultValue = "") String profileId,
            @RequestParam(name = "since", required = false, defaultValue = "") String since
    ) {
        if (StringUtils.isNotEmpty(profileId)) {
            // 当同时指定activityId和profileId时，删除唯一文档定义
            this.activityProfileService.deleteActivityProfile(activityId, profileId);
        } else {
            // 当未指定profileId时，删除所有文档定义的ID集合
            // 当since不为空时，只删除since后面的所有文档定义的ID集合
            this.activityProfileService.deleteActivityProfiles(activityId, since);
        }
        return XAPIResponse.success();
    }

}
