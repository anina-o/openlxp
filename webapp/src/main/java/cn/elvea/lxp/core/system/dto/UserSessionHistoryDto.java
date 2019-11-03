package cn.elvea.lxp.core.system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * UserSessionHistoryDto
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class UserSessionHistoryDto implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 会话ID
     */
    private String sessionId;
    /**
     * Token
     */
    private String token;
    /**
     * Refresh Token
     */
    private String refreshToken;
}
