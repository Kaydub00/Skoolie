/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Kevin W
 * Created: Mar 26, 2016
 */

CREATE TABLE `SCL_SCHOOL` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(180) DEFAULT NULL,
  `NAME` varchar(180) DEFAULT NULL,
  `PHONE` varchar(180) DEFAULT NULL,
  `POSTAL` varchar(180) DEFAULT NULL,
  `STATE` varchar(180) DEFAULT NULL,
  `CITY` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

