package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.http.XAPIResponse;

/**
 * ActivityProfileService
 *
 * @author elvea
 */
public interface ActivityProfileService {

    /**
     * 查询
     */
    XAPIResponse<?> getActivityProfile(String activityId, String profileId, String since);

    /**
     * 新增或者更新
     */
    XAPIResponse<?> saveActivityProfile(String activityId, String profileId, String content);

    /**
     * 删除
     */
    XAPIResponse<?> deleteActivityProfile(String activityId, String profileId, String since);

}
