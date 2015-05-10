-- Create testing table in Mysql
--table user
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--table role
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--middle table userrole
CREATE TABLE `userrole` (
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `updated` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--testing data for user table
INSERT INTO user (name,updated) VALUES ('Michael',STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r'));
INSERT INTO user (name,updated) VALUES ('John',STR_TO_DATE('5/15/2013 8:06:26 AM', '%c/%e/%Y %r'));
INSERT INTO user (name,updated) VALUES ('David',STR_TO_DATE('5/1/2013 8:06:26 AM', '%c/%e/%Y %r'));
INSERT INTO user (name,updated) VALUES ('Tom',STR_TO_DATE('5/15/2014 8:06:26 AM', '%c/%e/%Y %r'));
INSERT INTO user (name,updated) VALUES ('Smith',STR_TO_DATE('5/15/2015 8:06:26 AM', '%c/%e/%Y %r'));
--testing data for role table
INSERT INTO role (name,updated) VALUES ('Admin',STR_TO_DATE('5/15/2012 8:06:26 AM', '%c/%e/%Y %r'));
INSERT INTO role (name,updated) VALUES ('SuperUser',STR_TO_DATE('5/15/2013 8:06:26 AM', '%c/%e/%Y %r'));
INSERT INTO role (name,updated) VALUES ('User',STR_TO_DATE('5/1/2013 8:06:26 AM', '%c/%e/%Y %r'));
--testing data for user-role mapping
insert into userrole (userid, roleid) values (1, 1);
insert into userrole (userid, roleid) values (2, 2);
insert into userrole (userid, roleid) values (2, 3);
insert into userrole (userid, roleid) values (3, 3);
insert into userrole (userid, roleid) values (4, 3);
insert into userrole (userid, roleid) values (5, 3);