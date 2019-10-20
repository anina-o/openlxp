package cn.elvea.lxp.core.system.entity;

import cn.elvea.lxp.common.model.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户
 *
 * @author elvea
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_user")
public class UserEntity extends BaseEntity {
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 全名
     */
    private String fullname;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * 启用状态
     */
    private Boolean active;
    /**
     * 创建时间
     */
    private Date createdAt;
    /**
     * 创建人
     */
    private Long createdBy;
    /**
     * 更新时间
     */
    private Date modifiedAt;
    /**
     * 更新人
     */
    private Long modifiedBy;
    /**
     * 删除时间
     */
    private Date deletedAt;
    /**
     * 删除人
     */
    private Long deletedBy;
}
