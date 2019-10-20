package cn.elvea.lxp.core.system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * UserSessionDto
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class UserSessionDto implements Serializable {
    /**
     * 会话ID
     */
    private Long tenantId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 会话ID
     */
    private String sessionId;
    /**
     * 验证类型
     */
    private String authType;
    /**
     * 登录平台
     */
    private String platform;
    /**
     * 登录主机ID地址
     */
    private String host;
}
