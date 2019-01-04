/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-20 10:59:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) NOT NULL COMMENT '盐',
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1001', 'mm', '502285AB96A2E1455FE6A3F8BC5D929E3C53DA03232467B65B93A84E09818C8A5B6DA772E49A6B34E73EED47ADD12DBD6971A6C763D6F2C629EA4283BEB522CC', 'D62F05368E98C113CDB24AACF641E770', '1234322343');
INSERT INTO `user` VALUES ('1007', '大好人', '0B89D27FF4D401CD1E531642D5DDF470BBD327BFB6D41600B2BDFC6142187897F5D28403F39DB54D7E3563FAA63DCEC89BD7643D943DEDF8149548E79EC00C69', 'D5ECB2A31BC1C3CE2633EE000233DE74', '15100000000');
