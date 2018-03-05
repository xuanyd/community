drop database if exists xqgj;
create database xqgj;
use xqgj;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `sid` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `SManager` int NOT NULL,
  `SName` varchar(20) NOT NULL,
  `SContent` varchar(50) DEFAULT '',
  `SReplyCount` int,
  `SClickCount` int,
  `SLastReplyUser` int,
  `SLastReplyTime` datetime,
  CONSTRAINT fk_section_user FOREIGN KEY (SManager) REFERENCES user(uid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `tid` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `tuid` int(11) NOT NULL,
  `tsid` int(11) NOT NULL,
  `TReplyCount` int,
  `TTopic` varchar(10) NOT NULL, 
  `TContents` text NOT NULL,
  `TTime` datetime NOT NULL,
  `TClickCount` int,
  `TLastReplyTime` datetime NOT NULL,
  `TLastReplyUser` int(11) NOT NULL,
  CONSTRAINT fk_topic_user FOREIGN KEY (tuid) REFERENCES user(uid),
  CONSTRAINT fk_topic_section FOREIGN KEY (tsid) REFERENCES section(sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `rtid` int(11) NOT NULL, 
  `ruid` int(11) NOT NULL,
  `rsid` int(11) NOT NULL,
  `RContent` text NOT NULL,
  `RTime` datetime NOT NULL,
  CONSTRAINT fk_reply_topic FOREIGN KEY (rtid) REFERENCES topic(tid),
  CONSTRAINT fk_reply_user FOREIGN KEY (ruid) REFERENCES user(uid),
  CONSTRAINT fk_reply_section FOREIGN KEY (rsid) REFERENCES section(sid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

