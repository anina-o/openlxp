package cn.elvea.lxp.xapi.entity;

import cn.elvea.lxp.xapi.model.Agent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EntityListeners;
import java.io.Serializable;
import java.util.Date;

/**
 * AgentProfileEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
@Document(collection = "olxp_agent_profile")
public class AgentProfileEntity implements Serializable {
    /**
     * ID
     */
    @Id
    private String id;
    /**
     *
     */
    private String profileId;
    /**
     *
     */
    private Agent agent;
    /**
     *
     */
    private String content;
    /**
     * 是否启用
     */
    private Boolean active;
    /**
     * 创建人
     */
    @CreatedBy
    private Long createdBy;
    /**
     * 创建日期
     */
    @CreatedDate
    private Date createdAt;
    /**
     * 更新人
     */
    @LastModifiedBy
    private Long updatedBy;
    /**
     * 更新日期
     */
    @LastModifiedDate
    private Date updatedAt;
    /**
     * 删除人
     */
    private Date deleteBy;
    /**
     * 删除日期
     */
    private Date deleteAt;
}
