package cn.elvea.lxp.core.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户组
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_user_role_relation")
@EntityListeners(AuditingEntityListener.class)
public class UserRoleRelationEntity extends BaseEntity {
    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Long userId;
    /**
     * 角色ID
     */
    @Column(name = "role_id")
    private Long roleId;
    /**
     * 创建时间
     */
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;
    /**
     * 创建人
     */
    @CreatedBy
    @Column(name = "created_by")
    private Long createdBy;
}
