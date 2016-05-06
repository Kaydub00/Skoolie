/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Chris
 * Created: May 3, 2016
 */

CREATE TABLE IF NOT EXISTS`USER_EVENTS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `END_DATE_TIME` datetime DEFAULT NULL,
  `NAME` varchar(140) DEFAULT NULL,
  `START_DATE_TIME` datetime DEFAULT NULL,
  `USER` tinyblob,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS`SCHOOL_EVENTS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `END_DATE_TIME` datetime DEFAULT NULL,
  `NAME` varchar(140) DEFAULT NULL,
  `START_DATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `DISTRICT_EVENTS` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `END_DATE_TIME` datetime DEFAULT NULL,
  `NAME` varchar(140) DEFAULT NULL,
  `START_DATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
