package cn.elvea.lxp.core.system;

/**
 * CoreConstants
 *
 * @author elvea
 */
public class CoreConstants {
    //
    public final static Long DEFAULT_USER_ROLE_ID = 4L;

    //
    public final static String CACHE_USER_KEY = "USER";
    public final static String CACHE_USER_SESSION_KEY = "USER_SESSION";
    public final static String CACHE_ROLE_KEY = "ROLE";
    public final static String CACHE_USER_ROLE_KEY = "USER_ROLE";

    //
    public final static String CACHE_RESOURCE_TYPE_KEY = "RESOURCE_TYPE";
    public final static String CACHE_RESOURCE_KEY = "RESOURCE";

    //
    public final static String CACHE_ACTIVITY_TYPE_KEY = "ACTIVITY_TYPE";
    public final static String CACHE_ACTIVITY_KEY = "ACTIVITY";

    // AMQP

    /**
     * 用户登录会话
     */
    public final static String QUEUE_USER_SESSION = "QUEUE_USER_SESSION";
    /**
     * 用户登录历史记录
     */
    public final static String QUEUE_USER_LOGIN_HISTORY = "QUEUE_USER_LOGIN_HISTORY";

}
