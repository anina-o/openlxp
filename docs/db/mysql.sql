/*
建库
*/
DROP DATABASE IF EXISTS `lxp`;

CREATE DATABASE IF NOT EXISTS `lxp` DEFAULT CHARACTER SET `utf8mb4` DEFAULT COLLATE `utf8mb4_unicode_ci`;

USE `lxp`;

/*
租户表
*/
CREATE TABLE `sys_tenant`
(
    `id`             BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `code`           VARCHAR(100) COMMENT '编号',
    `title`          VARCHAR(255) COMMENT '标题',
    `description`    VARCHAR(255) COMMENT '描述',
    `start_datetime` DATETIME COMMENT '有效期开始时间',
    `end_datetime`   DATETIME COMMENT '有效期结束时间',
    `quota`          INT(8) UNSIGNED     NOT NULL DEFAULT 0 COMMENT '用户数限制',
    `status`         TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '租户状态',
    `root_ind`       TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否默认租户',
    `active`         TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '启用状态',
    `created_at`     DATETIME COMMENT '创建时间',
    `created_by`     BIGINT UNSIGNED COMMENT '创建人',
    `modified_at`    DATETIME COMMENT '修改时间',
    `modified_by`    BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`     DATETIME COMMENT '删除人',
    `deleted_by`     BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_tnt_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_tenant`
    COMMENT '租户表';

/*
用户表
*/
CREATE TABLE `sys_user`
(
    `id`          BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `username`    VARCHAR(150) COMMENT '用户名',
    `email`       VARCHAR(150) COMMENT '邮箱',
    `mobile`      VARCHAR(150) COMMENT '手机',
    `nickname`    VARCHAR(255) COMMENT '昵称',
    `fullname`    VARCHAR(255) COMMENT '全名',
    `password`    VARCHAR(255) COMMENT '密码',
    `status`      TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '用户状态',
    `active`      TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `modified_at` DATETIME COMMENT '修改时间',
    `modified_by` BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`  DATETIME COMMENT '删除人',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_usr_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user`
    COMMENT '用户表';

CREATE INDEX `ix_usr_username` ON `sys_user` (`username`);
CREATE INDEX `ix_usr_mobile` ON `sys_user` (`mobile`);
CREATE INDEX `ix_usr_email` ON `sys_user` (`email`);

/*
租户-用户关联表
*/
CREATE TABLE `sys_user_tenant_relation`
(
    `id`         BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `tenant_id`  BIGINT UNSIGNED NOT NULL COMMENT '租户ID',
    `user_id`    BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
    `created_at` DATETIME COMMENT '创建时间',
    `created_by` BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_utr_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_tenant_relation`
    COMMENT '租户-用户关联表';

CREATE INDEX `ix_utr_tenant_id` ON `sys_user_tenant_relation` (`tenant_id`);
CREATE INDEX `ix_utr_user_id` ON `sys_user_tenant_relation` (`user_id`);

/*
用户组表
*/
CREATE TABLE `sys_user_group`
(
    `id`          BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `tenant_id`   BIGINT UNSIGNED     NOT NULL COMMENT 'Tenant ID',
    `code`        VARCHAR(150) COMMENT '编号',
    `title`       VARCHAR(150) COMMENT '标题',
    `active`      TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `modified_at` DATETIME COMMENT '修改时间',
    `modified_by` BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`  DATETIME COMMENT '删除人',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_usg_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_group`
    COMMENT '用户组表';

CREATE INDEX `ix_usg_tenant_id` ON `sys_user_group` (`tenant_id`);

/*
用户组成员表
*/
CREATE TABLE `sys_user_group_member`
(
    `id`            BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `tenant_id`     BIGINT UNSIGNED     NOT NULL COMMENT 'Tenant ID',
    `user_group_id` BIGINT UNSIGNED     NOT NULL COMMENT '用户组ID',
    `user_id`       BIGINT UNSIGNED     NOT NULL COMMENT '用户ID',
    `role`          TINYINT(1) UNSIGNED NOT NULL COMMENT '角色',
    `created_at`    DATETIME COMMENT '创建时间',
    `created_by`    BIGINT UNSIGNED COMMENT '创建人',
    `modified_at`   DATETIME COMMENT '修改时间',
    `modified_by`   BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`    DATETIME COMMENT '删除人',
    `deleted_by`    BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_sys_user_group_member_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_group_member`
    COMMENT '用户组成员表';

CREATE INDEX `ix_usgm_tenant_id` ON `sys_user_group_member` (`tenant_id`);
CREATE INDEX `ix_usgm_user_group_id` ON `sys_user_group_member` (`user_group_id`);
CREATE INDEX `ix_usgm_user_id` ON `sys_user_group_member` (`user_id`);

CREATE TABLE `sys_entity_relation`
(
    `id`         BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `tenant_id`  BIGINT UNSIGNED     NOT NULL COMMENT 'Tenant ID',
    `type`       VARCHAR(50)         NOT NULL COMMENT '关联类型',
    `parent_id`  BIGINT UNSIGNED     NOT NULL COMMENT '父节点ID',
    `child_id`   BIGINT UNSIGNED     NOT NULL COMMENT '子节点ID',
    `parent_ind` TINYINT(1) UNSIGNED NOT NULL COMMENT '是否直属父节点',
    `idx`        INT(4) UNSIGNED     NOT NULL COMMENT '层级序号',
    `path`       TEXT COMMENT '关联的完整路径',
    `created_at` DATETIME COMMENT '创建时间',
    `created_by` BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_ern_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_entity_relation`
    COMMENT '实体关联表';

CREATE INDEX `ix_ern_tenant_id` ON `sys_entity_relation` (`tenant_id`);
CREATE INDEX `ix_ern_type` ON `sys_entity_relation` (`type`);
CREATE INDEX `ix_ern_parent_id` ON `sys_entity_relation` (`parent_id`);
CREATE INDEX `ix_ern_child_id` ON `sys_entity_relation` (`child_id`);

/*
用户会话记录表
*/
CREATE TABLE `sys_user_session`
(
    `id`                   BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `tenant_id`            BIGINT UNSIGNED NOT NULL COMMENT 'Tenant ID',
    `user_id`              BIGINT UNSIGNED NOT NULL COMMENT 'User ID',
    `session_id`           VARCHAR(150) COMMENT '会话ID',
    `username`             VARCHAR(150) COMMENT '用户名',
    `host`                 VARCHAR(255) COMMENT '登录主机',
    `device_model`         VARCHAR(255) COMMENT '登录设备名称',
    `device_version`       VARCHAR(255) COMMENT '登录设备版本',
    `platform`             VARCHAR(255) COMMENT '登录平台',
    `client_version`       VARCHAR(255) COMMENT '客户端版本',
    `start_datetime`       DATETIME COMMENT '会话开始时间',
    `last_access_datetime` DATETIME COMMENT '最近访问时间',
    `end_datetime`         DATETIME COMMENT '会话结束时间',
    `total_time`           INT UNSIGNED COMMENT '会话时长',
    `year`                 INT UNSIGNED COMMENT '会话开始年',
    `month`                INT UNSIGNED COMMENT '会话开始月',
    `day`                  INT UNSIGNED COMMENT '会话开始天',
    `hour`                 INT UNSIGNED COMMENT '会话开始小时',
    `minute`               INT UNSIGNED COMMENT '会话开始分钟',
    CONSTRAINT `pk_usn_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_session`
    COMMENT '用户会话记录表';

CREATE INDEX `ix_usn_tenant_id` ON `sys_user_session` (`tenant_id`);
CREATE INDEX `ix_usn_user_id` ON `sys_user_session` (`user_id`);
CREATE INDEX `ix_usn_session_id` ON `sys_user_session` (`session_id`);
CREATE INDEX `ix_usn_year` ON `sys_user_session` (`year`);
CREATE INDEX `ix_usn_month` ON `sys_user_session` (`month`);
CREATE INDEX `ix_usn_day` ON `sys_user_session` (`day`);
CREATE INDEX `ix_usn_hour` ON `sys_user_session` (`hour`);
CREATE INDEX `ix_usn_minute` ON `sys_user_session` (`minute`);

/*
用户会话时长统计表
*/
CREATE TABLE `sys_user_session_statistics`
(
    `id`                    BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `tenant_id`             BIGINT UNSIGNED NOT NULL COMMENT 'Tenant ID',
    `user_id`               BIGINT UNSIGNED NOT NULL COMMENT 'User ID',
    `session_id`            VARCHAR(150) COMMENT '会话ID',
    `first_access_datetime` DATETIME COMMENT '首次访问时间',
    `last_access_datetime`  DATETIME COMMENT '最近访问时间',
    `total_time`            DATETIME COMMENT '在线时长',
    `year`                  INT UNSIGNED COMMENT '年份',
    `month`                 INT UNSIGNED COMMENT '月份',
    `day`                   INT UNSIGNED COMMENT '日期',
    `created_at`            DATETIME COMMENT '创建时间',
    `created_by`            BIGINT UNSIGNED COMMENT '创建人',
    `modified_at`           DATETIME COMMENT '修改时间',
    `modified_by`           BIGINT UNSIGNED COMMENT '修改人',
    CONSTRAINT `pk_uss_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_session_statistics`
    COMMENT '用户会话时长统计表';

CREATE INDEX `ix_uss_tenant_id` ON `sys_user_session_statistics` (`tenant_id`);
CREATE INDEX `ix_uss_user_id` ON `sys_user_session_statistics` (`user_id`);
CREATE INDEX `ix_uss_session_id` ON `sys_user_session_statistics` (`session_id`);
CREATE INDEX `ix_uss_year` ON `sys_user_session_statistics` (`year`);
CREATE INDEX `ix_uss_month` ON `sys_user_session_statistics` (`month`);
CREATE INDEX `ix_uss_day` ON `sys_user_session_statistics` (`day`);

/*
用户会话历史记录表
*/
CREATE TABLE `sys_user_session_history`
(
    `id`            BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `tenant_id`     BIGINT UNSIGNED NOT NULL COMMENT 'Tenant ID',
    `user_id`       BIGINT UNSIGNED NOT NULL COMMENT 'User ID',
    `session_id`    VARCHAR(150) COMMENT '会话ID',
    `refresh_token` TEXT COMMENT 'Refresh Token',
    `token`         TEXT COMMENT 'Token',
    `created_at`    DATETIME COMMENT '创建时间',
    `created_by`    BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_ush_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_session_history`
    COMMENT '用户会话历史记录表';

CREATE INDEX `ix_ush_user_id` ON `sys_user_session_history` (`user_id`);
CREATE INDEX `ix_ush_tenant_id` ON `sys_user_session_history` (`tenant_id`);
CREATE INDEX `ix_ush_session_id` ON `sys_user_session_history` (`session_id`);

/*
用户登录历史记录表
*/
CREATE TABLE `sys_user_login_history`
(
    `id`         BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `tenant_id`  BIGINT UNSIGNED NOT NULL COMMENT 'Tenant ID',
    `user_id`    BIGINT UNSIGNED NOT NULL COMMENT 'User ID',
    `status`     TINYINT(1) COMMENT '登录状态',
    `host`       VARCHAR(100) COMMENT '登录主机',
    `created_at` DATETIME COMMENT '创建时间',
    `created_by` BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_ulh_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_login_history`
    COMMENT '用户登录历史记录表';

CREATE INDEX `ix_ulh_user_id` ON `sys_user_login_history` (`user_id`);
CREATE INDEX `ix_ulh_tenant_id` ON `sys_user_login_history` (`tenant_id`);

/*
角色表
*/
CREATE TABLE `sys_role`
(
    `id`          BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `tenant_id`   BIGINT UNSIGNED     NOT NULL COMMENT 'Tenant ID',
    `code`        VARCHAR(150) COMMENT '编号',
    `label`       VARCHAR(150) COMMENT '文本',
    `title`       VARCHAR(150) COMMENT '标题',
    `active`      TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `modified_at` DATETIME COMMENT '修改时间',
    `modified_by` BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`  DATETIME COMMENT '删除人',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_rol_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_role`
    COMMENT '角色表';

CREATE INDEX `ix_rol_tenant_id` ON `sys_role` (`tenant_id`);

/*
权限表
*/
CREATE TABLE `sys_authority`
(
    `id`          BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `parent_id`   BIGINT UNSIGNED     NOT NULL DEFAULT 0 COMMENT 'Parent ID',
    `code`        VARCHAR(150) COMMENT '编号',
    `label`       VARCHAR(150) COMMENT '文本',
    `type`        VARCHAR(150) COMMENT '类型',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `modified_at` DATETIME COMMENT '修改时间',
    `modified_by` BIGINT UNSIGNED COMMENT '修改人',
    `active`      TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '启用状态',
    `deleted_at`  DATETIME COMMENT '删除人',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_aty_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_authority`
    COMMENT '权限表';

/*
租户权限关联表
*/
CREATE TABLE `sys_tenant_authority_relation`
(
    `id`           BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `tenant_id`    BIGINT UNSIGNED NOT NULL COMMENT 'Tenant ID',
    `authority_id` BIGINT UNSIGNED NOT NULL COMMENT '权限ID',
    `created_at`   DATETIME COMMENT '创建时间',
    `created_by`   BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_tar_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_tenant_authority_relation`
    COMMENT '租户权限关联表';

CREATE INDEX `ix_tar_tenant_id` ON `sys_tenant_authority_relation` (`tenant_id`);
CREATE INDEX `ix_tar_id` ON `sys_tenant_authority_relation` (`authority_id`);

/*
角色权限关联表
*/
CREATE TABLE `sys_role_authority_relation`
(
    `id`           BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `tenant_id`    BIGINT UNSIGNED NOT NULL COMMENT 'Tenant ID',
    `role_id`      BIGINT UNSIGNED NOT NULL COMMENT '角色ID',
    `authority_id` BIGINT UNSIGNED NOT NULL COMMENT '权限ID',
    `created_at`   DATETIME COMMENT '创建时间',
    `created_by`   BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_rar_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_role_authority_relation`
    COMMENT '角色权限关联表';

CREATE INDEX `ix_rar_tenant_id` ON `sys_role_authority_relation` (`tenant_id`);
CREATE INDEX `ix_rar_role_id` ON `sys_role_authority_relation` (`role_id`);
CREATE INDEX `ix_rar_authority_id` ON `sys_role_authority_relation` (`authority_id`);

/*
用户权限关联表
*/
CREATE TABLE `sys_user_role_relation`
(
    `id`         BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `tenant_id`  BIGINT UNSIGNED NOT NULL COMMENT 'Tenant ID',
    `user_id`    BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
    `role_id`    BIGINT UNSIGNED NOT NULL COMMENT '角色ID',
    `created_at` DATETIME COMMENT '创建时间',
    `created_by` BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_urr_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_role_relation`
    COMMENT '用户角色关联表';

CREATE INDEX `ix_urr_tenant_id` ON `sys_user_role_relation` (`tenant_id`);
CREATE INDEX `ix_urr_role_id` ON `sys_user_role_relation` (`role_id`);
CREATE INDEX `ix_urr_user_id` ON `sys_user_role_relation` (`user_id`);

/*
附件文件表
*/
CREATE TABLE `sys_attachment`
(
    `id`                BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `tenant_id`         BIGINT UNSIGNED     NOT NULL COMMENT 'Tenant ID',
    `type`              VARCHAR(180) COMMENT '附件类型',
    `original_filename` VARCHAR(255) COMMENT '原始文件名',
    `filename`          VARCHAR(255) COMMENT '文件名',
    `url`               VARCHAR(255) COMMENT '文件链接',
    `extra`             TEXT COMMENT '附加信息',
    `active`            TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '启用状态',
    `created_at`        DATETIME COMMENT '创建时间',
    `created_by`        BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`        DATETIME COMMENT '修改时间',
    `updated_by`        BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`        DATETIME COMMENT '删除时间',
    `deleted_by`        BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_amt_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_attachment`
    COMMENT '附件文件表';

/*
附件关联表
*/
CREATE TABLE `sys_attachment_relation`
(
    `id`            BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `tenant_id`     BIGINT UNSIGNED NOT NULL COMMENT 'Tenant ID',
    `target_type`   VARCHAR(180)    NOT NULL COMMENT '附件类型',
    `target_id`     BIGINT UNSIGNED NOT NULL COMMENT '目标实体ID',
    `attachment_id` BIGINT UNSIGNED NOT NULL COMMENT '目标附件ID',
    `created_at`    DATETIME COMMENT '创建时间',
    `created_by`    BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_amr_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_attachment_relation`
    COMMENT '附件关联表';

CREATE INDEX `ix_amr_target_type` ON `sys_attachment_relation` (`target_type`);
CREATE INDEX `ix_amr_target_id` ON `sys_attachment_relation` (`target_id`);
CREATE INDEX `ix_amr_attachment_id` ON `sys_attachment_relation` (`attachment_id`);
CREATE INDEX `ix_amr_tenant_id` ON `sys_attachment_relation` (`tenant_id`);

/*
活动类型表
*/
CREATE TABLE `sys_activity_type`
(
    `id`          BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `type`        VARCHAR(100)        NOT NULL COMMENT '活动类型',
    `label`       VARCHAR(150) COMMENT '文本',
    `active`      TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `modified_at` DATETIME COMMENT '修改时间',
    `modified_by` BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`  DATETIME COMMENT '删除人',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_att_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_activity_type`
    COMMENT '活动类型表';

CREATE INDEX `ix_att_type` ON `sys_activity_type` (`type`);

/*
活动表
*/
CREATE TABLE `sys_activity`
(
    `id`                         BIGINT UNSIGNED      NOT NULL COMMENT 'ID',
    `type`                       VARCHAR(100)         NOT NULL COMMENT '活动类型',
    `code`                       VARCHAR(100)         NOT NULL COMMENT '编号',
    `title`                      VARCHAR(150)         NOT NULL COMMENT '标题',
    `objective`                  VARCHAR(255) COMMENT '课程目标',
    `description`                VARCHAR(255) COMMENT '课程简介',
    `publish_type`               VARCHAR(100) COMMENT '发布范围',
    `publish_start_datetime`     DATETIME COMMENT '发布开始日期',
    `publish_end_datetime`       DATETIME COMMENT '发布结束日期',
    `enroll_start_datetime`      DATETIME COMMENT '报名开始日期',
    `enroll_end_datetime`        DATETIME COMMENT '报名结束日期',
    `start_datetime`             DATETIME COMMENT '学习开始日期',
    `end_datetime`               DATETIME COMMENT '学习结束日期',
    `enrollment_workflow`        VARCHAR(50) COMMENT '报名流程',
    `credit`                     FLOAT(2, 1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '积分',
    `hours`                      FLOAT(2, 1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '课时',
    `quota`                      INT(8) UNSIGNED      NOT NULL DEFAULT 0 COMMENT '报名名额',
    `retake_ind`                 TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '是否允许重复报名',
    `open_ind`                   TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '是否公开课',
    `top_ind`                    TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '是否置顶',
    `open_enroll_ind`            TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '是否开放报名',
    `compulsory_ind`             TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '是否必修',
    `allow_share_ind`            TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '是否允许分享',
    `send_start_notice_ind`      TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '是否发送开课通知',
    `send_end_notice_ind`        TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '是否发送结束通知',
    `send_enrollment_notice_ind` TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '是否发送报名通知',
    `send_attendance_notice_ind` TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '是否发送完成通知',
    `status`                     TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '发布状态',
    `active`                     TINYINT(1) UNSIGNED  NOT NULL DEFAULT 0 COMMENT '启用状态',
    `top_at`                     DATETIME COMMENT '推荐置顶时间',
    `top_by`                     BIGINT UNSIGNED COMMENT '推荐置顶人',
    `created_at`                 DATETIME COMMENT '创建时间',
    `created_by`                 BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`                 DATETIME COMMENT '修改时间',
    `updated_by`                 BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`                 DATETIME COMMENT '删除时间',
    `deleted_by`                 BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_act_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_activity`
    COMMENT '活动表';

CREATE INDEX `ix_act_type` ON `sys_activity` (`type`);

/*
活动报名记录表
*/
CREATE TABLE `sys_activity_enrollment`
(
    `id`                   BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `activity_id`          BIGINT UNSIGNED     NOT NULL COMMENT '活动ID',
    `user_id`              BIGINT UNSIGNED     NOT NULL COMMENT '用户ID',
    `enroll_datetime`      DATETIME COMMENT '报名日期',
    `enroll_status`        TINYINT(1) UNSIGNED COMMENT '报名状态',
    `commence_datetime`    DATETIME COMMENT '首次访问时间',
    `last_access_datetime` DATETIME COMMENT '最近访问时间',
    `total_attempt`        INT UNSIGNED        NOT NULL DEFAULT 0 COMMENT '尝试总次数',
    `total_time`           INT UNSIGNED        NOT NULL DEFAULT 0 COMMENT '学习总时长',
    `complete_datetime`    DATETIME COMMENT '完成时间',
    `complete_status`      TINYINT(1) UNSIGNED COMMENT '完成状态',
    `score`                FLOAT(10, 2) UNSIGNED COMMENT '分数',
    `final_score`          FLOAT(10, 2) UNSIGNED COMMENT '最终分数',
    `final_ind`            TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否最终分数',
    `active`               TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '启用状态',
    `created_at`           DATETIME COMMENT '创建时间',
    `created_by`           BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`           DATETIME COMMENT '修改时间',
    `updated_by`           BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`           DATETIME COMMENT '删除时间',
    `deleted_by`           BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_ate_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_activity_enrollment`
    COMMENT '课程报名记录表';

CREATE INDEX `ix_ate_activity_id` ON `sys_activity_enrollment` (`activity_id`);
CREATE INDEX `ix_ate_user_id` ON `sys_activity_enrollment` (`user_id`);

/*
资源类型表
*/
CREATE TABLE `sys_resource_type`
(
    `id`          BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `type`        VARCHAR(100) COMMENT '类型',
    `label`       VARCHAR(150) COMMENT '文本',
    `active`      TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '启用状态',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `modified_at` DATETIME COMMENT '修改时间',
    `modified_by` BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`  DATETIME COMMENT '删除人',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_ret_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_resource_type`
    COMMENT '资源类型表';

CREATE INDEX `ix_ret_type` ON `sys_resource_type` (`type`);

/*
资源表
*/
CREATE TABLE `sys_resource`
(
    `id`                        BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `reference_id`              BIGINT UNSIGNED     NOT NULL DEFAULT 0 COMMENT '原始资源ID',
    `type`                      VARCHAR(100) COMMENT '类型',
    `code`                      VARCHAR(150) COMMENT '编号',
    `title`                     VARCHAR(255) COMMENT '标题',
    `description`               VARCHAR(255) COMMENT '描述',
    `publish_start_datetime`    DATETIME COMMENT '发布开始日期',
    `publish_end_datetime`      DATETIME COMMENT '发布结束日期',
    `start_datetime`            DATETIME COMMENT '学习开始日期',
    `end_datetime`              DATETIME COMMENT '学习结束日期',
    `url`                       VARCHAR(255) COMMENT 'URL',
    `content`                   TEXT COMMENT '内容',
    `score`                     FLOAT(10, 2) UNSIGNED COMMENT '满分分数',
    `pass_score`                FLOAT(10, 2) UNSIGNED COMMENT '及格分数',
    `attempt_limit`             INT UNSIGNED COMMENT '最多允许尝试次数',
    `attempt_policy`            VARCHAR(50) COMMENT '尝试次数计算策略',
    `time_limit`                INT UNSIGNED COMMENT '最低完成时长',
    `paper_generate_mode`       VARCHAR(50) COMMENT '试卷生成策略',
    `paper_allow_pause_ind`     TINYINT(1) UNSIGNED COMMENT '是否允许暂停',
    `paper_display_answer_mode` VARCHAR(50) COMMENT '答案显示形式',
    `paper_score_mode`          VARCHAR(50) COMMENT '试卷计分方式',
    `paper_score_policy`        VARCHAR(50) COMMENT '试卷计分策略',
    `status`                    TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '发布状态',
    `active`                    TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '启用状态',
    `created_at`                DATETIME COMMENT '创建时间',
    `created_by`                BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`                DATETIME COMMENT '修改时间',
    `updated_by`                BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`                DATETIME COMMENT '删除人',
    `deleted_by`                BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_res_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_resource`
    COMMENT '资源表';

CREATE INDEX `ix_res_type` ON `sys_resource` (`type`);

/*
活动和资源关联表
*/
CREATE TABLE `sys_activity_resource_relation`
(
    `id`          BIGINT  NOT NULL COMMENT 'ID',
    `activity_id` BIGINT  NOT NULL COMMENT '培训ID',
    `resource_id` BIGINT  NOT NULL COMMENT '资源ID',
    `idx`         INTEGER NOT NULL COMMENT '序号',
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_arr_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_activity_resource_relation`
    COMMENT '活动和资源关联表';

CREATE INDEX `ix_arr_activity_id` ON `sys_activity_resource_relation` (`activity_id`);
CREATE INDEX `ix_arr_resource_id` ON `sys_activity_resource_relation` (`resource_id`);

/*
资源学习记录表
*/
CREATE TABLE `sys_resource_attendance`
(
    `id`                   BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `activity_id`          BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活动ID',
    `enrollment_id`        BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '报名ID',
    `user_id`              BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
    `resource_id`          BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '资源ID',
    `commence_datetime`    DATETIME COMMENT '首次访问时间',
    `last_access_datetime` DATETIME COMMENT '最近访问时间',
    `total_attempt`        INT UNSIGNED COMMENT '尝试总次数',
    `total_time`           INT UNSIGNED COMMENT '学习总时长',
    `complete_datetime`    DATETIME COMMENT '完成时间',
    `complete_status`      TINYINT(1) UNSIGNED COMMENT '完成状态',
    `score`                FLOAT(10, 2) UNSIGNED COMMENT '分数',
    `first_score`          FLOAT(10, 2) UNSIGNED COMMENT '第一次分数',
    `last_score`           FLOAT(10, 2) UNSIGNED COMMENT '最后一次分数',
    `max_score`            FLOAT(10, 2) UNSIGNED COMMENT '最高分数',
    `min_score`            FLOAT(10, 2) UNSIGNED COMMENT '最低分数',
    `avg_score`            FLOAT(10, 2) UNSIGNED COMMENT '平均分数',
    `final_score`          FLOAT(10, 2) UNSIGNED COMMENT '最终分数',
    `created_at`           DATETIME COMMENT '创建时间',
    `created_by`           BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`           DATETIME COMMENT '修改时间',
    `updated_by`           BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`           DATETIME COMMENT '删除人',
    `deleted_by`           BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_rte_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_resource_attendance`
    COMMENT '资源学习记录表';

CREATE INDEX `ix_rte_activity_id` ON `sys_resource_attendance` (`activity_id`);
CREATE INDEX `ix_rte_enrollment_id` ON `sys_resource_attendance` (`enrollment_id`);
CREATE INDEX `ix_rte_user_id` ON `sys_resource_attendance` (`user_id`);
CREATE INDEX `ix_rte_resource_id` ON `sys_resource_attendance` (`resource_id`);

/*
资源学习历史记录表
*/
CREATE TABLE `sys_resource_attendance_history`
(
    `id`              BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `activity_id`     BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '活动ID',
    `enrollment_id`   BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '报名ID',
    `user_id`         BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
    `resource_id`     BIGINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '资源ID',
    `session_id`      VARCHAR(150) COMMENT '学习会话ID',
    `total_time`      INT UNSIGNED COMMENT '学习时长',
    `score`           FLOAT(10, 2) UNSIGNED COMMENT '分数',
    `complete_status` TINYINT(1) UNSIGNED COMMENT '完成状态',
    `json_data`       LONGTEXT COMMENT '附加数据',
    `created_at`      DATETIME COMMENT '创建时间',
    `created_by`      BIGINT COMMENT '创建人',
    CONSTRAINT `pk_rah_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_resource_attendance_history`
    COMMENT '资源学习历史记录表';

CREATE INDEX `ix_rah_activity_id` ON `sys_resource_attendance_history` (`activity_id`);
CREATE INDEX `ix_rah_enrollment_id` ON `sys_resource_attendance_history` (`enrollment_id`);
CREATE INDEX `ix_rah_user_id` ON `sys_resource_attendance_history` (`user_id`);
CREATE INDEX `ix_rah_resource_id` ON `sys_resource_attendance_history` (`resource_id`);

/*
试题表
*/
CREATE TABLE `sys_question`
(
    `id`           BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `reference_id` BIGINT UNSIGNED     NOT NULL COMMENT '原始题目ID',
    `type`         VARCHAR(50) COMMENT '类型',
    `title`        VARCHAR(255) COMMENT '题目标题',
    `description`  VARCHAR(255) COMMENT '题目描述',
    `difficulty`   INT UNSIGNED COMMENT '难度系数',
    `score`        FLOAT(10, 2) COMMENT '题目分值',
    `explanation`  TEXT COMMENT '题目解答',
    `answer`       TEXT COMMENT '参考答案',
    `content`      TEXT COMMENT '题干',
    `source`       VARCHAR(50) COMMENT '来源',
    `native_ind`   TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否是试题库的题目',
    `status`       TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '发布状态',
    `active`       TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '启用状态',
    `created_at`   DATETIME COMMENT '创建时间',
    `created_by`   BIGINT COMMENT '创建人',
    `updated_at`   DATETIME COMMENT '更新时间',
    `updated_by`   BIGINT COMMENT '更新人',
    `deleted_at`   DATETIME COMMENT '删除时间',
    `deleted_by`   BIGINT COMMENT '删除人',
    CONSTRAINT `pk_que_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_question`
    COMMENT '试题表';

CREATE INDEX `ix_que_reference_id` ON `sys_question` (`reference_id`);
CREATE INDEX `ix_que_type` ON `sys_question` (`type`);
CREATE INDEX `ix_que_native_ind` ON `sys_question` (`native_ind`);

/*
试题选项表
*/
CREATE TABLE `sys_question_option`
(
    `id`           BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `question_id`  BIGINT UNSIGNED     NOT NULL COMMENT '题目ID',
    `reference_id` BIGINT UNSIGNED     NOT NULL COMMENT '原始选项ID',
    `idx`          INT UNSIGNED COMMENT '序号',
    `content`      TEXT COMMENT '选项内容',
    `explanation`  TEXT COMMENT '选项解释',
    `score`        FLOAT(10, 2) UNSIGNED COMMENT '选项分值',
    `correct_ind`  TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否正确答案',
    `case_ind`     TINYINT(1) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否大小写敏感',
    CONSTRAINT `pk_quo_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_question_option`
    COMMENT '试题选项表';

CREATE INDEX `ix_quo_question_id` ON `sys_question_option` (`question_id`);
CREATE INDEX `ix_quo_reference_id` ON `sys_question_option` (`reference_id`);

/*
试卷章节(大题)
*/
CREATE TABLE `sys_paper_section`
(
    `id`          BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `resource_id` BIGINT UNSIGNED NOT NULL COMMENT '试卷ID',
    `type`        VARCHAR(50) COMMENT '题目类型',
    `title`       VARCHAR(255) COMMENT '章节标题',
    `description` VARCHAR(255) COMMENT '章节描述说明',
    `idx`         INT UNSIGNED COMMENT '章节序号',
    `count`       INT UNSIGNED COMMENT '抽题数量',
    `difficulty`  INT UNSIGNED COMMENT '难度系数',
    `score`       FLOAT(10, 2) COMMENT '抽题分值',
    `total_score` FLOAT(10, 2) COMMENT '章节题目总分值',
    `total_count` INT COMMENT '章节题目总数量',
    CONSTRAINT `pk_pps_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_paper_section`
    COMMENT '试卷章节表';

CREATE INDEX `ix_pps_resource_id` ON `sys_paper_section` (`resource_id`);

/*
试卷试题
*/
CREATE TABLE `sys_paper_question`
(
    `id`             BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `resource_id`    BIGINT UNSIGNED NOT NULL COMMENT '试卷ID',
    `section_id`     BIGINT UNSIGNED NOT NULL COMMENT '章节ID',
    `question_id`    BIGINT UNSIGNED NOT NULL COMMENT '题目ID',
    `paper_index`    INT UNSIGNED    NOT NULL COMMENT '试卷序号',
    `question_index` INT UNSIGNED    NOT NULL COMMENT '题目序号',
    `created_at`     DATETIME COMMENT '创建时间',
    `created_by`     BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_ppq_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_paper_question`
    COMMENT '试卷试题表';

CREATE INDEX `ix_ppq_resource_id` ON `sys_paper_question` (`resource_id`);
CREATE INDEX `ix_ppq_section_id` ON `sys_paper_question` (`section_id`);
CREATE INDEX `ix_ppq_question_id` ON `sys_paper_question` (`question_id`);

/*
试卷答题自动保存记录表
*/
CREATE TABLE `sys_paper_auto_save_record`
(
    `id`            BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `activity_id`   BIGINT UNSIGNED NOT NULL COMMENT '活动ID',
    `enrollment_id` BIGINT UNSIGNED NOT NULL COMMENT '报名ID',
    `resource_id`   BIGINT UNSIGNED NOT NULL COMMENT '资源ID',
    `user_id`       BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
    `session_id`    VARCHAR(150) COMMENT '会话ID',
    `data`          TEXT COMMENT '数据',
    `created_at`    DATETIME COMMENT '创建时间',
    `created_by`    BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_par_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_paper_auto_save_record`
    COMMENT '试卷答题自动保存记录表';

CREATE INDEX `ix_ppq_resource_id` ON `sys_paper_auto_save_record` (`resource_id`);
CREATE INDEX `ix_ppq_activity_id` ON `sys_paper_auto_save_record` (`activity_id`);
CREATE INDEX `ix_ppq_enrollment_id` ON `sys_paper_auto_save_record` (`enrollment_id`);

/*
试卷答题记录
*/
CREATE TABLE `sys_paper_record`
(
    `id`                BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `activity_id`       BIGINT UNSIGNED NOT NULL COMMENT '活动ID',
    `enrollment_id`     BIGINT UNSIGNED NOT NULL COMMENT '报名ID',
    `resource_id`       BIGINT UNSIGNED NOT NULL COMMENT '资源ID',
    `user_id`           BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
    `session_id`        VARCHAR(150) COMMENT '会话ID',
    `paper_index`       INT UNSIGNED COMMENT '试卷序号',
    `score`             FLOAT(10, 2) UNSIGNED COMMENT '分数',
    `score_status`      VARCHAR(10) COMMENT '评分状态',
    `attendance_status` VARCHAR(10) COMMENT '成绩状态',
    `created_at`        DATETIME COMMENT '创建时间',
    `created_by`        BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_ppr_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_paper_record`
    COMMENT '试卷答题记录表';

CREATE INDEX `ix_ppr_activity_id` ON `sys_paper_record` (`activity_id`);
CREATE INDEX `ix_ppr_enrollment_id` ON `sys_paper_record` (`enrollment_id`);
CREATE INDEX `ix_ppr_resource_id` ON `sys_paper_record` (`resource_id`);
CREATE INDEX `ix_ppr_user_id` ON `sys_paper_record` (`user_id`);
CREATE INDEX `ix_ppr_session_id` ON `sys_paper_record` (`session_id`);

CREATE TABLE `sys_paper_question_record`
(
    `id`              BIGINT UNSIGNED     NOT NULL COMMENT 'ID',
    `activity_id`     BIGINT UNSIGNED     NOT NULL COMMENT '活动ID',
    `enrollment_id`   BIGINT UNSIGNED     NOT NULL COMMENT '报名ID',
    `resource_id`     BIGINT UNSIGNED     NOT NULL COMMENT '资源ID',
    `user_id`         BIGINT UNSIGNED     NOT NULL COMMENT '用户ID',
    `paper_record_id` BIGINT UNSIGNED     NOT NULL COMMENT '作答ID',
    `question_id`     BIGINT UNSIGNED     NOT NULL COMMENT '题目ID',
    `session_id`      VARCHAR(150) COMMENT '会话ID',
    `type`            VARCHAR(100) COMMENT '类型',
    `answer`          TEXT COMMENT '答案',
    `score`           FLOAT(10, 2) COMMENT '分数',
    `idx`             INT UNSIGNED COMMENT '序号',
    `correct_status`  TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '正确状态',
    `score_status`    VARCHAR(50) COMMENT '评分状态',
    `created_at`      DATETIME COMMENT '创建时间',
    `created_by`      BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_pqr_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_paper_question_record`
    COMMENT '题目记录表';

CREATE INDEX `ix_pqr_paper_record_id` ON `sys_paper_question_record` (`paper_record_id`);
CREATE INDEX `ix_pqr_activity_id` ON `sys_paper_question_record` (`activity_id`);
CREATE INDEX `ix_pqr_enrollment_id` ON `sys_paper_question_record` (`enrollment_id`);
CREATE INDEX `ix_pqr_resource_id` ON `sys_paper_question_record` (`resource_id`);
CREATE INDEX `ix_pqr_user_id` ON `sys_paper_question_record` (`user_id`);
CREATE INDEX `ix_pqr_session_id` ON `sys_paper_question_record` (`session_id`);

CREATE TABLE `sys_paper_option_record`
(
    `id`                       BIGINT UNSIGNED NOT NULL COMMENT 'ID',
    `paper_record_id`          BIGINT UNSIGNED NOT NULL COMMENT '作答ID',
    `paper_question_record_id` BIGINT UNSIGNED NOT NULL COMMENT '题目答题记录ID',
    `activity_id`              BIGINT UNSIGNED NOT NULL COMMENT '活动ID',
    `enrollment_id`            BIGINT UNSIGNED NOT NULL COMMENT '报名ID',
    `resource_id`              BIGINT UNSIGNED NOT NULL COMMENT '资源ID',
    `user_id`                  BIGINT UNSIGNED NOT NULL COMMENT '用户ID',
    `question_id`              BIGINT UNSIGNED NOT NULL COMMENT '题目ID',
    `option_id`                BIGINT UNSIGNED NOT NULL COMMENT '选项ID',
    `session_id`               VARCHAR(150) COMMENT '会话ID',
    `score`                    FLOAT(10, 2) COMMENT '分数',
    `answer`                   VARCHAR(255) COMMENT '答案',
    `correct_ind`              TINYINT(1) COMMENT '是否正确',
    `created_at`               DATETIME COMMENT '创建时间',
    `created_by`               BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_por_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_paper_option_record`
    COMMENT '选项记录表';

CREATE INDEX `ix_por_ppr_id` ON `sys_paper_option_record` (`paper_record_id`);
CREATE INDEX `ix_por_pqr` ON `sys_paper_option_record` (`paper_question_record_id`);
CREATE INDEX `ix_por_activity_id` ON `sys_paper_option_record` (`activity_id`);
CREATE INDEX `ix_por_enrollment_id` ON `sys_paper_option_record` (`enrollment_id`);
CREATE INDEX `ix_por_resource_id` ON `sys_paper_option_record` (`resource_id`);
CREATE INDEX `ix_por_user_id` ON `sys_paper_option_record` (`user_id`);
CREATE INDEX `ix_por_question_id` ON `sys_paper_option_record` (`question_id`);
CREATE INDEX `ix_por_option_id` ON `sys_paper_option_record` (`option_id`);
CREATE INDEX `ix_por_session_id` ON `sys_paper_option_record` (`session_id`);

/* 系统角色 */
INSERT INTO `sys_role` (`id`, `tenant_id`, `code`, `label`, `active`, `created_at`, `modified_at`)
VALUES (1, 1, 'sysadmin', 'label_role_type_system_administrator', 1, now(), now());

INSERT INTO `sys_role` (`id`, `tenant_id`, `code`, `label`, `active`, `created_at`, `modified_at`)
VALUES (2, 1, 'admin', 'label_role_type_administrator', 1, now(), now());

INSERT INTO `sys_role` (`id`, `tenant_id`, `code`, `label`, `active`, `created_at`, `modified_at`)
VALUES (3, 1, 'trainer', 'label_role_type_trainer', 1, now(), now());

INSERT INTO `sys_role` (`id`, `tenant_id`, `code`, `label`, `active`, `created_at`, `modified_at`)
VALUES (4, 1, 'learner', 'label_role_type_learner', 1, now(), now());

/* 系统管理员 */
INSERT INTO `sys_user` (`id`, `username`, `email`, `mobile`,
                        `nickname`, `status`, `active`, `password`,
                        `created_at`, `created_by`, `modified_at`, `modified_by`)
VALUES (1, 'admin', 'master@elvea.cn', '13800138000', 'Administrator', 1, 1,
        '$2a$10$xq4enPCLvDBgiJX6rczJK.LgwaLyLtbgqgaC8Nj0kqsVdHZ6KJEg.',
        now(), 1, now(), 1);

INSERT INTO `sys_user_tenant_relation` (`id`, `tenant_id`, `user_id`, `created_at`, `created_by`)
VALUES (1, 1, 1, now(), 1);

INSERT INTO `sys_user_role_relation` (`id`, `tenant_id`, `user_id`, `role_id`, `created_at`, `created_by`)
VALUES (1, 1, 1, 1, now(), 1);
INSERT INTO `sys_user_role_relation` (`id`, `tenant_id`, `user_id`, `role_id`, `created_at`, `created_by`)
VALUES (2, 1, 1, 2, now(), 1);
INSERT INTO `sys_user_role_relation` (`id`, `tenant_id`, `user_id`, `role_id`, `created_at`, `created_by`)
VALUES (3, 1, 1, 3, now(), 1);
INSERT INTO `sys_user_role_relation` (`id`, `tenant_id`, `user_id`, `role_id`, `created_at`, `created_by`)
VALUES (4, 1, 1, 4, now(), 1);

/* 顶层租户 */
INSERT INTO `sys_tenant` (`id`, `code`, `title`, `active`, `root_ind`, `created_at`, `start_datetime`, `end_datetime`)
VALUES (1, 'TOP', 'Top Tenant', 1, 1, now(), '1999-1-1 00:00:00', '9999-12-30 23:59:59');

/* 活动类型 */
INSERT INTO `sys_activity_type` (`id`, `type`, `label`, `active`, `created_at`, `modified_at`)
VALUES (1, 'ONLINE_TRAINING', 'label_activity_type_online_training', 1, now(), now());
INSERT INTO `sys_activity_type` (`id`, `type`, `label`, `active`, `created_at`, `modified_at`)
VALUES (2, 'ONLINE_EXAM', 'label_activity_type_online_exam', 1, now(), now());
INSERT INTO `sys_activity_type` (`id`, `type`, `label`, `active`, `created_at`, `modified_at`)
VALUES (3, 'OFFLINE_TRAINING', 'label_activity_type_offline_training', 1, now(), now());

/* 资源类型 */
INSERT INTO `sys_resource_type` (`id`, `type`, `label`, `active`, `created_at`, `modified_at`)
VALUES (1, 'STATIC_PAPER', 'label_resource_type_static_paper', 1, now(), now());
INSERT INTO `sys_resource_type` (`id`, `type`, `label`, `active`, `created_at`, `modified_at`)
VALUES (2, 'DYNAMIC_PAPER', 'label_resource_type_dynamic_paper', 1, now(), now());
INSERT INTO `sys_resource_type` (`id`, `type`, `label`, `active`, `created_at`, `modified_at`)
VALUES (3, 'IMAGE', 'label_resource_type_image', 1, now(), now());
INSERT INTO `sys_resource_type` (`id`, `type`, `label`, `active`, `created_at`, `modified_at`)
VALUES (4, 'VIDEO', 'label_resource_type_video', 1, now(), now());
INSERT INTO `sys_resource_type` (`id`, `type`, `label`, `active`, `created_at`, `modified_at`)
VALUES (5, 'AUDIO', 'label_resource_type_audio', 1, now(), now());
