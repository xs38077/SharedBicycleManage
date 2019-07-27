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

 Date: 27/07/2019 16:22:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '组id',
  `dict_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '页面显示的名称',
  `dict_value` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '页面提交的值',
  `sort` int(11) NOT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES (1, 'model', '公路自行车', '1', 1);
INSERT INTO `dict` VALUES (2, 'model', '山地自行车', '2', 2);
INSERT INTO `dict` VALUES (3, 'model', '折叠自行车', '3', 3);
INSERT INTO `dict` VALUES (4, 'model', '旅行自行车', '4', 4);

SET FOREIGN_KEY_CHECKS = 1;
