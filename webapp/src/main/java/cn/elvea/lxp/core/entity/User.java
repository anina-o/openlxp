package cn.elvea.lxp.core.entity;

import cn.elvea.lxp.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户
 *
 * @author elvea
 */
@Entity
@Table(name = "sys_user")
public class User extends BaseEntity {
}
