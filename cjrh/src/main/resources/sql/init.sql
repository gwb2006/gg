-- 项目初始化SQL脚本
-- 包含用户管理相关表结构和初始数据
-- 适用于MySQL数据库

-- 设置字符集
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 用户表 (sys_user)
-- 对应实体类：com.example.cjrh.entity.User
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL UNIQUE COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `status` tinyint DEFAULT 1 COMMENT '状态：1=启用，0=禁用',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统用户表';

-- ----------------------------
-- 插入测试数据
-- ----------------------------
INSERT INTO `sys_user` VALUES 
(1, 'admin', '123456', '系统管理员', 'admin@example.com', '13800138000', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'test', '123456', '测试用户', 'test@example.com', '13900139000', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ----------------------------
-- 用户查询示例SQL
-- ----------------------------
-- 1. 查询所有用户
-- SELECT * FROM sys_user;

-- 2. 根据ID查询用户
-- SELECT * FROM sys_user WHERE id = ?;

-- 3. 根据用户名查询用户
-- SELECT * FROM sys_user WHERE username = ?;

-- 4. 查询启用状态的用户
-- SELECT * FROM sys_user WHERE status = 1;

-- 5. 更新用户信息
-- UPDATE sys_user SET nickname = ?, email = ?, phone = ?, status = ? WHERE id = ?;

-- 6. 删除用户
-- DELETE FROM sys_user WHERE id = ?;

-- ----------------------------
-- 事务示例SQL
-- ----------------------------
/*
START TRANSACTION;
INSERT INTO sys_user(username, password, nickname, status) VALUES(?, ?, ?, ?);
-- 其他操作
COMMIT;
-- 或 ROLLBACK;
*/

SET FOREIGN_KEY_CHECKS = 1;