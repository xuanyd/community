/*
 小区管家数据库
 数据库名为：xqgj(小区管家）
 数据库表：user/section/topic/comment 
*/
drop database if exists xqgj;
create database xqgj;
use xqgj;

--创建用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `UserName` varchar(20) NOT NULL UNIQUE,
  `UserPasswd` varchar(100) NOT NULL,
  `UserEmail` varchar(30) NOT NULL,
  `HeadUrl` varchar(100),            --用户头像链接
  `UserPhone` varchar(20),           --用户手机号
  `Birthday` varchar(10),
  `Sex` int NOT NULL,
  `UserStatement` varchar(50),       --用户标语
  `UserRegData` datetime NOT NULL,   --用户注册时间
  `UserPoint` int,    --用户积分 
  `SManager` int      --是否是板块管理员
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建板块表
DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `sid` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `SManager` int NOT NULL,           --版主用户名
  `SName` varchar(20) NOT NULL,      --版块名
  `SContent` varchar(50) DEFAULT '', --版块描述
  `SReplyCount` int,                 --版块回复数
  `SClickCount` int,                 --版块点击数
  `SLastReplyUser` int,              --版块最后回复用户
  `SLastReplyTime` datetime,         --版块最后回复时间
  CONSTRAINT fk_section_user FOREIGN KEY (SManager) REFERENCES user(uid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建主题表
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `tid` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `tuid` int(11) NOT NULL,            --创建主题用户
  `tsid` int(11) NOT NULL,            --主题所在的版块
  `TReplyCount` int,                  --主题回复数
  `TTopic` varchar(10) NOT NULL,      --主题名
  `TContents` text NOT NULL,          --主题内容
  `TTime` datetime NOT NULL,          --主题创建时间
  `TClickCount` int,                  --主题点击数
  `TLastReplyTime` datetime NOT NULL, --最后回复时间
  `TLastReplyUser` int(11) NOT NULL,  --最后回复用户
  CONSTRAINT fk_topic_user FOREIGN KEY (tuid) REFERENCES user(uid),
  CONSTRAINT fk_topic_section FOREIGN KEY (tsid) REFERENCES section(sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--创建回复表
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `rtid` int(11) NOT NULL,            --回复的主题
  `ruid` int(11) NOT NULL,            --回复的用户
  `rsid` int(11) NOT NULL,            --回复的版块
  `RContent` text NOT NULL,           --回复的内容
  `RTime` datetime NOT NULL,          --回复的时间
  CONSTRAINT fk_reply_topic FOREIGN KEY (rtid) REFERENCES topic(tid),
  CONSTRAINT fk_reply_user FOREIGN KEY (ruid) REFERENCES user(uid),
  CONSTRAINT fk_reply_section FOREIGN KEY (rsid) REFERENCES section(sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

