package cn.elvea.lxp.xapi.controller;

import cn.elvea.lxp.xapi.http.XAPIResponse;
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
     * 查询
     */
    @GetMapping
    @ResponseBody
    public XAPIResponse<?> getActivityProfile(@RequestParam("activityId") String activityId,
                                              @RequestParam(name = "profileId", required = false) String profileId,
                                              @RequestParam(name = "since", required = false) String since) {
        return this.activityProfileService.getActivityProfile(activityId, profileId, since);
    }

    /**
     * 新增或者更新
     */
    @PutMapping
    @PostMapping
    @ResponseBody
    public XAPIResponse<?> putActivityProfile(@RequestParam("activityId") String activityId,
                                              @RequestParam("profileId") String profileId,
                                              @RequestBody String document) {
        return this.activityProfileService.saveActivityProfile(activityId, profileId, document);
    }

    /**
     * 删除
     */
    @DeleteMapping
    @ResponseBody
    public XAPIResponse<?> deleteActivityProfile(@RequestParam("activityId") String activityId,
                                                 @RequestParam(name = "profileId", required = false, defaultValue = "") String profileId,
                                                 @RequestParam(name = "since", required = false, defaultValue = "") String since) {
        return this.activityProfileService.deleteActivityProfile(activityId, profileId, since);
    }

}
