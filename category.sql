/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : ssm_hello2

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 23/02/2021 18:12:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 127 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (11, '李四');
INSERT INTO `category` VALUES (12, 'testPage-4');
INSERT INTO `category` VALUES (13, 'testPage-5');
INSERT INTO `category` VALUES (14, 'testPage-6');
INSERT INTO `category` VALUES (15, 'testPage-7');
INSERT INTO `category` VALUES (16, 'testPage-8');
INSERT INTO `category` VALUES (17, 'testPage-9');
INSERT INTO `category` VALUES (18, 'testPage-10');
INSERT INTO `category` VALUES (19, 'testPage-11');
INSERT INTO `category` VALUES (20, 'testPage-12');
INSERT INTO `category` VALUES (21, 'testPage-13');
INSERT INTO `category` VALUES (22, 'testPage-14');
INSERT INTO `category` VALUES (23, 'testPage-15');
INSERT INTO `category` VALUES (24, 'testPage-16');
INSERT INTO `category` VALUES (25, 'testPage-17');
INSERT INTO `category` VALUES (26, 'testPage-18');
INSERT INTO `category` VALUES (27, 'testPage-19');
INSERT INTO `category` VALUES (28, 'testPage-20');
INSERT INTO `category` VALUES (29, 'testPage-21');
INSERT INTO `category` VALUES (30, 'testPage-22');
INSERT INTO `category` VALUES (31, 'testPage-23');
INSERT INTO `category` VALUES (32, 'testPage-24');
INSERT INTO `category` VALUES (33, 'testPage-25');
INSERT INTO `category` VALUES (34, 'testPage-26');
INSERT INTO `category` VALUES (35, 'testPage-27');
INSERT INTO `category` VALUES (36, 'testPage-28');
INSERT INTO `category` VALUES (37, 'testPage-29');
INSERT INTO `category` VALUES (38, 'testPage-30');
INSERT INTO `category` VALUES (39, 'testPage-31');
INSERT INTO `category` VALUES (40, 'testPage-32');
INSERT INTO `category` VALUES (41, 'testPage-33');
INSERT INTO `category` VALUES (42, 'testPage-34');
INSERT INTO `category` VALUES (43, 'testPage-35');
INSERT INTO `category` VALUES (44, 'testPage-36');
INSERT INTO `category` VALUES (45, 'testPage-37');
INSERT INTO `category` VALUES (46, 'testPage-38');
INSERT INTO `category` VALUES (47, 'testPage-39');
INSERT INTO `category` VALUES (48, 'testPage-40');
INSERT INTO `category` VALUES (49, 'testPage-41');
INSERT INTO `category` VALUES (50, 'testPage-42');
INSERT INTO `category` VALUES (51, 'testPage-43');
INSERT INTO `category` VALUES (52, 'testPage-44');
INSERT INTO `category` VALUES (53, 'testPage-45');
INSERT INTO `category` VALUES (54, 'testPage-46');
INSERT INTO `category` VALUES (55, 'testPage-47');
INSERT INTO `category` VALUES (56, 'testPage-48');
INSERT INTO `category` VALUES (57, 'testPage-49');
INSERT INTO `category` VALUES (58, 'testPage-50');
INSERT INTO `category` VALUES (59, 'testPage-51');
INSERT INTO `category` VALUES (60, 'testPage-52');
INSERT INTO `category` VALUES (61, 'testPage-53');
INSERT INTO `category` VALUES (62, 'testPage-54');
INSERT INTO `category` VALUES (63, 'testPage-55');
INSERT INTO `category` VALUES (64, 'testPage-56');
INSERT INTO `category` VALUES (65, 'testPage-57');
INSERT INTO `category` VALUES (66, 'testPage-58');
INSERT INTO `category` VALUES (67, 'testPage-59');
INSERT INTO `category` VALUES (68, 'testPage-60');
INSERT INTO `category` VALUES (69, 'testPage-61');
INSERT INTO `category` VALUES (70, 'testPage-62');
INSERT INTO `category` VALUES (71, 'testPage-63');
INSERT INTO `category` VALUES (72, 'testPage-64');
INSERT INTO `category` VALUES (73, 'testPage-65');
INSERT INTO `category` VALUES (74, 'testPage-66');
INSERT INTO `category` VALUES (75, 'testPage-67');
INSERT INTO `category` VALUES (76, 'testPage-68');
INSERT INTO `category` VALUES (77, 'testPage-69');
INSERT INTO `category` VALUES (78, 'testPage-70');
INSERT INTO `category` VALUES (79, 'testPage-71');
INSERT INTO `category` VALUES (80, 'testPage-72');
INSERT INTO `category` VALUES (81, 'testPage-73');
INSERT INTO `category` VALUES (82, 'testPage-74');
INSERT INTO `category` VALUES (83, 'testPage-75');
INSERT INTO `category` VALUES (84, 'testPage-76');
INSERT INTO `category` VALUES (85, 'testPage-77');
INSERT INTO `category` VALUES (86, 'testPage-78');
INSERT INTO `category` VALUES (87, 'testPage-79');
INSERT INTO `category` VALUES (88, 'testPage-80');
INSERT INTO `category` VALUES (89, 'testPage-81');
INSERT INTO `category` VALUES (90, 'testPage-82');
INSERT INTO `category` VALUES (91, 'testPage-83');
INSERT INTO `category` VALUES (92, 'testPage-84');
INSERT INTO `category` VALUES (93, 'testPage-85');
INSERT INTO `category` VALUES (94, 'testPage-86');
INSERT INTO `category` VALUES (95, 'testPage-87');
INSERT INTO `category` VALUES (96, 'testPage-88');
INSERT INTO `category` VALUES (97, 'testPage-89');
INSERT INTO `category` VALUES (98, 'testPage-90');
INSERT INTO `category` VALUES (99, 'testPage-91');
INSERT INTO `category` VALUES (100, 'testPage-92');
INSERT INTO `category` VALUES (101, 'testPage-93');
INSERT INTO `category` VALUES (102, 'testPage-94');
INSERT INTO `category` VALUES (103, 'testPage-95');
INSERT INTO `category` VALUES (104, 'testPage-96');
INSERT INTO `category` VALUES (105, 'testPage-97');
INSERT INTO `category` VALUES (112, '王五');
INSERT INTO `category` VALUES (114, '张三');
INSERT INTO `category` VALUES (115, '张三');
INSERT INTO `category` VALUES (116, '王7');
INSERT INTO `category` VALUES (118, 'hhh');
INSERT INTO `category` VALUES (119, 'zzzzz');
INSERT INTO `category` VALUES (120, 'papapa');
INSERT INTO `category` VALUES (121, 'kkk');
INSERT INTO `category` VALUES (122, 'mm');
INSERT INTO `category` VALUES (123, 'ddd');

SET FOREIGN_KEY_CHECKS = 1;
