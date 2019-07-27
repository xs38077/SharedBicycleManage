/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50631
 Source Host           : localhost:3306
 Source Schema         : sharedbicyclemanage

 Target Server Type    : MySQL
 Target Server Version : 50631
 File Encoding         : 65001

 Date: 27/07/2019 16:22:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `age` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Alex', '703f98fddf99e32c85f9435081081ea2', 21);
INSERT INTO `user` VALUES (2, 'John', '703f98fddf99e32c85f9435081081ea2', 22);
INSERT INTO `user` VALUES (3, 'Queen', '703f98fddf99e32c85f9435081081ea2', 18);
INSERT INTO `user` VALUES (4, 'David', '703f98fddf99e32c85f9435081081ea2', 28);

SET FOREIGN_KEY_CHECKS = 1;
