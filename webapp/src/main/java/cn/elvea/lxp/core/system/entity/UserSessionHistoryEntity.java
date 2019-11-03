package cn.elvea.lxp.core.system.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * UserSessionHistoryEntity
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_session_history")
public class UserSessionHistoryEntity extends BaseEntity {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 会话ID
     */
    private String sessionId;
    /**
     * Refresh Token
     */
    private String refreshToken;
    /**
     * Token
     */
    private String token;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 创建人
     */
    private Long createdBy;
}
