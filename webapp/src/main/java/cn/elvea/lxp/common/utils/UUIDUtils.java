package cn.elvea.lxp.common.utils;

import java.util.UUID;

/**
 * UUIDUtils
 *
 * @author elvea
 */
public class UUIDUtils {

    /**
     * 生成唯一ID
     *
     * @return String
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

}
