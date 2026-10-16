create database qkdb;
create table dept (
                      id int unsigned primary key auto_increment comment '部门id，主键',
                      name varchar(10) not null unique comment '部门名称',
                      status tinyint unsigned not null default 1 comment '状态：0-停用，1-正常',
                      create_time datetime not null comment '创建时间',
                      update_time datetime not null comment '修改时间'
) comment '部门信息表';

INSERT INTO dept (id, name, status, create_time, update_time) VALUES (1,'研发部',1,'2025-04-26 15:45:31','2025-07-26 15:27:40'),
                                                                     (2,'市场部',1,'2025-04-26 15:45:31','2025-07-26 15:27:40'),
                                                                     (3,'销售一部',1,'2025-04-26 15:45:31','2025-07-26 15:27:46'),
                                                                     (4,'人力资源部',1,'2025-04-26 15:45:31','2025-07-26 15:27:46'),
                                                                     (5,'财务部',1,'2025-04-26 15:45:31','2025-07-26 15:28:04'),
                                                                     (6,'客服部',0,'2025-04-26 15:45:31','2025-07-26 15:28:04'),
                                                                     (7,'技术支持部',1,'2025-04-26 15:45:31','2025-07-26 15:28:08'),
                                                                     (8,'产品部',1,'2025-04-26 15:45:31','2025-07-26 15:28:08'),
                                                                     (9,'运营部',0,'2025-04-26 15:45:31','2025-07-26 15:28:13'),
                                                                     (10,'采购部',1,'2025-04-26 15:45:31','2025-07-26 15:28:13'),
                                                                     (11,'法务部',0,'2025-04-26 15:45:31','2025-07-26 15:28:18'),
                                                                     (12,'设计部',1,'2025-04-26 15:45:31','2025-07-26 15:28:18'),
                                                                     (13,'公关部',0,'2025-04-26 15:45:31','2025-07-26 15:28:22'),
                                                                     (14,'质量部',1,'2025-04-26 15:45:31','2025-07-26 15:28:22'),
                                                                     (15,'战略部',1,'2025-04-26 15:45:31','2025-07-26 15:28:25'),
                                                                     (16,'市场一部',1,'2025-07-09 11:32:42','2025-07-26 15:28:25');

-- 课程表
create table course (
                        id int unsigned primary key auto_increment comment '课程id, 主键',
                        subject tinyint unsigned not null comment '课程学科，1:AI智能应用开发(Java), 2:AI大模型开发(Python)，3:AI鸿蒙开发，4:AI大数据，5:AI嵌入式，6:AI测试，7:AI运维',
                        name varchar(20) not null comment '课程名称',
                        price int unsigned not null comment '课程价格（元）',
                        target tinyint unsigned not null comment '适用人群, 1:小白学员, 2:初级程序员, 3:中级程序员',
                        description varchar(100) comment '课程介绍',
                        create_time datetime not null comment '创建时间',
                        update_time datetime not null comment '修改时间'
) comment '课程表';
drop table if exists course;
INSERT INTO course (id, subject, name, price, target, description, create_time, update_time) VALUES
                                                                                                 (1,1,'Java核心与AI开发基础',28,1,'Java核心与AI开发基础','2025-05-09 21:29:35','2025-05-24 10:31:53'),
                                                                                                 (2,2,'Python核心与AI开发基础',39,1,'主要讲解Python核心与AI开发基础','2025-05-09 21:30:00','2025-05-09 21:42:32'),
                                                                                                 (3,1,'AI驱动Web开发',2800,2,'AI驱动Web开发， 主要讲解Web开发的核心知识及Web项目的设计、开发、测试、部署','2025-05-22 11:01:40','2025-05-22 11:01:55'),
                                                                                                 (4,1,'企业级物联网项目',4500,2,'企业级物联网项目，主要讲解物联网项目的设计、开发、测试、部署全流程交付','2025-05-22 11:02:44','2025-05-22 11:02:44'),
                                                                                                 (6,1,'SpringAI大模型应用开发',1990,3,'SpringAI大模型应用开发','2025-05-22 11:08:26','2025-05-22 11:08:26'),
                                                                                                 (7,2,'数据分析',2000,2,'基于Python数据分析的','2025-05-22 21:44:49','2025-05-22 21:45:50'),
                                                                                                 (8,3,'前端基础',28,1,'前端基础，主要讲解HTML、CSS、JS等前端开发基础知识','2025-05-23 20:07:47','2025-05-23 20:07:47'),
                                                                                                 (9,2,'LangChain入门',1800,2,'LangChain入门，学习该框架如何操作AI大模型','2025-05-26 21:43:57','2025-05-26 21:44:26'),
                                                                                                 (10,1,'LangChain4j',299,2,'LangChain4j从入门到进阶, 适合AI初学者','2025-06-19 19:03:17','2025-06-19 19:03:17'),
                                                                                                 (11,1,'RAG增强检索',399,2,'RAG','2025-06-19 19:04:24','2025-06-19 19:04:24'),
                                                                                                 (12,1,'SpringCloud微服务框架',1200,2,'SpringCloud微服务框架及分布式解决方案','2025-06-22 14:41:16','2025-06-22 14:41:16'),
                                                                                                 (13,1,'微服务智能项目集',3899,2,'微服务智能项目集','2025-06-22 14:44:06','2025-06-22 14:44:06'),
                                                                                                 (14,1,'AI智能体项目-天机AI助理',4999,2,'AI智能体项目-天机AI助理','2025-06-22 14:44:31','2025-06-22 14:44:31');

-- 角色表
create table role (
                      id int unsigned not null primary key auto_increment comment '角色id, 主键',
                      name varchar(10) not null unique comment '角色名称',
                      label varchar(20) not null unique comment '角色标识',
                      remark varchar(50) comment '备注',
                      create_time datetime not null comment '创建时间',
                      update_time datetime not null comment '修改时间'
) comment '角色表';

INSERT INTO role (id, name, label, remark, create_time, update_time) VALUES (1, 'Java开发工程师', 'Develop', '研发部的', '2026-10-15 00:22:52', '2026-10-15 00:22:52');
INSERT INTO role (id, name, label, remark, create_time, update_time) VALUES (2, '咨询师', 'Consultant', '咨询部的', '2026-10-15 00:23:23', '2026-10-15 00:23:23');
INSERT INTO role (id, name, label, remark, create_time, update_time) VALUES (3, '运维工程师', 'DevOps', '负责信息系统的维护', '2026-10-15 00:24:19', '2026-10-15 00:24:19');
INSERT INTO role (id, name, label, remark, create_time, update_time) VALUES (4, '讲师', 'teacher', '负责授课', '2026-10-15 00:24:52', '2026-10-15 00:24:52');
INSERT INTO role (id, name, label, remark, create_time, update_time) VALUES (5, '校长', 'principle', '负责管理校区', '2026-10-15 00:25:25', '2026-10-15 00:25:25');
INSERT INTO role (id, name, label, remark, create_time, update_time) VALUES (6, '班主任', 'homeroomTeacher', '管理班级
', '2026-10-15 00:26:50', '2026-10-15 00:26:50');
INSERT INTO role (id, name, label, remark, create_time, update_time) VALUES (7, '行政', 'administration', '管理后勤', '2026-10-15 00:27:32', '2026-10-15 00:27:32');
INSERT INTO role (id, name, label, remark, create_time, update_time) VALUES (8, '研究员', 'research', '研发课程', '2026-10-15 00:29:22', '2026-10-15 00:29:22');

CREATE TABLE if not exists activity (
                                        `id` INT NOT NULL AUTO_INCREMENT COMMENT '活动ID，主键',
                                        `channel` TINYINT DEFAULT NULL COMMENT '渠道来源，1:线上活动, 2:推广介绍',
                                        `name` VARCHAR(100) NOT NULL COMMENT '活动名称',
                                        `start_time` DATETIME DEFAULT NULL COMMENT '开始时间',
                                        `end_time` DATETIME DEFAULT NULL COMMENT '结束时间',
                                        `description` VARCHAR(500) DEFAULT NULL COMMENT '活动简介',
                                        `type` TINYINT DEFAULT NULL COMMENT '活动类型，1:课程折扣, 2:代金券',
                                        `discount` DECIMAL(5,2) DEFAULT NULL COMMENT '课程折扣',
                                        `voucher` INT DEFAULT NULL COMMENT '代金券金额（元）',
                                        `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
                                        `update_time` DATETIME DEFAULT NULL COMMENT '修改时间',
                                        PRIMARY KEY (`id`)
) COMMENT='活动表';

-- ----------------------------
-- 初始化 20 条测试数据
-- ----------------------------
INSERT INTO activity (`channel`, `name`, `start_time`, `end_time`, `description`, `type`, `discount`, `voucher`, `create_time`, `update_time`) VALUES
                                                                                                                                                   (1, '双十一课程大促',         '2026-11-01 00:00:00', '2026-11-11 23:59:59', '双十一全场课程限时折扣，机会难得',            1, 5.00, NULL, '2026-10-01 09:00:00', '2026-10-01 09:00:00'),
                                                                                                                                                   (1, '双十二代金券狂欢',       '2026-12-01 00:00:00', '2026-12-12 23:59:59', '领取代金券，购课立减',                          2, NULL, 200,  '2026-10-02 09:30:00', '2026-10-02 09:30:00'),
                                                                                                                                                   (2, '老学员推荐有礼',         '2026-09-15 00:00:00', '2026-12-31 23:59:59', '老学员推荐新学员报名，双方均可获得优惠',         2, NULL, 100,  '2026-09-10 10:00:00', '2026-09-10 10:00:00'),
                                                                                                                                                   (1, '国庆黄金周课程特惠',     '2026-10-01 00:00:00', '2026-10-07 23:59:59', '国庆七天乐，课程低至6折',                        1, 6.00, NULL, '2026-09-20 14:00:00', '2026-09-25 16:00:00'),
                                                                                                                                                   (2, '朋友圈推广返券活动',     '2026-10-05 00:00:00', '2026-11-05 23:59:59', '分享活动到朋友圈即可领取50元代金券',             2, NULL, 50,   '2026-10-04 11:00:00', '2026-10-04 11:00:00'),
                                                                                                                                                   (1, 'Java全栈限时折扣',       '2026-10-10 00:00:00', '2026-10-31 23:59:59', 'Java全栈就业班限时7.5折',                        1, 7.50, NULL, '2026-10-08 09:00:00', '2026-10-08 09:00:00'),
                                                                                                                                                   (1, '前端新人首单立减',       '2026-10-15 00:00:00', '2026-11-15 23:59:59', '前端新人首单立减300元',                          2, NULL, 300,  '2026-10-12 10:30:00', '2026-10-12 10:30:00'),
                                                                                                                                                   (2, '企业合作推广月',         '2026-10-01 00:00:00', '2026-10-31 23:59:59', '与合作企业联合推广，报名享专属折扣',             1, 8.00, NULL, '2026-09-25 15:00:00', '2026-09-25 15:00:00'),
                                                                                                                                                   (1, 'Python数据分析专场',     '2026-11-01 00:00:00', '2026-11-30 23:59:59', 'Python数据分析课程专场优惠',                     1, 6.50, NULL, '2026-10-20 09:00:00', '2026-10-20 09:00:00'),
                                                                                                                                                   (1, 'AI大模型课程首发',       '2026-11-10 00:00:00', '2026-12-10 23:59:59', 'AI大模型课程首发优惠，抢先报名',                 1, 8.50, NULL, '2026-10-25 16:00:00', '2026-10-25 16:00:00'),
                                                                                                                                                   (2, '校友推荐专享券',         '2026-10-20 00:00:00', '2026-12-20 23:59:59', '校友推荐报名，赠送500元代金券',                  2, NULL, 500,  '2026-10-18 11:20:00', '2026-10-18 11:20:00'),
                                                                                                                                                   (1, '周末直播公开课',         '2026-10-12 09:00:00', '2026-10-13 18:00:00', '周末直播公开课，参与即可领取代金券',             2, NULL, 80,   '2026-10-10 09:00:00', '2026-10-10 09:00:00'),
                                                                                                                                                   (1, '寒假班预报名优惠',       '2026-12-01 00:00:00', '2027-01-15 23:59:59', '寒假班预报名享早鸟折扣',                         1, 7.00, NULL, '2026-11-20 10:00:00', '2026-11-20 10:00:00'),
                                                                                                                                                   (2, '微信群裂变活动',         '2026-10-25 00:00:00', '2026-11-25 23:59:59', '邀请3位好友进群即得150元代金券',                 2, NULL, 150,  '2026-10-22 14:00:00', '2026-10-22 14:00:00'),
                                                                                                                                                   (1, '大数据课程五折秒杀',     '2026-11-11 10:00:00', '2026-11-11 12:00:00', '双十一当日大数据课程限时五折秒杀',               1, 5.00, NULL, '2026-11-01 09:00:00', '2026-11-01 09:00:00'),
                                                                                                                                                   (1, '元旦跨年特惠',           '2026-12-25 00:00:00', '2027-01-05 23:59:59', '元旦跨年全场课程9折',                            1, 9.00, NULL, '2026-12-10 09:00:00', '2026-12-10 09:00:00'),
                                                                                                                                                   (2, '线下宣讲推广',           '2026-10-30 00:00:00', '2026-11-30 23:59:59', '线下高校宣讲会现场报名享专属代金券',             2, NULL, 250,  '2026-10-28 15:30:00', '2026-10-28 15:30:00'),
                                                                                                                                                   (1, 'UI设计课程满减',         '2026-11-05 00:00:00', '2026-12-05 23:59:59', 'UI设计课程满1000减200',                          2, NULL, 200,  '2026-11-01 10:00:00', '2026-11-01 10:00:00'),
                                                                                                                                                   (1, '测试开发工程师折扣季',   '2026-11-15 00:00:00', '2026-12-15 23:59:59', '测试开发课程折扣季，低至6.8折',                  1, 6.80, NULL, '2026-11-10 09:00:00', '2026-11-10 09:00:00'),
                                                                                                                                                   (2, 'B站UP主联名推广',        '2026-11-20 00:00:00', '2026-12-20 23:59:59', 'B站UP主联名推广，报名即送300元代金券',           2, NULL, 300,  '2026-11-15 11:00:00', '2026-11-15 11:00:00');

-- 用户表
create table user (
                      id int unsigned primary key auto_increment comment 'id, 主键',
                      username varchar(20) not null unique comment '用户名，唯一',
                      password varchar(64) not null comment '密码',
                      name varchar(20) not null comment '姓名',
                      phone char(11) not null unique comment '手机号，唯一',
                      email varchar(50) not null unique comment '邮箱，唯一',
                      gender tinyint unsigned not null comment '性别，1: 男，2: 女',
                      status tinyint unsigned not null comment '状态，1: 正常，0: 停用',
                      dept_id int unsigned comment '部门id，关联部门表主键',
                      role_id int unsigned comment '角色id，关联角色表主键',
                      image varchar(255) comment '头像url',
                      remark varchar(50) comment '备注，50字以内',
                      create_time datetime not null comment '创建时间',
                      update_time datetime not null comment '修改时间'
) comment '用户表';

INSERT INTO user (id, username, password, name, phone, email, gender, status, dept_id, role_id, image, remark, create_time, update_time) VALUES
                                                                                                                                             (1,'zhangsan','4e7bdb88640b376ac6646b8f1ecfb558','张三','13800138001','admin@example.com',1,1,6,1,'https://web2025-test.oss-cn-beijing.aliyuncs.com/ee089310-479b-4672-a74a-dc680fa6a18a.png','系统管理员','2025-05-12 11:39:03','2025-06-21 15:25:55'),
                                                                                                                                             (2,'lisi','c3cb6d12c40908943b64bc0681af47db','李四','13800138002','editor1@example.com',1,1,4,2,'https://web2025-test.oss-cn-beijing.aliyuncs.com/62fcb582-074c-489a-8ea8-721bc8bba042.png','内容编辑','2025-05-12 11:39:03','2025-06-21 15:26:00'),
                                                                                                                                             (3,'sunwuji','368a7fccd730d807f41e2161798e13ca','孙无忌','18809091111','sunwuji@163.com',1,1,5,2,'https://web2025-test.oss-cn-beijing.aliyuncs.com/e65781f3-c87d-46e2-9d53-cf4329ce64e6.png','孙无忌刚入职，先在销售部磨炼磨炼','2025-05-12 16:46:21','2025-07-14 18:13:45'),
                                                                                                                                             (4,'songjiang','a91b1cfe31e6b534537ab992e06380f8','宋江','13800000001','songjiang@example.com',1,1,5,2,'https://web2025-test.oss-cn-beijing.aliyuncs.com/0bdd90db-17e1-407c-b922-27d987c9cc45.png','Remark 1','2025-05-14 15:49:31','2025-07-14 18:13:45'),
                                                                                                                                             (5,'lujunyi','ef73dd11149e096116f755a171eb3fec','卢俊义','13800000002','lujunyi@example.com',1,1,3,7,'https://web2025-test.oss-cn-beijing.aliyuncs.com/1564f4d9-7d07-4ea4-9e23-ecebe39d3520.png','Remark 2','2025-05-14 15:49:31','2025-07-14 18:13:45'),
                                                                                                                                             (6,'wuyong','d74bcf7b7f805922e4ad42315f3a8cde','吴用','13800000003','wuyong@example.com',1,0,7,2,'https://web2025-test.oss-cn-beijing.aliyuncs.com/cb074a33-4f30-4b3e-b9f1-bf8bf9d0f4ff.png','Remark 3','2025-05-14 15:49:31','2025-07-14 18:13:45'),
                                                                                                                                             (7,'gongsunsheng','ee3a229f2f3d2bd7c9dd3eeb4eda02b3','公孙胜','13800000004','gongsunsheng@example.com',1,1,5,2,'https://web2025-test.oss-cn-beijing.aliyuncs.com/284efce8-0b0c-4076-bbf6-3e104446ce70.png','Remark 4','2025-05-14 15:49:31','2025-07-14 18:13:45'),
                                                                                                                                             (8,'linchong','786271307576f1ee762341173a2caa48','林冲','13800000006','linchong@example.com',1,1,4,3,'https://web2025-test.oss-cn-beijing.aliyuncs.com/d2fbc991-c6de-4871-bd91-4a7d186b1f90.png','Remark 6','2025-05-14 15:49:31','2025-07-14 18:13:45'),
                                                                                                                                             (9,'qinming','23b9c4ea1f4d1844acd20a5314da8553','秦明','13800000007','qinming@example.com',1,1,5,2,'https://web2025-test.oss-cn-beijing.aliyuncs.com/d87de2cc-79a4-4a56-af9c-eb6aca52db66.png','Remark 7','2025-05-14 15:49:31','2025-07-14 18:13:45'),
                                                                                                                                             (10,'huarong','19d59a4e1e63552228b73b2cb2b5fcdd','花荣','13800000008','huayong@example.com',1,1,6,1,'https://web2025-test.oss-cn-beijing.aliyuncs.com/4775c1a5-4944-4aec-9753-9fa622dbbe75.png','Remark 8','2025-05-14 15:49:31','2025-07-14 18:13:45'),
                                                                                                                                             (11,'huyan','fbb39f3019cc4f5444dbd6b623f71a1a','呼延灼','13800000009','huyan@example.com',1,0,8,2,'https://web2025-test.oss-cn-beijing.aliyuncs.com/446aa6db-85b0-451f-bc11-92a52a518192.png','Remark 9','2025-05-14 15:49:31','2025-07-14 18:13:45'),
                                                                                                                                             (12,'huaqian','1007f13423a57bc0390d9510f96d0322','花千朵','13800000010','huaqian@example.com',2,1,10,3,'https://web2025-test.oss-cn-beijing.aliyuncs.com/63137d09-0734-4910-9502-b9b8d063b132.png','Remark 10','2025-05-14 15:49:31','2025-07-14 18:13:45'),
                                                                                                                                             (13,'shaqianmo','29d6fb85ac49d6d82b9b6dfd5f62939a','杀阡陌','13509091456','shaqianmo@163.com',0,1,5,2,'https://web2025-test.oss-cn-beijing.aliyuncs.com/ff8646a3-629b-4124-a2cb-f0365f9075c2.png','','2025-06-19 17:48:39','2025-07-14 18:13:45'),
                                                                                                                                             (14,'baizihua','f1659bd8a56022d817d6bd124c6181e8','白子画','13609091206','baizihua@163.com',1,1,3,7,'https://web2025-test.oss-cn-beijing.aliyuncs.com/421c0945-6f25-405c-b439-9b8b997338aa.png','系统研发','2025-06-22 14:33:49','2025-07-14 18:13:45'),
                                                                                                                                             (15,'huaqiangu','be6485aab12634baf922b3dbe407fcda','花千骨','15809092819','huaqiangu@163.com',0,1,6,7,'https://web2025-test.oss-cn-beijing.aliyuncs.com/735320dc-ac08-4b73-bdd7-7f0cf054274f.png','花千骨是一个普通用户','2025-06-24 10:40:20','2025-07-14 18:13:45'),
                                                                                                                                             (16,'kuangyetian','5e3c47c0d266439d7ce704972c92086a','旷野天','13689281921','kuangyetian@163.com',1,1,9,7,'https://web2025-test.oss-cn-beijing.aliyuncs.com/5d1f8e0f-2227-4469-8c90-7a02867fbe70.png','新入职的技术员旷野天','2025-06-27 19:38:34','2025-07-14 18:13:45');


SELECT * FROM user as u left join dept as d on u.dept_id = d.id
                        left join role as r on u.role_id = r.id;

