package cn.elvea.lxp.modules.xapi.entity;

import cn.elvea.lxp.modules.xapi.model.Agent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * AgentProfileEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
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
    private Long createdBy;
    /**
     * 创建日期
     */
    private Date createdAt;
    /**
     * 更新人
     */
    private Long updatedBy;
    /**
     * 更新日期
     */
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
