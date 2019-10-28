package cn.elvea.lxp.core.system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * UserLoginHistoryDto
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
public class UserLoginHistoryDto implements Serializable {
    /**
     * ID
     */
    private Long ID;
    /**
     * 租户ID
     */
    private Long tenantId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 登录状态
     */
    private Integer status;
    /**
     * 登录主机
     */
    private String host;
}
