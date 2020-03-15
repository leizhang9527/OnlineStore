/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50157
Source Host           : localhost:3306
Source Database       : onlinestore

Target Server Type    : MYSQL
Target Server Version : 50157
File Encoding         : 65001

Date: 2018-09-05 20:12:22
*/

CREATE DATABASE IF NOT EXISTS onlinestore;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userPw` varchar(50) DEFAULT NULL,
  `userHmacMD5` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'admin', 'admin','fd28d1c62175754d924fdbd01a3ae7d5');

-- ----------------------------
-- Table structure for `t_catelog`
-- ----------------------------
DROP TABLE IF EXISTS `t_catelog`;
CREATE TABLE `t_catelog` (
  `catelog_id` int(11) NOT NULL,
  `catelog_name` varchar(50) DEFAULT NULL,
  `catelog_miaoshu` varchar(5000) DEFAULT NULL,
  `catelog_del` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`catelog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_catelog
-- ----------------------------
INSERT INTO `t_catelog` VALUES ('1', '玫瑰', '<p>玫瑰</p>', 'no');
INSERT INTO `t_catelog` VALUES ('2', '百合', '<p>百合</p>', 'no');
INSERT INTO `t_catelog` VALUES ('3', '郁金香', '<p>郁金香</p>', 'no');
INSERT INTO `t_catelog` VALUES ('4', '马蹄莲', '<p>马蹄莲</p>', 'no');
INSERT INTO `t_catelog` VALUES ('5', '康乃馨', '<p>康乃馨</p>', 'no');

-- ----------------------------
-- Table structure for `t_gonggao`
-- ----------------------------
DROP TABLE IF EXISTS `t_gonggao`;
CREATE TABLE `t_gonggao` (
  `gonggao_id` int(11) NOT NULL,
  `gonggao_title` varchar(500) DEFAULT NULL,
  `gonggao_content` varchar(8000) DEFAULT NULL,
  `gonggao_data` varchar(50) DEFAULT NULL,
  `gonggao_fabuzhe` varchar(50) DEFAULT NULL,
  `gonggao_del` varchar(45) DEFAULT NULL,
  `gonggao_one1` varchar(45) DEFAULT NULL,
  `gonggao_one2` varchar(45) DEFAULT NULL,
  `gonggao_one3` varchar(45) DEFAULT NULL,
  `gonggao_one4` varchar(45) DEFAULT NULL,
  `gonggao_one5` datetime DEFAULT NULL,
  `gonggao_one6` datetime DEFAULT NULL,
  `gonggao_one7` int(11) DEFAULT NULL,
  `gonggao_one8` int(11) DEFAULT NULL,
  PRIMARY KEY (`gonggao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gonggao
-- ----------------------------

-- ----------------------------
-- Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `goods_id` int(11) NOT NULL,
  `goods_name` varchar(500) DEFAULT NULL,
  `goods_miaoshu` varchar(5000) DEFAULT NULL,
  `goods_pic` varchar(45) DEFAULT NULL,
  `goods_yanse` varchar(45) DEFAULT NULL,
  `goods_shichangjia` int(11) DEFAULT NULL,
  `goods_tejia` int(11) DEFAULT NULL,
  `goods_isnottejia` varchar(45) DEFAULT NULL,
  `goods_isnottuijian` varchar(45) DEFAULT NULL,
  `goods_catelog_id` int(11) DEFAULT NULL,
  `goods_kucun` int(11) DEFAULT NULL,
  `goods_del` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('1', '玫瑰1', '<p>玫瑰1</p>', '/upload/1343013322230.png', 'NULL', '100', '88', 'yes', 'NULL', '1', '190', 'no');
INSERT INTO `t_goods` VALUES ('2', '玫瑰2', '<p>玫瑰2</p>', '/upload/1343013353155.png', 'NULL', '80', '78', 'yes', 'NULL', '1', '10111', 'no');
INSERT INTO `t_goods` VALUES ('3', '玫瑰3', '<p>玫瑰2</p>', '/upload/1343013383928.png', 'NULL', '90', '76', 'yes', 'NULL', '1', '1011', 'no');
INSERT INTO `t_goods` VALUES ('4', '玫瑰4', '<p>玫瑰4</p>', '/upload/1343013417576.png', 'NULL', '120', '111', 'yes', 'NULL', '1', '32103', 'no');
INSERT INTO `t_goods` VALUES ('5', '玫瑰5', '<p>玫瑰5</p>', '/upload/1343013448363.png', 'NULL', '110', '110', 'no', 'NULL', '1', '10111', 'no');
INSERT INTO `t_goods` VALUES ('6', '玫瑰6', '<p>玫瑰</p>', '/upload/1343013476388.png', 'NULL', '111', '111', 'no', 'NULL', '1', '1212', 'no');
INSERT INTO `t_goods` VALUES ('7', '百合', '<p>百合</p>', '/upload/1343013512210.png', 'NULL', '123', '123', 'no', 'NULL', '2', '3210321', 'no');
INSERT INTO `t_goods` VALUES ('8', '百合2', '<p>百合</p>', '/upload/1343013541159.png', 'NULL', '212', '212', 'no', 'NULL', '2', '213032', 'no');
INSERT INTO `t_goods` VALUES ('9', '百合3', '<p>百合3</p>', '/upload/1343013574113.png', 'NULL', '29', '26', 'yes', 'NULL', '2', '321032', 'no');
INSERT INTO `t_goods` VALUES ('10', '百合4', '<p>百合4</p>', '/upload/1343013607723.png', 'NULL', '212', '212', 'no', 'NULL', '2', '21032', 'no');
INSERT INTO `t_goods` VALUES ('11', '康乃馨', '<p>康乃馨</p>', '/upload/1343013653098.png', 'NULL', '213', '213', 'no', 'NULL', '5', '21321', 'no');
INSERT INTO `t_goods` VALUES ('12', '康乃馨2', '<p>康乃馨2</p>', '/upload/1343013691689.png', 'NULL', '21', '21', 'no', 'NULL', '5', '2323', 'no');

-- ----------------------------
-- Table structure for `t_liuyan`
-- ----------------------------
DROP TABLE IF EXISTS `t_liuyan`;
CREATE TABLE `t_liuyan` (
  `liuyan_id` int(11) NOT NULL,
  `liuyan_title` varchar(45) DEFAULT NULL,
  `liuyan_content` varchar(5000) DEFAULT NULL,
  `liuyan_date` varchar(45) DEFAULT NULL,
  `liuyan_user` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`liuyan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_liuyan
-- ----------------------------

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL,
  `order_bianhao` varchar(45) DEFAULT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `order_zhuangtai` varchar(45) DEFAULT NULL,
  `order_jine` int(11) DEFAULT NULL,
  `order_songhuodizhi` varchar(45) DEFAULT NULL,
  `order_fukuangfangshi` varchar(45) DEFAULT NULL,
  `order_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for `t_orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `t_orderitem`;
CREATE TABLE `t_orderitem` (
  `orderItem_id` int(11) NOT NULL,
  `order_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `goods_quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderItem_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `user_pw` varchar(45) DEFAULT NULL,
  `userHmacMD5` varchar(150) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `user_realname` varchar(45) DEFAULT NULL,
  `user_address` varchar(50) DEFAULT NULL,
  `user_sex` varchar(45) DEFAULT NULL,
  `user_tel` varchar(45) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `user_qq` varchar(45) DEFAULT NULL,
  `user_man` varchar(45) DEFAULT NULL,
  `user_age` varchar(45) DEFAULT NULL,
  `user_birthday` varchar(45) DEFAULT NULL,
  `user_xueli` varchar(45) DEFAULT NULL,
  `user_del` varchar(45) DEFAULT NULL,
  `user_one1` varchar(45) DEFAULT NULL,
  `user_one2` varchar(45) DEFAULT NULL,
  `user_one3` varchar(45) DEFAULT NULL,
  `user_one4` varchar(45) DEFAULT NULL,
  `user_one5` varchar(45) DEFAULT NULL,
  `user_one6` int(11) DEFAULT NULL,
  `user_one7` int(11) DEFAULT NULL,
  `user_one8` int(11) DEFAULT NULL,
  `user_one9` datetime DEFAULT NULL,
  `user_one10` datetime DEFAULT NULL,
  `user_one11` bigint(20) DEFAULT NULL,
  `user_one12` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
