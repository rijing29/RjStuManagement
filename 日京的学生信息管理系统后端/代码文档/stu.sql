/*
Navicat MySQL Data Transfer

Source Server         : DB
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2021-09-11 09:19:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu` (
  `sno` int(11) NOT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `sage` int(11) DEFAULT NULL,
  `saddress` varchar(255) DEFAULT NULL,
  `spwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu
-- ----------------------------
INSERT INTO `stu` VALUES ('1', '哈哈哈哈', '88', '火星', '456');
INSERT INTO `stu` VALUES ('2', '富士达富士达', '789', '会发生就', '789');
INSERT INTO `stu` VALUES ('4', '日京4', '12', '嘻嘻', 'rjnbnb');
INSERT INTO `stu` VALUES ('5', '日京5', '12', '嘻嘻', '123');
INSERT INTO `stu` VALUES ('6', '测试', '999', '上海', '广泛大使馆很舒服');
INSERT INTO `stu` VALUES ('7', '怎么可能', '12', '金星', 'rjnbnb');
