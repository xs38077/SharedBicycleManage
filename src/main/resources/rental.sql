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

 Date: 27/07/2019 16:22:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rental
-- ----------------------------
DROP TABLE IF EXISTS `rental`;
CREATE TABLE `rental`  (
  `rental_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '租赁号',
  `bike_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单车型号 ',
  `bno` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单车编号 外键',
  `person_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '租赁人',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '租赁时间(默认当前时间)',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '归还时间',
  PRIMARY KEY (`rental_no`) USING BTREE,
  INDEX `bno`(`bno`) USING BTREE,
  CONSTRAINT `rental_ibfk_1` FOREIGN KEY (`bno`) REFERENCES `bicycle` (`bike_no`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of rental
-- ----------------------------
INSERT INTO `rental` VALUES ('BICYCLE20190001', 'JAT001', 'bf08e8ffae0d11e990c100ffbeeb9669', '小小酥', '15650118888', '2019-07-26 21:00:00', '2019-07-27 11:17:30');
INSERT INTO `rental` VALUES ('BICYCLE20190002', 'CK002', '51f538b7afa111e9853f00ffbeeb9669', 'Alex', '18866677447', '2019-07-26 21:05:00', '2019-07-27 11:18:07');
INSERT INTO `rental` VALUES ('BICYCLE20190003', 'CK001', 'bf08e8ffae0d11e9123450ffbeeb9669', '小王', '15650111234', '2019-07-27 15:50:00', '2019-07-27 16:51:00');

SET FOREIGN_KEY_CHECKS = 1;
