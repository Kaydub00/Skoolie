CREATE TABLE `USR_USER` (
  `USERNAME` VARCHAR(50) NOT NULL,
  `EMAIL` VARCHAR(180) DEFAULT NULL,
  `ENABLED` INT(11) DEFAULT NULL,
  `EXPIRATION` DATETIME DEFAULT NULL,
  `PASSWORD` VARCHAR(255) DEFAULT NULL,
  `TYPE` VARCHAR(40) DEFAULT NULL,
  PRIMARY KEY (`USERNAME`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


CREATE TABLE `USR_ROLES` (
  `ROLE` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ROLE`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


CREATE TABLE USR_GROUPS (
    `GROUP` VARCHAR(80) NOT NULL PRIMARY KEY
) ENGINE=INNODB DEFAULT CHARSET=latin1;

CREATE TABLE `USR_USER_ROLE` (
  `ROLE` VARCHAR(20) NOT NULL,
  `USERNAME` VARCHAR(50) NOT NULL,
  KEY `FK_8os6b9vcnq22ah18v7xsqo62r` (`USERNAME`),
  KEY `FK_62emrbqg8d8hv9fap8ujcabtu` (`ROLE`),
  CONSTRAINT `FK_62emrbqg8d8hv9fap8ujcabtu` FOREIGN KEY (`ROLE`) REFERENCES `USR_ROLES` (`ROLE`),
  CONSTRAINT `FK_8os6b9vcnq22ah18v7xsqo62r` FOREIGN KEY (`USERNAME`) REFERENCES `USR_USER` (`USERNAME`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


CREATE TABLE USR_GROUP_ROLES (
    `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `GROUP_ID` VARCHAR(80) NOT NULL,
    `ROLE` VARCHAR(20) NOT NULL,
    CONSTRAINT FOREIGN KEY (`ROLE`) REFERENCES `USR_ROLES` (`ROLE`),
    CONSTRAINT FOREIGN KEY (`GROUP_ID`) REFERENCES `USR_GROUPS` (`GROUP`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


CREATE TABLE `USR_USER_GROUP` (
  `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `USERNAME` VARCHAR(50) NOT NULL,
  `GROUP_ID` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `USERNAME` (`USERNAME`),
  KEY `GROUP_ID` (`GROUP_ID`),
  CONSTRAINT `USR_USER_GROUP_ibfk_1` FOREIGN KEY (`USERNAME`) REFERENCES `USR_USER` (`USERNAME`) ON DELETE CASCADE,
  CONSTRAINT `USR_USER_GROUP_ibfk_2` FOREIGN KEY (`GROUP_ID`) REFERENCES `USR_GROUPS` (`GROUP`)
) ENGINE=INNODB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


INSERT INTO USR_USER
(USERNAME, PASSWORD, EMAIL, ENABLED)
VALUES
('admin','$2a$10$f6KnNYdq6omzg0pXaXpNfOchfCs1wG0wC3PYl5S25WGgVxIxDJ/oi','admin@gmail.com',1);

INSERT INTO USR_ROLES
VALUES
('ROLE_USER'),
('ROLE_USER_READ'),
('ROLE_USER_WRITE'),
('ROLE_ADMIN'),
('ROLE_ADMIN_READ'),
('ROLE_ADMIN_WRITE');

INSERT INTO USR_GROUPS (`GROUP`) VALUES
('GRP_ADMIN'),
('GRP_USER');

INSERT INTO USR_GROUP_ROLES (GROUP_ID,ROLE)
VALUES 
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_ADMIN') ,'ROLE_ADMIN'),
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_ADMIN') ,'ROLE_ADMIN_READ'),
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_ADMIN') ,'ROLE_ADMIN_WRITE'),
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_USER') ,'ROLE_USER'),
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_USER') ,'ROLE_USER_READ'),
((SELECT `GROUP` FROM USR_GROUPS G WHERE G.GROUP = 'GRP_USER') ,'ROLE_USER_WRITE');

INSERT INTO USR_USER_ROLE
(`USERNAME`,`ROLE`)
VALUES
('admin','ROLE_USER');

INSERT INTO USR_USER_GROUP (USERNAME, GROUP_ID)
VALUES
('admin','GRP_ADMIN'),
('admin','GRP_USER');