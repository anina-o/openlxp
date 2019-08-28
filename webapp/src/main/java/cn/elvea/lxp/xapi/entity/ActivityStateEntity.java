package cn.elvea.lxp.xapi.entity;

import cn.elvea.lxp.xapi.Agent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * ActivityStateEntity
 *
 * @author elvea
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "openlxp_activity_state")
public class ActivityStateEntity extends BaseEntity {
    /**
     *
     */
    private String activityId;
    /**
     *
     */
    private String stateId;
    /**
     *
     */
    private Agent agent;
    /**
     *
     */
    private String content;
    /**
     *
     */
    private String registration;
    /**
     * 是否启用
     */
    private Boolean active;
    /**
     * 创建人
     */
    private Date createdBy;
    /**
     * 创建日期
     */
    private Date createdAt;
    /**
     * 更新人
     */
    private Date updatedBy;
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
