/*
建库
*/
DROP DATABASE IF EXISTS `lxp`;

CREATE DATABASE IF NOT EXISTS `lxp` DEFAULT CHARACTER SET `utf8mb4` DEFAULT COLLATE `utf8mb4_unicode_ci`;

USE `lxp`;

/* 用户表 */
CREATE TABLE `sys_user` (
    `id`          BIGINT UNSIGNED COMMENT 'ID'       NOT NULL,
    `username`    VARCHAR(150) COMMENT '用户名',
    `nickname`    VARCHAR(150) COMMENT '昵称',
    `fullname`    VARCHAR(150) COMMENT '全名',
    `email`       VARCHAR(255) COMMENT '邮箱',
    `mobile`      VARCHAR(255) COMMENT '手机',
    `password`    VARCHAR(255) COMMENT '密码',
    `status`      TINYINT(1) UNSIGNED COMMENT '用户状态' NOT NULL DEFAULT 0,
    `active`      TINYINT(1) UNSIGNED COMMENT '启用状态' NOT NULL DEFAULT 0,
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `modified_at` DATETIME COMMENT '修改时间',
    `modified_by` BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`  DATETIME COMMENT '删除人',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_sys_user_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user` COMMENT '用户表';

/* 权限表 */
CREATE TABLE `sys_role` (
    `id`          BIGINT UNSIGNED COMMENT 'ID'       NOT NULL,
    `code`        VARCHAR(150) COMMENT '编号'          NOT NULL,
    `label`       VARCHAR(150) COMMENT '文本'          NOT NULL,
    `active`      TINYINT(1) UNSIGNED COMMENT '启用状态' NOT NULL DEFAULT 0,
    `created_at`  DATETIME COMMENT '创建时间',
    `created_by`  BIGINT UNSIGNED COMMENT '创建人',
    `modified_at` DATETIME COMMENT '修改时间',
    `modified_by` BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`  DATETIME COMMENT '删除人',
    `deleted_by`  BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_sys_authority_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_role` COMMENT '角色表';

/* 用户权限关联表 */
CREATE TABLE `sys_user_role` (
    `id`         BIGINT UNSIGNED COMMENT 'ID'   NOT NULL,
    `user_id`    BIGINT UNSIGNED COMMENT '用户ID' NOT NULL,
    `role_id`    BIGINT UNSIGNED COMMENT '角色ID' NOT NULL,
    `created_at` DATETIME COMMENT '创建时间',
    `created_by` BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_user_authority_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_user_role` COMMENT '用户权限关联表';

/* 附件文件表 */
CREATE TABLE `sys_attachment_file` (
    `id`                BIGINT UNSIGNED COMMENT 'ID'       NOT NULL,
    `type`              VARCHAR(180) COMMENT '附件类型',
    `original_filename` VARCHAR(255) COMMENT '原始文件名',
    `filename`          VARCHAR(255) COMMENT '文件名',
    `url`               VARCHAR(255) COMMENT '文件链接',
    `extra`             TEXT COMMENT '附加信息',
    `active`            TINYINT(1) UNSIGNED COMMENT '启用状态' NOT NULL DEFAULT 0,
    `created_at`        DATETIME COMMENT '创建时间',
    `created_by`        BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`        DATETIME COMMENT '修改时间',
    `updated_by`        BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`        DATETIME COMMENT '删除时间',
    `deleted_by`        BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_attachment_file_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_attachment_file` COMMENT '附件文件表';

/* 附件关联表 */
CREATE TABLE `sys_attachment_relation` (
    `id`             BIGINT UNSIGNED COMMENT 'ID' NOT NULL,
    `target_type`    VARCHAR(180) COMMENT '附件类型',
    `target_id`      BIGINT UNSIGNED COMMENT '目标实体ID',
    `target_file_id` BIGINT UNSIGNED COMMENT '目标附件ID',
    `created_at`     DATETIME COMMENT '创建时间',
    `created_by`     BIGINT UNSIGNED COMMENT '创建人',
    CONSTRAINT `pk_sys_attachment_relation_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_attachment_relation` COMMENT '附件关联表';

/* 课程表 */
CREATE TABLE `sys_course` (
    `id`         BIGINT COMMENT 'ID'                NOT NULL,
    `code`       VARCHAR(150) COMMENT '编号'          NOT NULL,
    `title`      VARCHAR(150) COMMENT '昵称'          NOT NULL,
    `status`     TINYINT(1) UNSIGNED COMMENT '发布状态' NOT NULL DEFAULT 0,
    `active`     TINYINT(1) UNSIGNED COMMENT '启用状态' NOT NULL DEFAULT 0,
    `created_at` DATETIME COMMENT '创建时间',
    `created_by` BIGINT UNSIGNED COMMENT '创建人',
    `updated_at` DATETIME COMMENT '修改时间',
    `updated_by` BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at` DATETIME COMMENT '删除时间',
    `deleted_by` BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_course_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_course` COMMENT '课程表';

/* 课程报名记录表 */
CREATE TABLE `sys_course_enrollment` (
    `id`                   BIGINT UNSIGNED COMMENT 'ID'   NOT NULL,
    `user_id`              BIGINT UNSIGNED COMMENT '用户ID' NOT NULL,
    `course_id`            BIGINT UNSIGNED COMMENT '课程ID' NOT NULL,
    `enroll_datetime`      DATETIME COMMENT '报名日期',
    `enroll_status`        TINYINT(1) UNSIGNED COMMENT '报名状态',
    `commence_datetime`    DATETIME COMMENT '首次访问时间',
    `last_access_datetime` DATETIME COMMENT '最近访问时间',
    `total_attempt`        INT UNSIGNED COMMENT '尝试总次数',
    `total_time`           INT UNSIGNED COMMENT '学习总时长',
    `complete_datetime`    DATETIME COMMENT '完成时间',
    `complete_status`      TINYINT(1) UNSIGNED COMMENT '完成状态',
    `score`                FLOAT(10, 2) COMMENT '分数',
    `final_score`          FLOAT(10, 2) COMMENT '最终分数',
    `created_at`           DATETIME COMMENT '创建时间',
    `created_by`           BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`           DATETIME COMMENT '修改时间',
    `updated_by`           BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`           DATETIME COMMENT '删除时间',
    `deleted_by`           BIGINT UNSIGNED COMMENT '删除人',
    CONSTRAINT `pk_sys_course_enrollment_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_course_enrollment` COMMENT '课程报名记录表';

/* 资源表 */
CREATE TABLE `sys_resource` (
    `id`                        BIGINT UNSIGNED COMMENT 'ID'       NOT NULL,
    `type`                      VARCHAR(100) COMMENT '类型'          NOT NULL,
    `code`                      VARCHAR(150) COMMENT '编号'          NOT NULL,
    `title`                     VARCHAR(255) COMMENT '标题'          NOT NULL,
    `description`               VARCHAR(255) COMMENT '描述',
    `start_datetime`            DATETIME COMMENT '开始时间',
    `end_datetime`              DATETIME COMMENT '结束时间',
    `url`                       VARCHAR(255) COMMENT 'URL',
    `content`                   TEXT COMMENT '内容',
    `score`                     FLOAT(10, 2) UNSIGNED COMMENT '满分分数',
    `pass_percentage`           FLOAT(10, 2) UNSIGNED COMMENT '及格分数',
    `attempt_limit`             INT UNSIGNED COMMENT '最多允许尝试次数',
    `attempt_policy`            VARCHAR(50) COMMENT '尝试次数计算策略',
    `time_limit`                INT UNSIGNED COMMENT '最多允许尝试时长',
    `paper_generate_mode`       VARCHAR(50) COMMENT '试卷生成策略',
    `paper_allow_pause_ind`     TINYINT UNSIGNED COMMENT '是否允许暂停',
    `paper_display_mode`        VARCHAR(50) COMMENT '试卷答题形式',
    `paper_display_answer_mode` VARCHAR(50) COMMENT '答案显示形式',
    `paper_score_mode`          VARCHAR(50) COMMENT '试卷计分方式',
    `paper_score_policy`        VARCHAR(50) COMMENT '试卷计分策略',
    `convert_status`            TINYINT(1) UNSIGNED COMMENT '转换状态',
    `convert_attempt`           TINYINT(1) UNSIGNED COMMENT '转换尝试次数',
    `status`                    TINYINT(1) UNSIGNED COMMENT '发布状态' NOT NULL DEFAULT 0,
    `active`                    TINYINT(1) UNSIGNED COMMENT '启用状态' NOT NULL DEFAULT 0,
    `created_at`                DATETIME COMMENT '创建时间',
    `created_by`                BIGINT UNSIGNED COMMENT '创建人',
    `updated_at`                DATETIME COMMENT '修改时间',
    `updated_by`                BIGINT UNSIGNED COMMENT '修改人',
    `deleted_at`                DATETIME COMMENT '删除人',
    `deleted_by`                BIGINT UNSIGNED COMMENT '删除时间',
    CONSTRAINT `pk_sys_resource_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_resource` COMMENT '资源表';

/* 资源学习记录表 */
CREATE TABLE `sys_resource_attendance` (
    `id`                   BIGINT UNSIGNED COMMENT 'ID'   NOT NULL,
    `user_id`              BIGINT UNSIGNED COMMENT '用户ID' NOT NULL,
    `resource_id`          BIGINT UNSIGNED COMMENT '资源ID' NOT NULL,
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
    CONSTRAINT `pk_sys_resource_attendance_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_resource_attendance` COMMENT '资源学习记录表';

/* 资源学习历史记录表 */
CREATE TABLE `sys_resource_attendance_history` (
    `id`              BIGINT UNSIGNED COMMENT 'ID'   NOT NULL,
    `user_id`         BIGINT UNSIGNED COMMENT '用户ID' NOT NULL,
    `resource_id`     BIGINT UNSIGNED COMMENT '资源ID' NOT NULL,
    `session_id`      VARCHAR(150) COMMENT '学习会话ID'  NOT NULL,
    `total_time`      INT UNSIGNED COMMENT '学习时长',
    `score`           FLOAT(10, 2) UNSIGNED COMMENT '分数',
    `complete_status` TINYINT(1) UNSIGNED COMMENT '完成状态',
    `json_data`       LONGTEXT COMMENT '附加数据',
    `created_at`      DATETIME COMMENT '创建时间',
    `created_by`      BIGINT COMMENT '创建人',
    CONSTRAINT `pk_sys_resource_attendance_history_id` PRIMARY KEY (`id`)
);
ALTER TABLE `sys_resource_attendance_history` COMMENT '资源学习历史记录表';

/* 系统角色 */
INSERT INTO `sys_role` (`id`, `code`, `label`, `active`, `created_at`, `modified_at`)
VALUES (1, 'sysadmin', 'role_system_administrator', 1, now(), now());

INSERT INTO `sys_role` (`id`, `code`, `label`, `active`, `created_at`, `modified_at`)
VALUES (2, 'admin', 'role_administrator', 1, now(), now());

INSERT INTO `sys_role` (`id`, `code`, `label`, `active`, `created_at`, `modified_at`)
VALUES (3, 'user', 'role_user', 1, now(), now());

/* 系统管理员 */
INSERT INTO `sys_user` (`id`, `username`, `nickname`, `status`, `active`, `password`, `created_at`, `created_by`, `modified_at`, `modified_by`)
VALUES (1, 'admin', 'Administrator', 1, 1, '$2a$10$xq4enPCLvDBgiJX6rczJK.LgwaLyLtbgqgaC8Nj0kqsVdHZ6KJEg.', now(), 1, now(), 1);
