package cn.elvea.lxp.core.entity;

import cn.elvea.lxp.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户会话凭证实体
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_user_token")
public class UserTokenEntity extends BaseEntity {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 会话ID
     */
    private String sessionId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 凭证
     */
    private String token;
    /**
     * 刷新凭证
     */
    private String refreshToken;
    /**
     * 创建时间
     */
    private String createdAt;
    /**
     * 创建人
     */
    private String createdBy;
}
