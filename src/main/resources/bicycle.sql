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

 Date: 27/07/2019 16:22:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bicycle
-- ----------------------------
DROP TABLE IF EXISTS `bicycle`;
CREATE TABLE `bicycle`  (
  `bike_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键》单车编号',
  `model` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单车类别',
  `b_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单车型号',
  `gys` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `remain_num` int(11) NULL DEFAULT NULL COMMENT '剩余数量',
  `status` int(1) NULL DEFAULT 0 COMMENT '租赁状态',
  PRIMARY KEY (`bike_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bicycle
-- ----------------------------
INSERT INTO `bicycle` VALUES ('36b59e0fafa111e9853f00ffbeeb9669', '4', 'JAT002', '捷安特', 3, 0);
INSERT INTO `bicycle` VALUES ('51f538b7afa111e9853f00ffbeeb9669', '1', 'CK002', '崔克', 17, 0);
INSERT INTO `bicycle` VALUES ('bf08e8ffae0d11e9123450ffbeeb9669', '1', 'CK001', '崔克', 21, 1);
INSERT INTO `bicycle` VALUES ('bf08e8ffae0d11e990c100ffbeeb9669', '1', 'JAT001', '捷安特', 117, 0);
INSERT INTO `bicycle` VALUES ('bf08e8ffae0d11e990c110ffbeeb9669', '2', 'JAT001', '捷安特', 10, 0);

SET FOREIGN_KEY_CHECKS = 1;
