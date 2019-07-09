package cn.elvea.lxp.core.entity;

import cn.elvea.lxp.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_role")
@EntityListeners(AuditingEntityListener.class)
public class RoleEntity extends BaseEntity {
    /**
     * 编号
     */
    private String code;
    /**
     * 多语言文本
     */
    private String label;
    /**
     * 标题
     */
    private String title;
    /**
     * 启用状态
     */
    private Boolean active;
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
    /**
     * 更新时间
     */
    @LastModifiedDate
    @Column(name = "modified_at")
    private Date modifiedAt;
    /**
     * 更新人
     */
    @LastModifiedBy
    @Column(name = "modified_by")
    private Long modifiedBy;
    /**
     * 删除时间
     */
    @Column(name = "deleted_at")
    private Date deletedAt;
    /**
     * 删除人
     */
    @Column(name = "deleted_by")
    private Long deletedBy;
    /**
     *
     */
    @ManyToMany(cascade = CascadeType.REFRESH, mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<UserEntity> users = new HashSet<>();
}
