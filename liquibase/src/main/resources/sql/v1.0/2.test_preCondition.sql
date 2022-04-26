ALTER TABLE
tb_user
ADD COLUMN `is_deleted` int(1) DEFAULT '0' COMMENT '逻辑删除;0：正常 1：已删除';