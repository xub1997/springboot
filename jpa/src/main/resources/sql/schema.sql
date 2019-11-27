-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS tb_user;

CREATE TABLE IF NOT EXISTS tb_user  (
  id varchar(36) NOT NULL COMMENT '用户编号',
  user_name varchar(40)   DEFAULT NULL COMMENT '用户名',
  nick_name varchar(40)   DEFAULT NULL COMMENT '昵称',
  salt varchar(255)   DEFAULT NULL COMMENT '盐值',
  pwd varchar(36)   DEFAULT NULL COMMENT '密码',
  open_id varchar(100)   DEFAULT NULL COMMENT 'openId',
  avatar varchar(255)   DEFAULT NULL COMMENT '头像',
  gender int(10)  DEFAULT NULL COMMENT '性别（0	未知 1男  2女）',
  phone varchar(11)   DEFAULT NULL COMMENT '手机号',
  country varchar(40)   DEFAULT NULL COMMENT '国家',
  province varchar(40)   DEFAULT NULL COMMENT '省份',
  city varchar(60)   DEFAULT NULL COMMENT '城市',
  address varchar(255)   DEFAULT NULL COMMENT '地址',
  email varchar(100)   DEFAULT NULL COMMENT 'Email',
  is_used tinyint(10)  DEFAULT 1 COMMENT '是否使用（1 正常使用  2禁用  3停止使用）',
  is_deleted tinyint(10)  DEFAULT 0 COMMENT '是否删除（0 未删除  1 已删除）',
  creator_id varchar(36)  DEFAULT NULL COMMENT '创建人id',
  creator varchar(40)  DEFAULT NULL COMMENT '创建人',
  create_time datetime(3)  DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  create_program varchar(100)  DEFAULT NULL COMMENT '创建程序',
  updater_id varchar(36)  DEFAULT NULL COMMENT '更新人id',
  updater varchar(40)  DEFAULT NULL COMMENT '更新人',
  update_time datetime(3)  DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  update_program varchar(100)  DEFAULT NULL COMMENT '更新程序',
  PRIMARY KEY (id)
) ENGINE = InnoDB;