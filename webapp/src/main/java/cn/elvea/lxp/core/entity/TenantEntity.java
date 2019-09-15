package cn.elvea.lxp.core.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.util.Date;

/**
 * 租户实体类
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "sys_role")
@EntityListeners(AuditingEntityListener.class)
public class TenantEntity extends BaseEntity {
    /**
     * 编号
     */
    private String code;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String description;
    /**
     * 用户数限制
     */
    @Column(name = "quota")
    private Integer quota;
    /**
     * 有效期开始时间
     */
    @Column(name = "start_datetime")
    private Date startDatetime;
    /**
     * 有效期结束时间
     */
    @Column(name = "end_datetime")
    private Date endDatetime;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * 启用状态
     */
    @Column
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
}
