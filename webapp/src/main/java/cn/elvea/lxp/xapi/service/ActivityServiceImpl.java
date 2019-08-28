package cn.elvea.lxp.xapi.service;

import cn.elvea.lxp.xapi.http.XAPIResponse;
import org.springframework.stereotype.Service;

/**
 * ActivityServiceImpl
 *
 * @author elvea
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    /**
     * @see ActivityService#getActivities(String)
     */
    @Override
    public XAPIResponse<?> getActivities(String activityId) {
        return XAPIResponse.success();
    }

}
