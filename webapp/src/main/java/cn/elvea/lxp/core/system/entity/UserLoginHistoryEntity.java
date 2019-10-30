package cn.elvea.lxp.core.system.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户登录历史记录实体类
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user_group")
public class UserLoginHistoryEntity extends BaseEntity {
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
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 创建人
     */
    private Long createdBy;
}
