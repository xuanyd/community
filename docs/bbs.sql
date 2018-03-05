drop database if exists xqgj;
create database xqgj;
use xqgj;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(20) NOT NULL UNIQUE,
  `UserPasswd` varchar(100) NOT NULL,
  `UserEmail` varchar(30) NOT NULL,
  `HeadUrl` varchar(100),
  `UserPhone` varchar(20),
  `Birthday` varchar(10),
  `Sex` int NOT NULL,
  `UserStatement` varchar(50),
  `UserRegData` datetime NOT NULL,
  `UserPoint` int,
  `SManager` int  
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `SManager` int NOT NULL,
  `SName` varchar(20) NOT NULL,
  `SContent` varchar(50) DEFAULT '',
  `SReplyCount` int,
  `SClickCount` int,
  `SLastReplyUser` int,
  `SLastReplyTime` datetime,
  PRIMARY KEY (`sid`),
  FOREIGN KEY SManager REFRENCES user(uid)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `tid` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `tsid` int(11) NOT NULL,
  `tuid` int(11) NOT NULL,
  `TReplyCount` int,
  `TTopic` varchar(10) NOT NULL, 
  `TContents` text NOT NULL,
  `TTime` datetime NOT NULL,
  `TClickCount` int,
  `TLastReplyTime` datatime,
  `TLastReplyUser` int,
  FOREIGN KEY tsid REFENCES section(sid)
  FOREIGN KEY tuid REFENCES user(uid)
  FOREIGN KEY TLastReplyUser REFENCES user(uid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rtid` int(11) NOT NULL, 
  `rsid` int(11) NOT NULL,
  `ruid` int(11) NOT NULL,
  `RContent` text NOT NULL,
  `RTime` datetime NOT NULL,
  FOREIGN KEY rtid REFENCES topic(tid)
  FOREIGN KEY rsid REFENCES section(sid)
  FOREIGN KEY ruid REFENCES user(uid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
