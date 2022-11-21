DROP DATABASE IF EXISTS `booktest`;

CREATE DATABASE `booktest`;
USE `booktest`;

DROP TABLE if EXISTS `book_list`;
create table `book_list` (
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY comment '书籍编号',
    `name` varchar(55) NOT NULL comment '书籍名称',
    `author` varchar(10) NOT NULL comment '作者',
    `type_id` INT(11) NOT NULL comment '类型id',
    `publisher` varchar(10) NOT NULL comment '出版商',
    `total` int(11) NOT NULL comment '剩余本书',
    `price` float NOT NULL comment '价格',
    `mark` varchar(255) NOT NULL comment '评论',
    `borrow_num` int(11) NOT NULL comment '借的数量'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

insert into book_list (ID, name, author, type_id, publisher, total, price, mark, borrow_num)
 values 
(4,	'红楼梦',	'曹雪芹',	4,	'九州出版社',	1,	652.72,	'古典名著',	0),
(5,	'根之情',	 '马文章',	5,	'新华出版社',	1,	77.62,	'历史书',	0),
(6,	'文化的力量',	'田学斌',	5,	'新华出版社',	1,	877.26,	'历史书',	0),
(7,	'爱的学徒',	 '彭彭',	4,	'上海社会科学院出版社',	1,	640.94,	'文学小说',	0),
(8,	'等待花开',	'王巨成',	6,	'安徽少年儿童出版社',	1,	993.6,	'儿童文学',	0),
(9,	'动物小说大王',	 '沈石溪',	6,	'安徽少年儿童出版社',	1,	366.68,	'儿童小说',	0),
(10,	'金融市场学',	 '张利兵',	7,	'立信会计出版社',	1,	7.06,	'金融教育书籍',	0),
(11	,'金融学',	 '严存宝',	7,	'中国金融出版社',	1,	35.4,	'金融学书籍',	0),
(12	,'冬至未至',	 '蠡湖吹雪',	4,	'新华出版社',	1,	609.77,	'文学小说',	0),
(13,	'雾灵三部曲',	'苏珊·谢德',	6,	'贵州人民出版社',	1,	419.03,	'儿童小说',	0);


DROP TABLE if EXISTS `book_type`;
create table `book_type` (
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY comment '类型编号', 
    `type_name` varchar(10) NOT NULL comment '书籍类型'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

DROP TABLE if EXISTS `book_borrow`;
create table `book_borrow` (
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY comment '订单编号',
    `book_id` varchar(55) NOT NULL comment '书籍编号',
    `book_person_id` varchar(10) NOT NULL comment '借阅人',
    `create_time` varchar(55) NOT NULL comment '借阅创建时间',
    `borrow_time` varchar(10) NOT NULL comment '借阅时间',
    `return_time` varchar(11) NOT NULL comment '归还时间'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

DROP TABLE if EXISTS `user_info`;
create table `user_info` (
    `id` INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY comment '用户id',
    `username` varchar(55) NOT NULL comment '用户姓名',
    `password` varchar(10) NOT NULL comment '用户密码',
    `email` varchar(55) NOT NULL comment '用户邮箱'
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

insert into user_info (ID, username, password, email)
values 
(4,	'admin',	123,	'123@gmail.com'),
(5,	'zhangsan',	123,	'zhngsan@gmail.com'),
(6,	'lisi',	123,	'lisi@gmail.com'),
(7	,'wangwu',	123,	'wangwu@gmail.com');