/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : health

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 27/08/2020 22:42:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_checkgroup
-- ----------------------------
DROP TABLE IF EXISTS `t_checkgroup`;
CREATE TABLE `t_checkgroup` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `code` varchar(32) DEFAULT NULL,
                                `name` varchar(32) DEFAULT NULL,
                                `helpCode` varchar(32) DEFAULT NULL,
                                `sex` char(1) DEFAULT NULL,
                                `remark` varchar(128) DEFAULT NULL,
                                `attention` varchar(128) DEFAULT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_checkgroup
-- ----------------------------
BEGIN;
INSERT INTO `t_checkgroup` VALUES (5, '0001', '一般检查', 'YBJC', '0', '一般检查', '无');
INSERT INTO `t_checkgroup` VALUES (6, '0002', '视力色觉', 'SLSJ', '0', '视力色觉', NULL);
INSERT INTO `t_checkgroup` VALUES (7, '0003', '血常规', 'XCG', '0', '血常规', NULL);
INSERT INTO `t_checkgroup` VALUES (8, '0004', '尿常规', 'NCG', '0', '尿常规', NULL);
INSERT INTO `t_checkgroup` VALUES (9, '0005', '肝功三项', 'GGSX', '0', '肝功三项', NULL);
INSERT INTO `t_checkgroup` VALUES (10, '0006', '肾功三项', 'NGSX', '0', '肾功三项', NULL);
INSERT INTO `t_checkgroup` VALUES (11, '0007', '血脂四项', 'XZSX', '0', '血脂四项', NULL);
INSERT INTO `t_checkgroup` VALUES (12, '0008', '心肌酶三项', 'XJMSX', '0', '心肌酶三项', NULL);
INSERT INTO `t_checkgroup` VALUES (13, '0009', '甲功三项', 'JGSX', '0', '甲功三项', NULL);
INSERT INTO `t_checkgroup` VALUES (14, '0010', '子宫附件彩超', 'ZGFJCC', '2', '子宫附件彩超', NULL);
INSERT INTO `t_checkgroup` VALUES (15, '0011', '胆红素三项', 'DHSSX', '0', '胆红素三项', NULL);
INSERT INTO `t_checkgroup` VALUES (23, 'e123', 'ewqeqw', 'eqweqw', '1', 'eqweqw', 'eqweqw');
COMMIT;

-- ----------------------------
-- Table structure for t_checkgroup_checkitem
-- ----------------------------
DROP TABLE IF EXISTS `t_checkgroup_checkitem`;
CREATE TABLE `t_checkgroup_checkitem` (
                                          `checkgroup_id` int(11) NOT NULL DEFAULT '0',
                                          `checkitem_id` int(11) NOT NULL DEFAULT '0',
                                          PRIMARY KEY (`checkgroup_id`,`checkitem_id`),
                                          KEY `item_id` (`checkitem_id`),
                                          CONSTRAINT `group_id` FOREIGN KEY (`checkgroup_id`) REFERENCES `t_checkgroup` (`id`),
                                          CONSTRAINT `item_id` FOREIGN KEY (`checkitem_id`) REFERENCES `t_checkitem` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_checkgroup_checkitem
-- ----------------------------
BEGIN;
INSERT INTO `t_checkgroup_checkitem` VALUES (5, 28);
INSERT INTO `t_checkgroup_checkitem` VALUES (23, 28);
INSERT INTO `t_checkgroup_checkitem` VALUES (5, 29);
INSERT INTO `t_checkgroup_checkitem` VALUES (23, 29);
INSERT INTO `t_checkgroup_checkitem` VALUES (5, 30);
INSERT INTO `t_checkgroup_checkitem` VALUES (23, 30);
INSERT INTO `t_checkgroup_checkitem` VALUES (5, 31);
INSERT INTO `t_checkgroup_checkitem` VALUES (5, 32);
INSERT INTO `t_checkgroup_checkitem` VALUES (6, 33);
INSERT INTO `t_checkgroup_checkitem` VALUES (6, 34);
INSERT INTO `t_checkgroup_checkitem` VALUES (6, 35);
INSERT INTO `t_checkgroup_checkitem` VALUES (6, 36);
INSERT INTO `t_checkgroup_checkitem` VALUES (6, 37);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 38);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 39);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 40);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 41);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 42);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 43);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 44);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 45);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 46);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 47);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 48);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 49);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 50);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 51);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 52);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 53);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 54);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 55);
INSERT INTO `t_checkgroup_checkitem` VALUES (7, 56);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 57);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 58);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 59);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 60);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 61);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 62);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 63);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 64);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 65);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 66);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 67);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 68);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 69);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 70);
INSERT INTO `t_checkgroup_checkitem` VALUES (8, 71);
INSERT INTO `t_checkgroup_checkitem` VALUES (9, 72);
INSERT INTO `t_checkgroup_checkitem` VALUES (9, 73);
INSERT INTO `t_checkgroup_checkitem` VALUES (9, 74);
INSERT INTO `t_checkgroup_checkitem` VALUES (10, 75);
INSERT INTO `t_checkgroup_checkitem` VALUES (10, 76);
INSERT INTO `t_checkgroup_checkitem` VALUES (10, 77);
INSERT INTO `t_checkgroup_checkitem` VALUES (11, 78);
INSERT INTO `t_checkgroup_checkitem` VALUES (11, 79);
INSERT INTO `t_checkgroup_checkitem` VALUES (11, 80);
INSERT INTO `t_checkgroup_checkitem` VALUES (11, 81);
INSERT INTO `t_checkgroup_checkitem` VALUES (12, 82);
INSERT INTO `t_checkgroup_checkitem` VALUES (12, 83);
INSERT INTO `t_checkgroup_checkitem` VALUES (12, 84);
INSERT INTO `t_checkgroup_checkitem` VALUES (13, 85);
INSERT INTO `t_checkgroup_checkitem` VALUES (13, 86);
INSERT INTO `t_checkgroup_checkitem` VALUES (13, 87);
INSERT INTO `t_checkgroup_checkitem` VALUES (14, 88);
INSERT INTO `t_checkgroup_checkitem` VALUES (14, 89);
INSERT INTO `t_checkgroup_checkitem` VALUES (15, 90);
INSERT INTO `t_checkgroup_checkitem` VALUES (15, 91);
INSERT INTO `t_checkgroup_checkitem` VALUES (15, 92);
COMMIT;

-- ----------------------------
-- Table structure for t_checkitem
-- ----------------------------
DROP TABLE IF EXISTS `t_checkitem`;
CREATE TABLE `t_checkitem` (
                               `id` int(11) NOT NULL AUTO_INCREMENT,
                               `code` varchar(16) DEFAULT NULL,
                               `name` varchar(32) DEFAULT NULL,
                               `sex` char(1) DEFAULT NULL,
                               `age` varchar(32) DEFAULT NULL,
                               `price` float DEFAULT NULL,
                               `type` char(1) DEFAULT NULL COMMENT '查检项类型,分为检查和检验两种',
                               `attention` varchar(128) DEFAULT NULL,
                               `remark` varchar(128) DEFAULT NULL,
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_checkitem
-- ----------------------------
BEGIN;
INSERT INTO `t_checkitem` VALUES (28, '0001', '身高', '0', '0-100', 5, '1', '无', '身高');
INSERT INTO `t_checkitem` VALUES (29, '0002', '体重', '0', '0-100', 5, '1', '无', '体重');
INSERT INTO `t_checkitem` VALUES (30, '0003', '体重指数', '0', '0-100', 5, '1', '无', '体重指数');
INSERT INTO `t_checkitem` VALUES (31, '0004', '收缩压', '0', '0-100', 5, '1', '无', '收缩压');
INSERT INTO `t_checkitem` VALUES (32, '0005', '舒张压', '0', '0-100', 5, '1', '无', '舒张压');
INSERT INTO `t_checkitem` VALUES (33, '0006', '裸视力（右）', '0', '0-100', 5, '1', '无', '裸视力（右）');
INSERT INTO `t_checkitem` VALUES (34, '0007', '裸视力（左）', '0', '0-100', 5, '1', '无', '裸视力（左）');
INSERT INTO `t_checkitem` VALUES (35, '0008', '矫正视力（右）', '0', '0-100', 5, '1', '无', '矫正视力（右）');
INSERT INTO `t_checkitem` VALUES (36, '0009', '矫正视力（左）', '0', '0-100', 5, '1', '无', '矫正视力（左）');
INSERT INTO `t_checkitem` VALUES (37, '0010', '色觉', '0', '0-100', 5, '1', '无', '色觉');
INSERT INTO `t_checkitem` VALUES (38, '0011', '白细胞计数', '0', '0-100', 10, '2', '无', '白细胞计数');
INSERT INTO `t_checkitem` VALUES (39, '0012', '红细胞计数', '0', '0-100', 10, '2', NULL, '红细胞计数');
INSERT INTO `t_checkitem` VALUES (40, '0013', '血红蛋白', '0', '0-100', 10, '2', NULL, '血红蛋白');
INSERT INTO `t_checkitem` VALUES (41, '0014', '红细胞压积', '0', '0-100', 10, '2', NULL, '红细胞压积');
INSERT INTO `t_checkitem` VALUES (42, '0015', '平均红细胞体积', '0', '0-100', 10, '2', NULL, '平均红细胞体积');
INSERT INTO `t_checkitem` VALUES (43, '0016', '平均红细胞血红蛋白含量', '0', '0-100', 10, '2', NULL, '平均红细胞血红蛋白含量');
INSERT INTO `t_checkitem` VALUES (44, '0017', '平均红细胞血红蛋白浓度', '0', '0-100', 10, '2', NULL, '平均红细胞血红蛋白浓度');
INSERT INTO `t_checkitem` VALUES (45, '0018', '红细胞分布宽度-变异系数', '0', '0-100', 10, '2', NULL, '红细胞分布宽度-变异系数');
INSERT INTO `t_checkitem` VALUES (46, '0019', '血小板计数', '0', '0-100', 10, '2', NULL, '血小板计数');
INSERT INTO `t_checkitem` VALUES (47, '0020', '平均血小板体积', '0', '0-100', 10, '2', NULL, '平均血小板体积');
INSERT INTO `t_checkitem` VALUES (48, '0021', '血小板分布宽度', '0', '0-100', 10, '2', NULL, '血小板分布宽度');
INSERT INTO `t_checkitem` VALUES (49, '0022', '淋巴细胞百分比', '0', '0-100', 10, '2', NULL, '淋巴细胞百分比');
INSERT INTO `t_checkitem` VALUES (50, '0023', '中间细胞百分比', '0', '0-100', 10, '2', NULL, '中间细胞百分比');
INSERT INTO `t_checkitem` VALUES (51, '0024', '中性粒细胞百分比', '0', '0-100', 10, '2', NULL, '中性粒细胞百分比');
INSERT INTO `t_checkitem` VALUES (52, '0025', '淋巴细胞绝对值', '0', '0-100', 10, '2', NULL, '淋巴细胞绝对值');
INSERT INTO `t_checkitem` VALUES (53, '0026', '中间细胞绝对值', '0', '0-100', 10, '2', NULL, '中间细胞绝对值');
INSERT INTO `t_checkitem` VALUES (54, '0027', '中性粒细胞绝对值', '0', '0-100', 10, '2', NULL, '中性粒细胞绝对值');
INSERT INTO `t_checkitem` VALUES (55, '0028', '红细胞分布宽度-标准差', '0', '0-100', 10, '2', NULL, '红细胞分布宽度-标准差');
INSERT INTO `t_checkitem` VALUES (56, '0029', '血小板压积', '0', '0-100', 10, '2', NULL, '血小板压积');
INSERT INTO `t_checkitem` VALUES (57, '0030', '尿比重', '0', '0-100', 10, '2', NULL, '尿比重');
INSERT INTO `t_checkitem` VALUES (58, '0031', '尿酸碱度', '0', '0-100', 10, '2', NULL, '尿酸碱度');
INSERT INTO `t_checkitem` VALUES (59, '0032', '尿白细胞', '0', '0-100', 10, '2', NULL, '尿白细胞');
INSERT INTO `t_checkitem` VALUES (60, '0033', '尿亚硝酸盐', '0', '0-100', 10, '2', NULL, '尿亚硝酸盐');
INSERT INTO `t_checkitem` VALUES (61, '0034', '尿蛋白质', '0', '0-100', 10, '2', NULL, '尿蛋白质');
INSERT INTO `t_checkitem` VALUES (62, '0035', '尿糖', '0', '0-100', 10, '2', NULL, '尿糖');
INSERT INTO `t_checkitem` VALUES (63, '0036', '尿酮体', '0', '0-100', 10, '2', NULL, '尿酮体');
INSERT INTO `t_checkitem` VALUES (64, '0037', '尿胆原', '0', '0-100', 10, '2', NULL, '尿胆原');
INSERT INTO `t_checkitem` VALUES (65, '0038', '尿胆红素', '0', '0-100', 10, '2', NULL, '尿胆红素');
INSERT INTO `t_checkitem` VALUES (66, '0039', '尿隐血', '0', '0-100', 10, '2', NULL, '尿隐血');
INSERT INTO `t_checkitem` VALUES (67, '0040', '尿镜检红细胞', '0', '0-100', 10, '2', NULL, '尿镜检红细胞');
INSERT INTO `t_checkitem` VALUES (68, '0041', '尿镜检白细胞', '0', '0-100', 10, '2', NULL, '尿镜检白细胞');
INSERT INTO `t_checkitem` VALUES (69, '0042', '上皮细胞', '0', '0-100', 10, '2', NULL, '上皮细胞');
INSERT INTO `t_checkitem` VALUES (70, '0043', '无机盐类', '0', '0-100', 10, '2', NULL, '无机盐类');
INSERT INTO `t_checkitem` VALUES (71, '0044', '尿镜检蛋白定性', '0', '0-100', 10, '2', NULL, '尿镜检蛋白定性');
INSERT INTO `t_checkitem` VALUES (72, '0045', '丙氨酸氨基转移酶', '0', '0-100', 10, '2', NULL, '丙氨酸氨基转移酶');
INSERT INTO `t_checkitem` VALUES (73, '0046', '天门冬氨酸氨基转移酶', '0', '0-100', 10, '2', NULL, '天门冬氨酸氨基转移酶');
INSERT INTO `t_checkitem` VALUES (74, '0047', 'Y-谷氨酰转移酶', '0', '0-100', 10, '2', NULL, 'Y-谷氨酰转移酶');
INSERT INTO `t_checkitem` VALUES (75, '0048', '尿素', '0', '0-100', 10, '2', NULL, '尿素');
INSERT INTO `t_checkitem` VALUES (76, '0049', '肌酐', '0', '0-100', 10, '2', NULL, '肌酐');
INSERT INTO `t_checkitem` VALUES (77, '0050', '尿酸', '0', '0-100', 10, '2', NULL, '尿酸');
INSERT INTO `t_checkitem` VALUES (78, '0051', '总胆固醇', '0', '0-100', 10, '2', NULL, '总胆固醇');
INSERT INTO `t_checkitem` VALUES (79, '0052', '甘油三酯', '0', '0-100', 10, '2', NULL, '甘油三酯');
INSERT INTO `t_checkitem` VALUES (80, '0053', '高密度脂蛋白胆固醇', '0', '0-100', 10, '2', NULL, '高密度脂蛋白胆固醇');
INSERT INTO `t_checkitem` VALUES (81, '0054', '低密度脂蛋白胆固醇', '0', '0-100', 10, '2', NULL, '低密度脂蛋白胆固醇');
INSERT INTO `t_checkitem` VALUES (82, '0055', '磷酸肌酸激酶', '0', '0-100', 10, '2', NULL, '磷酸肌酸激酶');
INSERT INTO `t_checkitem` VALUES (83, '0056', '磷酸肌酸激酶同工酶', '0', '0-100', 10, '2', NULL, '磷酸肌酸激酶同工酶');
INSERT INTO `t_checkitem` VALUES (84, '0057', '乳酸脱氢酶', '0', '0-100', 10, '2', NULL, '乳酸脱氢酶');
INSERT INTO `t_checkitem` VALUES (85, '0058', '三碘甲状腺原氨酸', '0', '0-100', 10, '2', NULL, '三碘甲状腺原氨酸');
INSERT INTO `t_checkitem` VALUES (86, '0059', '甲状腺素', '0', '0-100', 10, '2', NULL, '甲状腺素');
INSERT INTO `t_checkitem` VALUES (87, '0060', '促甲状腺激素', '0', '0-100', 10, '2', NULL, '促甲状腺激素');
INSERT INTO `t_checkitem` VALUES (88, '0061', '子宫', '2', '0-100', 10, '2', NULL, '子宫');
INSERT INTO `t_checkitem` VALUES (89, '0062', '附件', '2', '0-100', 10, '2', NULL, '附件');
INSERT INTO `t_checkitem` VALUES (90, '0063', '总胆红素', '0', '0-100', 10, '2', NULL, '总胆红素');
INSERT INTO `t_checkitem` VALUES (91, '0064', '直接胆红素', '0', '0-100', 10, '2', NULL, '直接胆红素');
INSERT INTO `t_checkitem` VALUES (92, '0065', '间接胆红素', '0', '0-100', 10, '2', NULL, '间接胆红素');
COMMIT;

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
                            `id` int(11) NOT NULL AUTO_INCREMENT,
                            `fileNumber` varchar(32) DEFAULT NULL,
                            `name` varchar(32) DEFAULT NULL,
                            `sex` varchar(8) DEFAULT NULL,
                            `idCard` varchar(18) DEFAULT NULL,
                            `phoneNumber` varchar(11) DEFAULT NULL,
                            `regTime` date DEFAULT NULL,
                            `password` varchar(32) DEFAULT NULL,
                            `email` varchar(32) DEFAULT NULL,
                            `birthday` date DEFAULT NULL,
                            `remark` varchar(128) DEFAULT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `fileNumber` (`fileNumber`),
                            UNIQUE KEY `idCard` (`idCard`)
) ENGINE=InnoDB AUTO_INCREMENT=10037 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_member
-- ----------------------------
BEGIN;
INSERT INTO `t_member` VALUES (82, 'CZJK00001', '小明', '1', '123456789000999999', '18811679442', '2019-03-08', NULL, NULL, '2020-08-12', NULL);
INSERT INTO `t_member` VALUES (83, 'CZJK00002', '王美丽', '1', '132333333333333', '13412345678', '2019-03-11', NULL, NULL, '2020-08-04', NULL);
INSERT INTO `t_member` VALUES (85, 'CZJK00003', NULL, NULL, NULL, NULL, '2019-03-06', NULL, NULL, '2020-05-05', NULL);
INSERT INTO `t_member` VALUES (86, 'CZJK00004', NULL, NULL, NULL, NULL, '2019-04-04', NULL, NULL, '2020-08-02', NULL);
INSERT INTO `t_member` VALUES (87, 'CZJK00005', NULL, NULL, NULL, NULL, '2019-02-06', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (88, NULL, NULL, NULL, NULL, NULL, '2019-04-10', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (89, NULL, NULL, NULL, NULL, NULL, '2018-12-01', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (90, NULL, NULL, NULL, NULL, NULL, '2018-12-02', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (91, NULL, NULL, NULL, NULL, NULL, '2018-02-01', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (92, NULL, 'qwe', '1', '342626188988900998', '18949918647', '2019-08-23', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (93, NULL, 'qwr', '1', '343633199901010001', '18944448888', '2019-09-09', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (94, NULL, '黄强', '1', '183555599990000', '18355559999', '2019-10-10', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (95, NULL, '张三', '1', '123456789987654', '18888889999', '2019-11-11', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (97, NULL, '李四', '1', '342625199909090011', '18355565128', '2019-12-12', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (1001, NULL, 'test', '1', '111111111111111', '', '2019-05-16', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (1002, NULL, NULL, NULL, NULL, NULL, '2019-05-03', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (1003, NULL, NULL, NULL, NULL, NULL, '2019-04-04', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (1004, NULL, NULL, NULL, NULL, NULL, '2019-05-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (1005, NULL, NULL, NULL, NULL, NULL, '2019-04-05', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (1006, NULL, NULL, NULL, NULL, NULL, '2019-04-10', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (1007, NULL, NULL, NULL, NULL, NULL, '2019-03-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (1008, NULL, NULL, NULL, NULL, NULL, '2019-03-09', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (1009, NULL, NULL, NULL, NULL, NULL, '2019-03-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10010, NULL, NULL, NULL, NULL, NULL, '2019-03-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10011, NULL, NULL, NULL, NULL, NULL, '2019-03-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10012, NULL, NULL, NULL, NULL, NULL, '2019-02-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10013, NULL, NULL, NULL, NULL, NULL, '2019-02-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10014, NULL, NULL, NULL, NULL, NULL, '2019-02-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10015, NULL, NULL, NULL, NULL, NULL, '2019-02-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10016, NULL, NULL, NULL, NULL, NULL, '2019-01-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10017, NULL, NULL, NULL, NULL, NULL, '2019-01-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10018, NULL, NULL, NULL, NULL, NULL, '2019-01-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10019, NULL, NULL, NULL, NULL, NULL, '2019-01-15', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10020, NULL, NULL, NULL, NULL, NULL, '2018-12-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10021, NULL, NULL, NULL, NULL, NULL, '2018-12-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10022, NULL, NULL, NULL, NULL, NULL, '2018-11-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10023, NULL, NULL, NULL, NULL, NULL, '2018-11-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10024, NULL, NULL, NULL, NULL, NULL, '2018-10-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10025, NULL, NULL, NULL, NULL, NULL, '2018-10-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10026, NULL, NULL, NULL, NULL, NULL, '2018-09-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10027, NULL, NULL, NULL, NULL, NULL, '2018-09-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10028, NULL, NULL, NULL, NULL, NULL, '2018-08-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10029, NULL, NULL, NULL, NULL, NULL, '2018-07-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10030, NULL, NULL, NULL, NULL, NULL, '2018-06-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10031, NULL, NULL, NULL, NULL, NULL, '2018-05-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10032, NULL, NULL, NULL, NULL, NULL, '2018-05-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10033, NULL, NULL, NULL, NULL, NULL, '2018-05-08', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10034, NULL, NULL, NULL, NULL, NULL, '2020-08-26', NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (10035, '321312', '1321312', '1', '313321', '312123', '2020-08-26', '396ab076399cc7aadb98bf10df56e07f', '313213', '2020-07-25', NULL);
INSERT INTO `t_member` VALUES (10036, '3123', '12312', '1', '333', '123456', '2020-08-26', '9b04d152845ec0a378394003c96da594', '312', '2020-08-01', NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `name` varchar(128) DEFAULT NULL,
                          `linkUrl` varchar(128) DEFAULT NULL,
                          `path` varchar(128) DEFAULT NULL,
                          `priority` int(11) DEFAULT NULL,
                          `icon` varchar(64) DEFAULT NULL,
                          `description` varchar(128) DEFAULT NULL,
                          `parentMenuId` int(11) DEFAULT NULL,
                          `level` int(11) DEFAULT NULL,
                          PRIMARY KEY (`id`),
                          KEY `FK_Reference_13` (`parentMenuId`),
                          CONSTRAINT `FK_Reference_13` FOREIGN KEY (`parentMenuId`) REFERENCES `t_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_menu` VALUES (1, '会员管理', NULL, '2', 1, 'fa-user-md', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (2, '会员档案', 'member.html', '/2-1', 1, NULL, NULL, 1, 2);
INSERT INTO `t_menu` VALUES (3, '体检上传', 'check_upload.html', '/2-2', 2, NULL, NULL, 1, 2);
INSERT INTO `t_menu` VALUES (5, '预约管理', NULL, '3', 2, 'fa-tty', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (6, '预约列表', 'ordersettinglist.html', '/3-1', 1, NULL, NULL, 5, 2);
INSERT INTO `t_menu` VALUES (7, '预约设置', 'ordersetting.html', '/3-2', 2, NULL, NULL, 5, 2);
INSERT INTO `t_menu` VALUES (8, '套餐管理', 'setmeal.html', '/3-3', 3, NULL, NULL, 5, 2);
INSERT INTO `t_menu` VALUES (9, '检查组管理', 'checkgroup.html', '/3-4', 4, NULL, NULL, 5, 2);
INSERT INTO `t_menu` VALUES (10, '检查项管理', 'checkitem.html', '/3-5', 5, NULL, NULL, 5, 2);
INSERT INTO `t_menu` VALUES (11, '健康评估', NULL, '4', 3, 'fa-stethoscope', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (12, '中医体质辨识', 'habitus_distinguish.html', '/4-1', 1, NULL, NULL, 11, 2);
INSERT INTO `t_menu` VALUES (13, '统计分析', NULL, '5', 4, 'fa-heartbeat', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (14, '会员统计', 'report_member.html', '/5-1', 1, NULL, NULL, 13, 2);
INSERT INTO `t_menu` VALUES (15, '系统设置', NULL, '6', 5, 'fa-users', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (16, '菜单管理', 'menu.html', '/6-1', 1, NULL, NULL, 15, 2);
INSERT INTO `t_menu` VALUES (17, '权限管理', 'permission.html', '/6-2', 2, NULL, NULL, 15, 2);
INSERT INTO `t_menu` VALUES (18, '角色管理', 'role.html', '/6-3', 3, NULL, NULL, 15, 2);
INSERT INTO `t_menu` VALUES (19, '用户管理', 'user.html', '/6-4', 4, NULL, NULL, 15, 2);
INSERT INTO `t_menu` VALUES (20, '套餐占比', 'report_setmeal.html', '/5-2', 2, NULL, NULL, 13, 2);
INSERT INTO `t_menu` VALUES (21, '运营数据', 'report_business.html', '/5-3', 3, NULL, NULL, 13, 2);
INSERT INTO `t_menu` VALUES (22, '工作台', 'work_platform.htlm', '1', 5, 'fa-dashboard', NULL, NULL, 1);
INSERT INTO `t_menu` VALUES (23, '地址管理', 'address_setting.html', '/1-1', 1, NULL, NULL, 22, 2);
COMMIT;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `member_id` int(11) DEFAULT NULL COMMENT '员会id',
                           `orderDate` date DEFAULT NULL COMMENT '约预日期',
                           `orderType` varchar(8) DEFAULT NULL COMMENT '约预类型 电话预约/微信预约',
                           `orderStatus` varchar(8) DEFAULT NULL COMMENT '预约状态（是否到诊）',
                           `setmeal_id` int(11) DEFAULT NULL COMMENT '餐套id',
                           PRIMARY KEY (`id`),
                           KEY `key_member_id` (`member_id`),
                           KEY `key_setmeal_id` (`setmeal_id`),
                           CONSTRAINT `key_member_id` FOREIGN KEY (`member_id`) REFERENCES `t_member` (`id`),
                           CONSTRAINT `key_setmeal_id` FOREIGN KEY (`setmeal_id`) REFERENCES `t_setmeal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES (2, 82, '2019-03-08', '微信预约', '未到诊', 6);
INSERT INTO `t_order` VALUES (3, 82, '2019-03-11', '微信预约', '未到诊', 11);
INSERT INTO `t_order` VALUES (4, 82, '2019-03-11', '微信预约', '未到诊', 7);
INSERT INTO `t_order` VALUES (5, 83, '2019-03-11', '微信预约', '未到诊', 7);
INSERT INTO `t_order` VALUES (6, 82, '2019-03-13', '微信预约', '未到诊', 6);
INSERT INTO `t_order` VALUES (7, 82, '2019-03-15', '微信预约', '未到诊', 6);
INSERT INTO `t_order` VALUES (8, 82, '2019-03-19', '微信预约', '未到诊', 5);
INSERT INTO `t_order` VALUES (9, 84, '2019-03-20', '微信预约', '未到诊', 6);
INSERT INTO `t_order` VALUES (10, 84, '2019-03-28', '微信预约', '未到诊', 11);
INSERT INTO `t_order` VALUES (11, 92, '2020-08-24', '微信预约', '未到诊', 5);
INSERT INTO `t_order` VALUES (12, 93, '2020-08-26', '微信预约', '未到诊', 5);
INSERT INTO `t_order` VALUES (13, 94, '2020-08-24', '微信预约', '未到诊', 5);
INSERT INTO `t_order` VALUES (14, 95, '2020-08-24', '微信预约', '未到诊', 5);
COMMIT;

-- ----------------------------
-- Table structure for t_ordersetting
-- ----------------------------
DROP TABLE IF EXISTS `t_ordersetting`;
CREATE TABLE `t_ordersetting` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT,
                                  `orderDate` date NOT NULL COMMENT '约预日期',
                                  `number` int(11) NOT NULL COMMENT '可预约人数',
                                  `reservations` int(11) DEFAULT NULL COMMENT '已预约人数',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ordersetting
-- ----------------------------
BEGIN;
INSERT INTO `t_ordersetting` VALUES (54, '2020-08-18', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (55, '2020-08-19', 300, NULL);
INSERT INTO `t_ordersetting` VALUES (56, '2020-08-20', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (57, '2020-08-21', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (58, '2020-08-22', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (59, '2020-08-23', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (60, '2020-08-24', 500, 3);
INSERT INTO `t_ordersetting` VALUES (61, '2020-08-25', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (62, '2020-08-26', 500, 1);
INSERT INTO `t_ordersetting` VALUES (63, '2020-08-27', 1234, NULL);
INSERT INTO `t_ordersetting` VALUES (64, '2020-08-28', 300, 300);
INSERT INTO `t_ordersetting` VALUES (65, '2020-08-29', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (66, '2020-08-30', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (67, '2020-08-31', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (68, '2020-09-01', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (69, '2020-09-02', 500, 1);
INSERT INTO `t_ordersetting` VALUES (70, '2020-09-03', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (71, '2020-09-04', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (89, '2020-08-01', 400, NULL);
INSERT INTO `t_ordersetting` VALUES (90, '2020-08-02', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (91, '2020-08-03', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (92, '2020-08-04', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (93, '2020-08-05', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (94, '2020-08-06', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (95, '2020-08-07', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (96, '2020-08-08', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (97, '2020-08-09', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (98, '2020-08-10', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (99, '2020-08-11', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (100, '2020-08-12', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (101, '2020-08-13', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (102, '2020-08-14', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (103, '2020-08-15', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (104, '2020-08-16', 500, NULL);
INSERT INTO `t_ordersetting` VALUES (105, '2020-08-17', 500, NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
                                `id` int(11) NOT NULL AUTO_INCREMENT,
                                `name` varchar(32) DEFAULT NULL,
                                `keyword` varchar(64) DEFAULT NULL,
                                `description` varchar(128) DEFAULT NULL,
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_permission` VALUES (1, '新增检查项', 'CHECKITEM_ADD', NULL);
INSERT INTO `t_permission` VALUES (2, '删除检查项', 'CHECKITEM_DELETE', NULL);
INSERT INTO `t_permission` VALUES (3, '编辑检查项', 'CHECKITEM_EDIT', NULL);
INSERT INTO `t_permission` VALUES (4, '查询检查项', 'CHECKITEM_QUERY', NULL);
INSERT INTO `t_permission` VALUES (5, '新增检查组', 'CHECKGROUP_ADD', NULL);
INSERT INTO `t_permission` VALUES (6, '删除检查组', 'CHECKGROUP_DELETE', NULL);
INSERT INTO `t_permission` VALUES (7, '编辑检查组', 'CHECKGROUP_EDIT', NULL);
INSERT INTO `t_permission` VALUES (8, '查询检查组', 'CHECKGROUP_QUERY', NULL);
INSERT INTO `t_permission` VALUES (9, '新增套餐', 'SETMEAL_ADD', NULL);
INSERT INTO `t_permission` VALUES (10, '删除套餐', 'SETMEAL_DELETE', NULL);
INSERT INTO `t_permission` VALUES (11, '编辑套餐', 'SETMEAL_EDIT', NULL);
INSERT INTO `t_permission` VALUES (12, '查询套餐', 'SETMEAL_QUERY', NULL);
INSERT INTO `t_permission` VALUES (13, '预约设置', 'ORDERSETTING', NULL);
INSERT INTO `t_permission` VALUES (14, '查看统计报表', 'REPORT_VIEW', NULL);
INSERT INTO `t_permission` VALUES (15, '新增菜单', 'MENU_ADD', NULL);
INSERT INTO `t_permission` VALUES (16, '删除菜单', 'MENU_DELETE', NULL);
INSERT INTO `t_permission` VALUES (17, '编辑菜单', 'MENU_EDIT', NULL);
INSERT INTO `t_permission` VALUES (18, '查询菜单', 'MENU_QUERY', NULL);
INSERT INTO `t_permission` VALUES (19, '新增角色', 'ROLE_ADD', NULL);
INSERT INTO `t_permission` VALUES (20, '删除角色', 'ROLE_DELETE', NULL);
INSERT INTO `t_permission` VALUES (21, '编辑角色', 'ROLE_EDIT', NULL);
INSERT INTO `t_permission` VALUES (22, '查询角色', 'ROLE_QUERY', NULL);
INSERT INTO `t_permission` VALUES (23, '新增用户', 'USER_ADD', NULL);
INSERT INTO `t_permission` VALUES (24, '删除用户', 'USER_DELETE', NULL);
INSERT INTO `t_permission` VALUES (25, '编辑用户', 'USER_EDIT', NULL);
INSERT INTO `t_permission` VALUES (26, '查询用户', 'USER_QUERY', NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `name` varchar(32) DEFAULT NULL,
                          `keyword` varchar(64) DEFAULT NULL,
                          `description` varchar(128) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES (1, '系统管理员', 'ROLE_ADMIN', NULL);
INSERT INTO `t_role` VALUES (2, '健康管理师', 'ROLE_HEALTH_MANAGER', NULL);
INSERT INTO `t_role` VALUES (3, '测试', 'ROLE_TEST', NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
                               `role_id` int(11) NOT NULL,
                               `menu_id` int(11) NOT NULL,
                               PRIMARY KEY (`role_id`,`menu_id`),
                               KEY `FK_Reference_10` (`menu_id`),
                               CONSTRAINT `FK_Reference_10` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`id`),
                               CONSTRAINT `FK_Reference_9` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `t_role_menu` VALUES (1, 1);
INSERT INTO `t_role_menu` VALUES (2, 1);
INSERT INTO `t_role_menu` VALUES (3, 1);
INSERT INTO `t_role_menu` VALUES (1, 2);
INSERT INTO `t_role_menu` VALUES (2, 2);
INSERT INTO `t_role_menu` VALUES (3, 2);
INSERT INTO `t_role_menu` VALUES (1, 3);
INSERT INTO `t_role_menu` VALUES (2, 3);
INSERT INTO `t_role_menu` VALUES (3, 3);
INSERT INTO `t_role_menu` VALUES (1, 5);
INSERT INTO `t_role_menu` VALUES (1, 6);
INSERT INTO `t_role_menu` VALUES (1, 7);
INSERT INTO `t_role_menu` VALUES (1, 8);
INSERT INTO `t_role_menu` VALUES (1, 9);
INSERT INTO `t_role_menu` VALUES (1, 10);
INSERT INTO `t_role_menu` VALUES (1, 11);
INSERT INTO `t_role_menu` VALUES (1, 12);
INSERT INTO `t_role_menu` VALUES (1, 13);
INSERT INTO `t_role_menu` VALUES (1, 14);
INSERT INTO `t_role_menu` VALUES (1, 15);
INSERT INTO `t_role_menu` VALUES (1, 16);
INSERT INTO `t_role_menu` VALUES (1, 17);
INSERT INTO `t_role_menu` VALUES (1, 18);
INSERT INTO `t_role_menu` VALUES (1, 19);
INSERT INTO `t_role_menu` VALUES (1, 20);
INSERT INTO `t_role_menu` VALUES (1, 21);
INSERT INTO `t_role_menu` VALUES (1, 22);
INSERT INTO `t_role_menu` VALUES (1, 23);
COMMIT;

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
                                     `role_id` int(11) NOT NULL,
                                     `permission_id` int(11) NOT NULL,
                                     PRIMARY KEY (`role_id`,`permission_id`),
                                     KEY `FK_Reference_12` (`permission_id`),
                                     CONSTRAINT `FK_Reference_11` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
                                     CONSTRAINT `FK_Reference_12` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_role_permission` VALUES (1, 1);
INSERT INTO `t_role_permission` VALUES (2, 1);
INSERT INTO `t_role_permission` VALUES (1, 2);
INSERT INTO `t_role_permission` VALUES (2, 2);
INSERT INTO `t_role_permission` VALUES (1, 3);
INSERT INTO `t_role_permission` VALUES (2, 3);
INSERT INTO `t_role_permission` VALUES (1, 4);
INSERT INTO `t_role_permission` VALUES (2, 4);
INSERT INTO `t_role_permission` VALUES (1, 5);
INSERT INTO `t_role_permission` VALUES (2, 5);
INSERT INTO `t_role_permission` VALUES (1, 6);
INSERT INTO `t_role_permission` VALUES (2, 6);
INSERT INTO `t_role_permission` VALUES (1, 7);
INSERT INTO `t_role_permission` VALUES (2, 7);
INSERT INTO `t_role_permission` VALUES (1, 8);
INSERT INTO `t_role_permission` VALUES (2, 8);
INSERT INTO `t_role_permission` VALUES (1, 9);
INSERT INTO `t_role_permission` VALUES (2, 9);
INSERT INTO `t_role_permission` VALUES (1, 10);
INSERT INTO `t_role_permission` VALUES (2, 10);
INSERT INTO `t_role_permission` VALUES (1, 11);
INSERT INTO `t_role_permission` VALUES (2, 11);
INSERT INTO `t_role_permission` VALUES (1, 12);
INSERT INTO `t_role_permission` VALUES (2, 12);
INSERT INTO `t_role_permission` VALUES (1, 13);
INSERT INTO `t_role_permission` VALUES (2, 13);
INSERT INTO `t_role_permission` VALUES (1, 14);
INSERT INTO `t_role_permission` VALUES (2, 14);
INSERT INTO `t_role_permission` VALUES (1, 15);
INSERT INTO `t_role_permission` VALUES (1, 16);
INSERT INTO `t_role_permission` VALUES (1, 17);
INSERT INTO `t_role_permission` VALUES (1, 18);
INSERT INTO `t_role_permission` VALUES (1, 19);
INSERT INTO `t_role_permission` VALUES (1, 20);
INSERT INTO `t_role_permission` VALUES (1, 21);
INSERT INTO `t_role_permission` VALUES (1, 22);
INSERT INTO `t_role_permission` VALUES (1, 23);
INSERT INTO `t_role_permission` VALUES (1, 24);
INSERT INTO `t_role_permission` VALUES (1, 25);
INSERT INTO `t_role_permission` VALUES (1, 26);
COMMIT;

-- ----------------------------
-- Table structure for t_setmeal
-- ----------------------------
DROP TABLE IF EXISTS `t_setmeal`;
CREATE TABLE `t_setmeal` (
                             `id` int(11) NOT NULL AUTO_INCREMENT,
                             `name` varchar(128) DEFAULT NULL,
                             `code` varchar(8) DEFAULT NULL,
                             `helpCode` varchar(16) DEFAULT NULL,
                             `sex` char(1) DEFAULT NULL,
                             `age` varchar(32) DEFAULT NULL,
                             `price` float DEFAULT NULL,
                             `remark` varchar(128) DEFAULT NULL,
                             `attention` varchar(128) DEFAULT NULL,
                             `img` varchar(128) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_setmeal
-- ----------------------------
BEGIN;
INSERT INTO `t_setmeal` VALUES (5, '入职无忧体检套餐（男女通用）', '0001', 'RZTJ', '0', '18-60', 300, '入职体检套餐', NULL, 'dc236b94cd0d4acebf9445d271f46e1cb.jpg');
INSERT INTO `t_setmeal` VALUES (6, '粉红珍爱(女)升级TM12项筛查体检套餐', '0002', 'FHZA', '2', '18-60', 1200, '本套餐针对宫颈(TCT检查、HPV乳头瘤病毒筛查）、乳腺（彩超，癌抗125），甲状腺（彩超，甲功验血）以及胸片，血常规肝功等有全面检查，非常适合女性全面疾病筛查使用。', NULL, '9967ab87198544319e46f21f922bdb1f1.jpg');
INSERT INTO `t_setmeal` VALUES (7, '阳光爸妈升级肿瘤12项筛查（男女单人）体检套餐', '0003', 'YGBM', '0', '55-100', 1400, '本套餐主要针对常见肿瘤筛查，肝肾、颈动脉、脑血栓、颅内血流筛查，以及风湿、颈椎、骨密度检查。', NULL, '558a6bcb236a4ce4bc2b0c3c4980e7291.jpg');
INSERT INTO `t_setmeal` VALUES (9, '孕前检查套餐（女）-精英版', '0005', 'YQJCNV', '2', '18-50', 1500, '孕前检查套餐（女）-精英版', NULL, '4ee6b3e15ce94b08ab7496657718073f1.jpg');
INSERT INTO `t_setmeal` VALUES (11, '珍爱高端升级肿瘤12项筛查（男女单人）', '0006', 'ZAGD', '0', '14-20', 2400, '本套餐是一款针对生化五项检查，心，肝，胆，胃，甲状腺，颈椎，肺功能，脑部检查（经颅多普勒）以及癌症筛查，适合大众人群体检的套餐。', NULL, '0f13a231d66f41e087f49eb687565083j.jpg');
COMMIT;

-- ----------------------------
-- Table structure for t_setmeal_checkgroup
-- ----------------------------
DROP TABLE IF EXISTS `t_setmeal_checkgroup`;
CREATE TABLE `t_setmeal_checkgroup` (
                                        `setmeal_id` int(11) NOT NULL DEFAULT '0',
                                        `checkgroup_id` int(11) NOT NULL DEFAULT '0',
                                        PRIMARY KEY (`setmeal_id`,`checkgroup_id`),
                                        KEY `checkgroup_key` (`checkgroup_id`),
                                        CONSTRAINT `checkgroup_key` FOREIGN KEY (`checkgroup_id`) REFERENCES `t_checkgroup` (`id`),
                                        CONSTRAINT `setmeal_key` FOREIGN KEY (`setmeal_id`) REFERENCES `t_setmeal` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_setmeal_checkgroup
-- ----------------------------
BEGIN;
INSERT INTO `t_setmeal_checkgroup` VALUES (5, 5);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 5);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 5);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 5);
INSERT INTO `t_setmeal_checkgroup` VALUES (5, 6);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 6);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 6);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 6);
INSERT INTO `t_setmeal_checkgroup` VALUES (5, 7);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 7);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 7);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 7);
INSERT INTO `t_setmeal_checkgroup` VALUES (5, 8);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 8);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 8);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 8);
INSERT INTO `t_setmeal_checkgroup` VALUES (5, 9);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 9);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 9);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 9);
INSERT INTO `t_setmeal_checkgroup` VALUES (5, 10);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 10);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 10);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 10);
INSERT INTO `t_setmeal_checkgroup` VALUES (5, 11);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 11);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 11);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 11);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 12);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 12);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 12);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 13);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 13);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 13);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 14);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 14);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 14);
INSERT INTO `t_setmeal_checkgroup` VALUES (6, 15);
INSERT INTO `t_setmeal_checkgroup` VALUES (7, 15);
INSERT INTO `t_setmeal_checkgroup` VALUES (9, 15);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `birthday` date DEFAULT NULL,
                          `gender` varchar(1) DEFAULT NULL,
                          `username` varchar(32) DEFAULT NULL,
                          `password` varchar(256) DEFAULT NULL,
                          `remark` varchar(32) DEFAULT NULL,
                          `station` varchar(1) DEFAULT NULL,
                          `telephone` varchar(11) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, '2020-08-04', '1', 'admin', '$2a$10$u/BcsUUqZNWUxdmDhbnoeeobJy6IBsL1Gn/S0dMxI2RbSgnMKJ.4a', NULL, NULL, '18949919900');
INSERT INTO `t_user` VALUES (2, '2020-08-31', '2', 'xiaoming', '$2a$10$lQSsQhPesJRbWPtR5HNmLepaSyyiDe2QMUZkbqMu8gjZdncoR9i8a', NULL, NULL, '18858886888');
INSERT INTO `t_user` VALUES (3, '2015-08-06', '1', 'test', '$2a$10$zYJRscVUgHX1wqwu90WereuTmIg6h/JGirGG4SWBsZ60wVPCgtF8W', NULL, NULL, '13801851877');
INSERT INTO `t_user` VALUES (4, '2020-08-03', '1', 'qwer', '$2a$10$5Ucod6sGQhmS5LLLrppU5.BM76/FVHfUoQaQAXWUJlnC2IkGbU7KG', NULL, NULL, '123455');
INSERT INTO `t_user` VALUES (6, '1995-04-19', '1', 'huangqiang', '$2a$10$u/BcsUUqZNWUxdmDhbnoeeobJy6IBsL1Gn/S0dMxI2RbSgnMKJ.4a', NULL, NULL, '1111');
COMMIT;

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
                               `user_id` int(11) NOT NULL,
                               `role_id` int(11) NOT NULL,
                               PRIMARY KEY (`user_id`,`role_id`),
                               KEY `FK_Reference_8` (`role_id`),
                               CONSTRAINT `FK_Reference_7` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`),
                               CONSTRAINT `FK_Reference_8` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
BEGIN;
INSERT INTO `t_user_role` VALUES (1, 1);
INSERT INTO `t_user_role` VALUES (2, 2);
INSERT INTO `t_user_role` VALUES (6, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
